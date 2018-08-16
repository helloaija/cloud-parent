package com.stl.cloud.servicefeign.service;

import com.stl.cloud.servicefeign.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="eurekaClient", fallback = HelloServiceImpl.class)
public interface HelloService {

    @RequestMapping(value="/hello/helloPort")
    public String helloPort();
}
