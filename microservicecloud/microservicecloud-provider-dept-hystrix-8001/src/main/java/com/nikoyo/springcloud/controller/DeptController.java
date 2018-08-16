package com.nikoyo.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nikoyo.springcloud.entity.Dept;
import com.nikoyo.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DeptController
{
	@Autowired
	private DeptService service;


	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id)
	{
		Dept dept = service.get(id);
		if(dept == null){
			throw new RuntimeException("NullPointException");
		}
		return dept;
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id){
		return new Dept().setDeptNo(id).setDname("该ID"+id+"没有对应的信息，null--@HystrixCommand").setDb_source("no database");

	}


	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}


}
