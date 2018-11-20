package cn.jxdog.miscellaneous.soap.controller;

import cn.jxdog.miscellaneous.common.entity.HttpResult;
import cn.jxdog.miscellaneous.soap.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/12 11:46
 * @Version 1.0
 */
@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/test")
    public HttpResult test() {
        return demoService.test();
    }

    @RequestMapping("/testStr")
    public HttpResult testStr(String str) {
        return demoService.testStr(str);
    }

}
