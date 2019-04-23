package com.adv.price.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GANG CHEN on 2018/9/3.
 */

@Getter
@Setter
public class ExcelLogs {
    private Boolean hasError;
    private List<ExcelLog> logList;


    public ExcelLogs() {
        super();
        hasError = false;
    }

    public List<ExcelLog> getErrorLogList() {
        List<ExcelLog> errList = new ArrayList<>();
        for (ExcelLog log : this.logList) {
            if (log != null && StringUtils.isNotBlank(log.getLog())) {
                errList.add(log);
            }
        }
        return errList;
    }

    public List<ExcelLog> initialErrorList(){
        this.logList= new ArrayList<ExcelLog>();
        return logList;
    }


}
