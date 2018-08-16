package com.stl.cloub.serviceribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stl.cloub.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloPortError")
    public String helloPort() {
        return restTemplate.getForObject("http://EUREKACLIENT/hello/helloPort", String.class);
    }

    public String helloPortError() {
        return "hello port error";
    }
}
