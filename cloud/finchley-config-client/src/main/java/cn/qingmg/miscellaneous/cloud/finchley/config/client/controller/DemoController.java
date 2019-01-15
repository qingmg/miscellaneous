package cn.qingmg.miscellaneous.cloud.finchley.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试控制层
 * @Author vhs
 * @Date 2019-01-15
 * @Version 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Value("${spring.application.name}")
    String name;
    @Value("${word}")
    String word;

    @RequestMapping("/hi")
    public String hi() {
        return word + " " + name;
    }
}
