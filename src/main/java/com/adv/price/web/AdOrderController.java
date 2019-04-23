package com.adv.price.web;

import com.adv.price.data.Datagrid;
import com.adv.price.dto.AdItemDTO;
import com.adv.price.dto.AdOrderDTO;
import com.adv.price.dto.Result;
import com.adv.price.service.AdItemService;
import com.adv.price.service.AdOrderService;
import com.adv.price.util.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/order")
public class AdOrderController {

    private final AdOrderService adOrderService;

    private final AdItemService adItemService;

    public AdOrderController(AdOrderService adOrderService, AdItemService adItemService) {
        this.adOrderService = adOrderService;
        this.adItemService = adItemService;
    }

    @RequestMapping("/listPage")
    public String adOrderList(){
        return "orderList";
    }

    /**
     *列表
     * @return
     */
    @RequestMapping(value = "/list",method = {RequestMethod.GET})
    public void items(HttpServletResponse response,  @RequestParam(value = "page", required = false) Integer page,
                      @RequestParam(value = "rows", required = false) Integer rows){

        Pageable pageable = new PageRequest(page-1, rows, Sort.Direction.ASC, "id");
        Page<AdOrderDTO> all = adOrderService.findAll(pageable);

        Datagrid datagrid = new Datagrid();
        datagrid.setRows(all.getContent());
        datagrid.setTotal(all.getTotalElements());

        GsonUtil.writeJson(GJsonUtil.toJson(datagrid), response);
    }

    @RequestMapping(value = "/create",method = {RequestMethod.POST})
    @ResponseBody
    public Result create(@RequestBody AdOrderDTO adOrderDTO) {
        AdOrderDTO adOrderResult = adOrderService.save(adOrderDTO);
        return ResultUtil.success(adOrderResult);
    }

    @RequestMapping(value = "/download/{id}",method = {RequestMethod.GET})
    public void download(@PathVariable Long id, HttpServletRequest request,HttpServletResponse response) {
        Optional<AdOrderDTO> optional = adOrderService.findById(id);
        Set<AdItemDTO> items = adItemService.findByOrderId(id);
        //Set<AdItemDTO> items = optional.get().getItems();
        ViewExcelResource viewExcel = new ViewExcelResource("order.xls");
        final Map<String,String> headers= new HashMap<>();
        headers.put("content","内容");
        headers.put("specification","规格");
        headers.put("num","数量");
        headers.put("size","平米");
        headers.put("material","材料");
        headers.put("createTimeString","创建时间");
        headers.put("totalPriceString","总价");
        headers.put("unitPriceString","单价");

        HSSFWorkbook workbook= ICExcelUtil.createExcel(headers, items,"");
        try {
            viewExcel.buildExcelDocument(null,workbook,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/remove",method = {RequestMethod.DELETE})
    @ResponseBody
    public Result remove(@RequestBody Long[] ids) {
        System.out.println("ids:" + ids);
        adOrderService.removes(ids);
        return ResultUtil.success();
    }

}
