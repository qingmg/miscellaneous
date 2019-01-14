package cn.qingmg.moscellaneous.cloud.finchley.consumer.ribbon.resttemplate.controller;

import cn.qingmg.moscellaneous.cloud.finchley.consumer.ribbon.resttemplate.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 消费者控制层代码
 * @Author vhs
 * @Date 2018-12-04
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
