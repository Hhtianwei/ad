package com.adv.price.repository;

import com.adv.price.domain.SysUser;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    Optional<SysUser> findByUserName(String username);
}
