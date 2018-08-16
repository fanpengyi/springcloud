package com.nikoyo.springcloud.controller;


import com.nikoyo.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ribbon.rule.myrule.MySelfRule;

import java.util.List;

@RestController
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptController_Consumer{

	//private static final String REST_URL_PREFIX="http://localhost:8001";
	private static final String REST_URL_PREFIX="http://microservicecloud-dept";

/*
	ribbon 是客户端的负载均衡

	使用restTemplate 访问restful接口非常简单粗暴无脑
			（url,requestMap,responseBean.class） 三个参数
	代表   Rest请求地址，请求参数，HTTP响应转换成的对象类型*/


	@Autowired
	private RestTemplate restTemplate;


	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);

	}


	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);

	}

	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);

	}


}

