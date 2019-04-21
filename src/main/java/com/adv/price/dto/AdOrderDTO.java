package com.adv.price.dto;

import com.adv.price.domain.AdItem;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
public class AdOrderDTO implements Serializable {
    private Long id;
    private String name;
    private Double totalPrice;
    private Date createTime;

    private String createTimeString;
    private String totalPriceString;

    private Boolean enabled;
    private Set<AdItemDTO> items;
}
