package com.adv.price.service.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class SubService extends BaseService implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        String name = "sub class hello world";
        super.setName(name);
    }

}
