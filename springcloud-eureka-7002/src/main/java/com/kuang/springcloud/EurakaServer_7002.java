package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaServer // 服务端的启动类
public class EurakaServer_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurakaServer_7002.class, args);
//        Scanner scanner = new Scanner(System.in);
//        String port  = scanner.nextLine();
//
//        new SpringApplicationBuilder(EurakaServer_7002.class).properties("server.port="+port).run(args);
    }
}
