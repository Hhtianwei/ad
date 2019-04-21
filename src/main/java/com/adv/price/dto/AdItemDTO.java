package com.adv.price.dto;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * A SysUser.
 */
@Data
public class AdItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //内容
    private String content;

    //规格
    private String specification;

    //数量
    private Integer num;

    //平米
    private Double size;

    //材料
    private String material;

    //单价
    private Double unitPrice;

    //总价价
    private Double totalPrice;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private String createTimeString;
    private String totalPriceString;
    private String unitPriceString;
}
