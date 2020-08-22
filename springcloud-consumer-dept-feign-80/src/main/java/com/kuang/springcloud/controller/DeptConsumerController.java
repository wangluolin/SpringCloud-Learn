package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class DeptConsumerController {

    // 理解：消费者，不应该有service~
    // 支持Restful风格请求 RestTemplate ... 供我们直接调用就可以！

    @Autowired
    private RestTemplate restTemplate; // 提供多种便捷访问远程http服务的方法，简单的Restful服务模板

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return deptClientService.queryById(id);
    }

    @RequestMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/dept/list")
    public List<Dept> list(){
        return deptClientService.queryAll();
    }



}
