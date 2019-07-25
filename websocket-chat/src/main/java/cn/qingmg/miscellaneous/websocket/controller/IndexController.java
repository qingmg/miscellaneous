package cn.qingmg.miscellaneous.websocket.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * @Description 页面跳转之类的
 * @Author vhs
 * @Date 2019-07-25
 * @Version 1.0
 */
@RestController
public class IndexController {

    /**
     * 登陆界面
     */
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    /**
     * 主界面 - 聊天界面
     */
    @GetMapping("/index")
    public ModelAndView index(String username, String password, HttpServletRequest request) throws Exception {
        if (StringUtils.isBlank(username)) {
            username = "匿名用户";
        }
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("username", username);
        mv.addObject("wsUrl", "ws://" + InetAddress.getLocalHost().getHostAddress() + ":" + request.getServerPort() + request.getContextPath() + "/chat");
        return mv;
    }
}
