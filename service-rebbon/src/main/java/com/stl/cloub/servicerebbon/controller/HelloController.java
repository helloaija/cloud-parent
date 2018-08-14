package com.stl.cloub.servicerebbon.controller;

import com.stl.cloub.servicerebbon.service.HelloService;
import com.stl.cloub.servicerebbon.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/helloPort")
    public String helloPort() {
        return helloService.helloPort();
    }
}
