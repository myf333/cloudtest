package com.myf.cloud.feignconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by myf on 2017/11/15.
 */
@FeignClient("HELLO-SERVICE")
public interface HelloService {
    @RequestMapping("/hello")
    String hello();
}
