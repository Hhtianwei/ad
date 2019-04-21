package com.adv.price.service.mapper;

import com.adv.price.domain.SysUser;
import com.adv.price.dto.SysUserDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity SysUser and its DTO SysUserDTO.
 */
@Mapper(componentModel = "spring")
public interface SysUserMapper extends EntityMapper<SysUserDTO, SysUser> {

    default SysUser fromId(Long id) {
        if (id == null) {
            return null;
        }
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        return sysUser;
    }
}
