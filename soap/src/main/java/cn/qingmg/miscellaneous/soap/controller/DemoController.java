package cn.qingmg.miscellaneous.soap.controller;

import cn.qingmg.miscellaneous.common.entity.HttpResult;
import cn.qingmg.miscellaneous.soap.service.DemoService;
import com.alibaba.fastjson.JSON;
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
        return JSON.parseObject(demoService.test(), HttpResult.class);
    }

    @RequestMapping("/testStr")
    public HttpResult testStr(String str) {
        return JSON.parseObject(demoService.testStr(str), HttpResult.class);
    }

}
