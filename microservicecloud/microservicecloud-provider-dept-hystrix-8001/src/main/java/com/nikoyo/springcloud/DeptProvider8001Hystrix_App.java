package com.nikoyo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//eureka注册
@EnableCircuitBreaker//对Hystrix熔断机制支持
public class DeptProvider8001Hystrix_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptProvider8001Hystrix_App.class, args);
	}
}
