package com.nikoyo.springcloud.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{
    //部门编号
    private Long deptNo;
    //部门名称
    private String dname;
    //来自哪个数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDb_source("123").setDeptNo(12L).setDname("ceshi ");
        System.out.println("测试lombok");
        System.out.println(dept);

    }

}
