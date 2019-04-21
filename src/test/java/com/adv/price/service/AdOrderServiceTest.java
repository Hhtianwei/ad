package com.adv.price.service;

import com.adv.price.domain.AdItem;
import com.adv.price.dto.AdItemDTO;
import com.adv.price.dto.AdOrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdOrderServiceTest {

    @Resource
    private AdOrderService adOrderService;

    @Resource
    private AdItemService adItemService;

    @Test
    public void findAll() {
        List<AdOrderDTO> all = adOrderService.findAll();
        System.out.println(all);
    }

    @Test
    public void removes() {
    }
}