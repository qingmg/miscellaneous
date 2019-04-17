package cn.qingmg.miscellaneous.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 登陆控制层
 * @Author vhs
 * @Date 2019-04-12
 * @Version 1.0
 */
@Controller
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, boolean rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            try {
                subject.login(token);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return "login";
            }
            return "redirect:index";
        }
        return "login";
    }

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return "首页";
    }
}
