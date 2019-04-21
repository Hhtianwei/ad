package com.adv.price.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the SysUser entity.
 */
@Data
public class SysUserDTO implements Serializable {

    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    private Boolean enabled;

    private Date createTime;

    private Date updateTime;

}
