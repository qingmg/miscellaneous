package cn.qingmg.miscellaneous.cloud.finchley.config.client.bus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 消息总线客户端启动类
 * @Author vhs
 * @Date 2019-01-15
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${word}")
    private String word;

    @RequestMapping("/hi")
    public String hi() {
        return word;
    }
}
