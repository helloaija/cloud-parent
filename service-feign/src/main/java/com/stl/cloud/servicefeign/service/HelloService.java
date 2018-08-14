package com.stl.cloud.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="eurekaClient")
public interface HelloService {

    @RequestMapping(value="/hello/helloPort")
    public String helloPort();
}
