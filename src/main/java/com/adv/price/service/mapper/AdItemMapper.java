package com.adv.price.service.mapper;

import com.adv.price.domain.AdItem;
import com.adv.price.domain.SysUser;
import com.adv.price.dto.AdItemDTO;
import com.adv.price.dto.SysUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity SysUser and its DTO SysUserDTO.
 */
@Mapper(componentModel = "spring")
public interface AdItemMapper extends EntityMapper<AdItemDTO, AdItem> {

    @Mapping(target = "order", ignore = true)
    @Override
    AdItem toEntity(AdItemDTO dto);

    default AdItem fromId(Long id) {
        if (id == null) {
            return null;
        }
        AdItem adItem = new AdItem();
        adItem.setId(id);
        return adItem;
    }
}
