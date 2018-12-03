package cn.jxdog.miscellaneous.cloud.finchley.client.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 服务提供者
 * @Author vhs
 * @Date 2018-11-30
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping("/show")
    public String show() {
        return "this is eureka-client, port is " + port;
    }
}
