package com.stl.cloud.servicefeign.service.impl;

import com.stl.cloud.servicefeign.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String helloPort() {
        return "hello port failure";
    }
}
