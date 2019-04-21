package com.adv.price.service;

import com.adv.price.dto.SysUserDTO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service("userDetailsService")
public class DefaultUserDetailsService implements UserDetailsService {

    private final SysUserService sysUserService;

    private final PasswordEncoder passwordEncoder;

    public DefaultUserDetailsService(SysUserService sysUserService, PasswordEncoder passwordEncoder) {
        this.sysUserService = sysUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username != null){
            Set set = new HashSet();
            set.add(new SimpleGrantedAuthority("ROLE_USER"));
            UserDetails user2 = new User("u",passwordEncoder.encode("1"),true,true,true,true,set);
            return user2;
        }
        Optional<SysUserDTO> userOptional = sysUserService.findUserByUserName(username);
        if(!userOptional.isPresent()){
            throw new RuntimeException(String.format("user not found by usrename %s",username));
        }
        SysUserDTO userDTO = userOptional.get();
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails user = new User(userDTO.getUserName(),userDTO.getPassword(),userDTO.getEnabled(),true,true,true,authorities);
        return user;
    }

}
