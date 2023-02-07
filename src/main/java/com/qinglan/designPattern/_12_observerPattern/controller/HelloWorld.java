package com.qinglan.designPattern._12_observerPattern.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 熊保林
 */
@RestController
@RequestMapping("/weather")
public class HelloWorld {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello 青岚";
    }


}
