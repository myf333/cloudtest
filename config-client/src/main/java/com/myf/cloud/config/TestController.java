package com.myf.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by myf on 2017/11/27.
 */
@RefreshScope
@RestController
public class TestController {
    @Value("${from}")
    private String from;

    @Autowired
    private Environment environment;

    @RequestMapping("/from")
    public String test(){
        return this.from;
    }

    @RequestMapping("/from-env")
    public String test_env(){
        return environment.getProperty("from","undefined");
    }
}
