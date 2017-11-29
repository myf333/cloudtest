package com.myf.cloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by myf on 2017/11/14.
 */
@RestController
public class ServiceController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello-service")
    public String hello(){
        return helloService.hello();
    }
}
