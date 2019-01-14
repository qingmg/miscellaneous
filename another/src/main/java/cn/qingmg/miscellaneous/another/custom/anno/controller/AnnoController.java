package cn.qingmg.miscellaneous.another.custom.anno.controller;

import cn.qingmg.miscellaneous.another.custom.anno.ShowLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/10/22 11:12
 * @Version 1.0
 */
@RestController
public class AnnoController {

    @ShowLog("Its ShowLogs demo")
    @RequestMapping("/test1")
    public String testShowLog() {
        return "success";
    }
}
