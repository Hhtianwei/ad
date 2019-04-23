package com.adv.price.service;

import com.adv.price.domain.AdItem;
import com.adv.price.domain.AdOrder;
import com.adv.price.dto.AdItemDTO;
import com.adv.price.repository.AdItemRepository;
import com.adv.price.service.mapper.AdItemMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class AdItemService {

    private final AdItemMapper adItemMapper;

    private final AdItemRepository adItemRepository;

    public AdItemService(AdItemMapper adItemMapper, AdItemRepository adItemRepository) {
        this.adItemMapper = adItemMapper;
        this.adItemRepository = adItemRepository;
    }

    public AdItemDTO save(AdItemDTO adItemDTO){
        adItemDTO.setCreateTime(new Date());
        AdItem adItem = adItemMapper.toEntity(adItemDTO);
        AdItem adItemResult = adItemRepository.save(adItem);
        return adItemMapper.toDto(adItemResult);
    }

    public Page<AdItemDTO> findAll(Pageable pageable){
        Page<AdItemDTO> map = adItemRepository.findByOrOrderNull(pageable).map(adItemMapper::toDto);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        map.forEach(dto -> {
            converDateAndPrice(sdf, dto);
        });
        return map;
    }

    private void converDateAndPrice(SimpleDateFormat sdf, AdItemDTO dto) {
        Date createTime = dto.getCreateTime();
        String format = sdf.format(createTime);
        dto.setCreateTimeString(format);
        DecimalFormat df = new DecimalFormat("#0.00");
        String str = df.format(dto.getTotalPrice());
        String unitPrice = df.format(dto.getUnitPrice());
        dto.setUnitPriceString(unitPrice);
        dto.setTotalPriceString(str);
    }

    public Optional<AdItemDTO> findById(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return adItemRepository.findById(id).map(adItemMapper::toDto).map(dto -> {
            Date createTime = dto.getCreateTime();
            String format = sdf.format(createTime);
            dto.setCreateTimeString(format);
            DecimalFormat df = new DecimalFormat("#0.00");
            String str = df.format(dto.getTotalPrice());
            String unitPrice = df.format(dto.getUnitPrice());
            dto.setUnitPriceString(unitPrice);
            dto.setTotalPriceString(str);
            return dto;
        });
    }

    public Set<AdItemDTO> findByOrderId(Long orderId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        AdOrder adOrder = new AdOrder();
        adOrder.setId(orderId);
        List<AdItem> byOrOrderById = adItemRepository.findByOrderEquals(adOrder);
        Set<AdItemDTO> collect = byOrOrderById.stream().map(adItemMapper::toDto).collect(Collectors.toSet());
        collect.forEach((AdItemDTO dto) -> {
            converDateAndPrice(sdf, dto);
        });
        return collect;
    }

    public List<AdItemDTO> findByIds(Long[] ids){
        List<AdItem> allById = findAllByIds(ids);
        return adItemMapper.toDto(allById);
    }

    public List<AdItem> findAllByIds(Long[] ids){
        List<Long> longs = Arrays.asList(ids);
        List<AdItem> allById = adItemRepository.findAllById(longs);
        return allById;
    }

    public void removes(Long[] ids) {
        Stream.of(ids).forEach(adItemRepository::deleteById);
    }

    public List<AdItemDTO> saveAll(List<AdItem> collect) {
        List<AdItem> adItems = adItemRepository.saveAll(collect);
        return adItemMapper.toDto(adItems);
    }
}
