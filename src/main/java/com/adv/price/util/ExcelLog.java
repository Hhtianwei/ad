package com.adv.price.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by GANG CHEN on 2018/9/3.
 */

@Setter
@Getter
public class ExcelLog {
    private Integer rowNum;
    private Object object;
    private String log;
    /**
     * @param object
     * @param log
     */
    public ExcelLog(Object object, String log) {
        super();
        this.object = object;
        this.log = log;
    }

    /**
     * @param rowNum
     * @param object
     * @param log
     */
    public ExcelLog(Object object, String log, Integer rowNum) {
        super();
        this.rowNum = rowNum;
        this.object = object;
        this.log = log;
    }


}
