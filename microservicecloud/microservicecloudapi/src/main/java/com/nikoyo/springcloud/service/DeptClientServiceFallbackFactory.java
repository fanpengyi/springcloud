package com.nikoyo.springcloud.service;

import com.nikoyo.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptNo(id).setDname("该ID" + id + "没有对应的信息，Consumer客户端提供的降级信息，此刻服务Provider已经停止服务").setDb_source("no database");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Boolean add(Dept dept) {
                return false;
            }
        } ;
    }


}
