package cn.qingmg.miscellaneous.shiro.controller;

import cn.qingmg.miscellaneous.shiro.pojo.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description 登陆控制层
 * @Author vhs
 * @Date 2019-04-12
 * @Version 1.0
 */
@Controller
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request, Map map) {
        map.put("username", request.getSession().getAttribute("username"));
        map.put("password", request.getSession().getAttribute("password"));
        map.put("rememberMe", request.getSession().getAttribute("rememberMe"));
        map.put("message", request.getSession().getAttribute("message"));
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username, String password, boolean rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            try {
                subject.login(token);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("password", password);
                request.getSession().setAttribute("rememberMe", rememberMe);
                request.getSession().setAttribute("message", e.getMessage());
                return "redirect:toLogin";
            }
            return "redirect:index";
        }
        return "redirect:index";
    }

    @ResponseBody
    @RequestMapping("/index")
    public String index(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("nickName", user.getNickName());
        return "这是首页, 你好, " + user.getNickName();
    }
}
