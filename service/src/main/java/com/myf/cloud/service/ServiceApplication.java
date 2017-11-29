package com.myf.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceApplication {
	private Logger logger = Logger.getLogger("ServiceApplication");
	@Autowired
	private DiscoveryClient discoveryClient;
	@Value("${spring.application.name}")
	private String serviceId;

	@RequestMapping("/hello")
	public String hello(){
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
		instances.forEach((instance)-> logger.info("host:"+instance.getHost()+",serviceId:"+instance.getServiceId()));
		List<String> services = discoveryClient.getServices();
		services.forEach(logger::info);
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
