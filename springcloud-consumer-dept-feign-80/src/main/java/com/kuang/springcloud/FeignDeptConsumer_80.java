package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignDeptConsumer_80 {
    /*
        服务熔断： 服务提供方。 某个服务超时或异常，引起熔断。在Java中，每一个HTTP请求都会开启一个新线程。
            而下游服务挂了或者网络不可达，通常线程会阻塞住，直到Timeout。
            如果并发量多一点，这些阻塞的线程就会占用大量的资源，很有可能把自己本身这个微服务所在的机器资源耗尽，导致自己也挂掉。（雪崩效应）

        服务降级： 服务消费方。 从整体网站请求负载考虑，当某个服务熔断或关闭后，服务不再被调用。但是请求不走服务提供方了，此时在服务消费方
            通过FallbackFactory返回一个缺省值。

     */
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class, args);
    }
}
