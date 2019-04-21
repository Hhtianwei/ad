package com.adv.price.service;

import com.adv.price.dto.SysUserDTO;
import com.adv.price.repository.SysUserRepository;
import com.adv.price.service.mapper.SysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SysUserService {

    private final SysUserRepository sysUserRepository;

    private final SysUserMapper sysUserMapper;

    public SysUserService(SysUserRepository sysUserRepository, SysUserMapper sysUserMapper) {
        this.sysUserRepository = sysUserRepository;
        this.sysUserMapper = sysUserMapper;
    }

    public Optional<SysUserDTO> findUserByUserName(String name){
        return sysUserRepository.findByUserName(name).map(sysUserMapper::toDto);
    }

}
