package com.adv.price.dto;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private Boolean success = Boolean.FALSE;
    private T data;
    private String errorMsg;
}
