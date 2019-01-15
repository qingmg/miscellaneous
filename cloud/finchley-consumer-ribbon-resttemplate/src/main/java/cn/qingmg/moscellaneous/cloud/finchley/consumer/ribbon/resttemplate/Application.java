package cn.qingmg.moscellaneous.cloud.finchley.consumer.ribbon.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 服务消费者（使用 Ribbon 和 RestTemplate 实现）
 *  @EnableDiscoveryClient: 等效于 @EnableEurekaClient，都是向 服务注册中心 进行注册服务
 *      当注册中心为 Eureka 时，使用 @EnableEurekaClient
 *      当注册中心为 其他 时，则使用 @EnableDiscoveryClient
 *  @LoadBalanced: 为注解的 RestTemplate 开启负载均衡
 *  @EnableHystrix: 注解开启Hystrix：
 * @Author vhs
 * @Date 2018-12-03
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class Application extends SpringBootServletInitializer {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
