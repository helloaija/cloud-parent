package com.stl.cloud.servicefeign.controller;

import com.stl.cloud.servicefeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value="/helloPort")
    public String helloPort() {
        return helloService.helloPort();
    }
}
