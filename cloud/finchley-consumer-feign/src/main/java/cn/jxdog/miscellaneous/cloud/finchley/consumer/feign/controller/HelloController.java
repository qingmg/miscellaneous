package cn.jxdog.miscellaneous.cloud.finchley.consumer.feign.controller;

import cn.jxdog.miscellaneous.cloud.finchley.consumer.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/show")
    public String show() {
        return helloService.show();
    }

    @RequestMapping("/hello")
    public String hello(String name) {
        return helloService.sayHello(name);
    }
}
