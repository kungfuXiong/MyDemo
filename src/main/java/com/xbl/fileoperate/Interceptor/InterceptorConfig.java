package com.xbl.fileoperate.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    HandlerInterceptorDemo handlerInterceptorDemo;
    @Autowired
    HandlerInterceptorDemo1 handlerInterceptorDemo1;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(handlerInterceptorDemo).addPathPatterns("/**");
        registry.addInterceptor(handlerInterceptorDemo1).addPathPatterns("/**");

        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
