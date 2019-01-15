package cn.qingmg.miscellaneous.cloud.finchley.consumer.feign.controller;

import cn.qingmg.miscellaneous.cloud.finchley.consumer.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 控制层代码
 * @Author vhs
 * @Date 2018-12-05
 * @Version 1.0
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;
    @Autowired
    Environment env;

    @RequestMapping("/show")
    public String show() {
        return helloService.show();
    }

    @RequestMapping("/hello")
    public String hello(String name) {
        return helloService.sayHello(name);
    }

    @RequestMapping("/hi")
    public String hi() {
        return helloService.sayHello(env.getProperty("spring.application.name"));
    }
}
