package com.adv.price.util;


import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by GANG CHEN on 2018/9/3.
 */
public class ViewExcelResource extends AbstractXlsxView
{
    private String fileName;


    @Override
    public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception
    {
        byte[] fileNameByte = fileName.getBytes("UTF-8");
        String filename = new String(fileNameByte, "ISO8859-1");
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setHeader("Content-disposition", "attachment;filename=" + filename);
        OutputStream ouputStream = httpServletResponse.getOutputStream();
        workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }

    public ViewExcelResource(){

    }


    public ViewExcelResource(String fileName){
        this.fileName=fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
