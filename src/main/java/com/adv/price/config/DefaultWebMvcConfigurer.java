package com.adv.price.config;
/*
 * @author  hupanpan
 * @created date 2018/8/1
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
@Slf4j
public class DefaultWebMvcConfigurer implements WebMvcConfigurer, ServletContextInitializer {

    //上传文件大小设置
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");
        multipartResolver.setMaxUploadSize(10485760000L);
        multipartResolver.setMaxInMemorySize(40960);
        return multipartResolver;

    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        // jsp目录
        resolver.setPrefix("/views/jsp/");
        // 后缀
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }

}
