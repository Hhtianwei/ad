package com.adv.price.web;

import com.adv.price.data.Datagrid;
import com.adv.price.dto.AdItemDTO;
import com.adv.price.dto.Result;
import com.adv.price.service.AdItemService;
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

@Controller
@RequestMapping("/adItem")
public class AdItemController {

    private final AdItemService adItemService;

    public AdItemController(AdItemService adItemService) {
        this.adItemService = adItemService;
    }

    @RequestMapping("/adItemList")
    public String adItemList(){
        return "adItemList";
    }

    /**
     *列表
     * @return
     */
    @RequestMapping(value = "/list",method = {RequestMethod.GET})
    public void items(HttpServletResponse response,  @RequestParam(value = "page", required = false) Integer page,
                      @RequestParam(value = "rows", required = false) Integer rows){
        Pageable pageable = new PageRequest(page-1, rows, Sort.Direction.DESC, "id");
        System.out.println("load data items.....");
        Page<AdItemDTO> all = adItemService.findAll(pageable);
        Datagrid datagrid = new Datagrid();
        datagrid.setRows(all.getContent());
        datagrid.setTotal(all.getTotalElements());
        GsonUtil.writeJson(GJsonUtil.toJson(datagrid), response);
    }

    @RequestMapping(value = "/add",method = {RequestMethod.GET})
    public String addPage() {
        return "addAdItem";
    }

    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    @ResponseBody
    public Result add(@RequestBody AdItemDTO adItemDTO) {
        System.out.println("adItemDTO:" + adItemDTO);
        AdItemDTO itemDTO = adItemService.save(adItemDTO);
        return ResultUtil.success(itemDTO);
    }

    @RequestMapping(value = "/remove",method = {RequestMethod.DELETE})
    @ResponseBody
    public Result remove(@RequestBody Long[] ids) {
        System.out.println("ids:" + ids);
        adItemService.removes(ids);
        return ResultUtil.success();
    }

}
