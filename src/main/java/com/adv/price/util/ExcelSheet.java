package com.adv.price.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Map;

/**
 * Created by GANG CHEN on 2018/9/3.
 */
@Getter
@Setter
public class ExcelSheet<T> {
    private String sheetName;
    private Map<String,String> headers;
    private Collection<T> dataset;
}
