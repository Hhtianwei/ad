package com.adv.price.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceMain {

    @Resource
    private SubService subService;

    @Resource
    private BaseService baseService;

    @Test
    public void test(){
        subService.print();
        baseService.print();
    }

}
