package com.adv.price.service.mapper;

import com.adv.price.domain.AdItem;
import com.adv.price.domain.AdOrder;
import com.adv.price.dto.AdItemDTO;
import com.adv.price.dto.AdOrderDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity SysUser and its DTO SysUserDTO.
 */
@Mapper(componentModel = "spring")
public interface AdOrderMapper extends EntityMapper<AdOrderDTO, AdOrder> {

    default AdOrder fromId(Long id) {
        if (id == null) {
            return null;
        }
        AdOrder adOrder = new AdOrder();
        adOrder.setId(id);
        return adOrder;
    }
}
