package com.adv.price.service.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class BaseService implements InitializingBean {

    private String name;

    public void print(){
        System.out.println(this.getClass().getName() + " : " +this.getName());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "Base class hahahha";
    }
}
