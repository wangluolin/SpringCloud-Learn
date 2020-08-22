package com.kuang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Ribbon官方文档建议 该类在主类的包的外面
// 自定义ribbon不应该放到@ComponentScan下，否则会被所有的客户端共享，
@Configuration
public class KuangRule {

    // 使用随机策略
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
