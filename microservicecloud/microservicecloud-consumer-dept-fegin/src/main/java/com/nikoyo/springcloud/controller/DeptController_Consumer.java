package com.nikoyo.springcloud.controller;


import com.nikoyo.springcloud.entity.Dept;
import com.nikoyo.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer{
	@Autowired
	private DeptClientService deptService;


	@RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id){
		return deptService.get(id);

	}

	@RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
	public List<Dept> list(){
		return deptService.list();

	}

	@RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
	public Boolean add(Dept dept){
		return deptService.add(dept);

	}

}

