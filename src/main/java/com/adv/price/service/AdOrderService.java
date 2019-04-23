package com.adv.price.service;

import com.adv.price.domain.AdItem;
import com.adv.price.domain.AdOrder;
import com.adv.price.dto.AdItemDTO;
import com.adv.price.dto.AdOrderDTO;
import com.adv.price.repository.AdOrderRepository;
import com.adv.price.service.mapper.AdOrderMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class AdOrderService {

    private final AdItemService adItemService;
    private final AdOrderRepository adOrderRepository;
    private final AdOrderMapper adOrderMapper;

    public AdOrderService(AdItemService adItemService, AdOrderRepository adOrderRepository, AdOrderMapper adOrderMapper) {
        this.adItemService = adItemService;
        this.adOrderRepository = adOrderRepository;
        this.adOrderMapper = adOrderMapper;
    }

    @Transactional
    public AdOrderDTO save(AdOrderDTO adOrderDTO){
        Set<AdItemDTO> itemsTemp = adOrderDTO.getItems();
        Long[] ids = new Long[itemsTemp.size()];
        int index = 0;
        for (AdItemDTO item : itemsTemp) {
            ids[index++] = item.getId();
        }

        List<AdItem> items = adItemService.findAllByIds(ids);
        double sum = items.stream().mapToDouble(AdItem::getTotalPrice).sum();
        adOrderDTO.setTotalPrice(sum);
        adOrderDTO.setEnabled(true);
        adOrderDTO.setCreateTime(new Date());
        AdOrder adOrder = adOrderMapper.toEntity(adOrderDTO);
        items.stream().forEach(item -> item.setOrder(adOrder));

        AdOrder order = adOrderRepository.save(adOrder);
        adItemService.saveAll(items);
        return adOrderMapper.toDto(order);
    }

    public Page<AdOrderDTO> findAll(Pageable pageable){
        Page<AdOrderDTO> map = adOrderRepository.findAllByEnabledTrue(pageable).map(adOrderMapper::toDto);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        map.forEach(dto -> {
            Date createTime = dto.getCreateTime();
            String format = sdf.format(createTime);
            dto.setCreateTimeString(format);

            DecimalFormat df = new DecimalFormat("#0.00");
            String str = df.format(dto.getTotalPrice());
            dto.setTotalPriceString(str);

        });
        return map;
    }

    public List<AdOrderDTO> findAll(){
        List<AdOrder> all = adOrderRepository.findAll();
        return adOrderMapper.toDto(all);
    } 
    
    public Optional<AdOrderDTO> findById(Long id){
        Optional<AdOrder> orderOptional = adOrderRepository.findById(id);
        return orderOptional.map(adOrderMapper::toDto);
    }

    public void removes(Long[] ids) {
        List<Long> collect = Stream.of(ids).collect(Collectors.toList());
        List<AdOrder> allById = adOrderRepository.findAllById(collect);
        allById.stream().forEach(order -> order.setEnabled(false));
        adOrderRepository.saveAll(allById);
    }

}
