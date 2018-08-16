package com.stl.cloub.serviceribbon.controller;

import com.stl.cloub.serviceribbon.service.HelloService;
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
