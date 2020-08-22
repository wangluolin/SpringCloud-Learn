package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 提供Restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient; // 获取一些配置信息，得到具体的微服务

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> addDept(){
        return deptService.queryAll();
    }


    @GetMapping("/dept/discovery")
    public Object Discovery(){
        // 获取微服务列表的清单
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery => services:" + services);

        // 得到一个具体的微服务信息，通过具体的微服务ID，即applicationName
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT-8001");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t"
                    + instance.getPort() + "\t"
                    + instance.getUri() + "\t"
                    + instance.getServiceId());
        }

        return this.discoveryClient;

    }



}
