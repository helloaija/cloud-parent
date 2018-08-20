package com.stl.cloud.servicefeign.controller;

import com.stl.cloud.servicefeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Value("${configtest}")
    private String configTest;
    @Value("${message.title}")
    private String messageTitle;

    @RequestMapping(value = "/helloPort")
    public String helloPort() {
        return helloService.helloPort();
    }

    @RequestMapping(value = "/helloConfig")
    public String helloConfig() {
        return configTest + messageTitle;
    }
}
