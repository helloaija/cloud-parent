package com.stl.cloub.servicerebbon.service.impl;

import com.stl.cloub.servicerebbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String helloPort() {
        return restTemplate.getForObject("http://EUREKACLIENT/hello/helloPort", String.class);
    }

}
