package com.adv.price.web;

import com.adv.price.data.Datagrid;
import com.adv.price.domain.AdItem;
import com.adv.price.dto.AdOrderDTO;
import com.adv.price.dto.Result;
import com.adv.price.service.AdOrderService;
import com.adv.price.util.GJsonUtil;
import com.adv.price.util.GsonUtil;
import com.adv.price.util.ResultUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/order")
public class AdOrderController {

    private final AdOrderService adOrderService;

    public AdOrderController(AdOrderService adOrderService) {
        this.adOrderService = adOrderService;
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


    @RequestMapping(value = "/remove",method = {RequestMethod.DELETE})
    @ResponseBody
    public Result remove(@RequestBody Long[] ids) {
        System.out.println("ids:" + ids);
        adOrderService.removes(ids);
        return ResultUtil.success();
    }

}
