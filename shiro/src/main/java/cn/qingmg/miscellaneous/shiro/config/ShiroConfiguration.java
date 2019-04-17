package cn.qingmg.miscellaneous.shiro.config;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description Shiro配置类
 * @Author vhs
 * @Date 2019-04-10
 * @Version 1.0
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public MyRealm realm() {
        return new MyRealm();
    }

    /**
     * Cookie 对象 - 记住我
     */
    public SimpleCookie rememberMeCookie() {
        // cookie 名称, 对应前端的 checkbox name
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 有效时间, 单位: 秒
        cookie.setMaxAge(30 * 12 * 60 * 60);
        return cookie;
    }

    /**
     * Cookie 管理对象 - 记住我功能
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCookie(rememberMeCookie());
        // rememberMe cookie 加密密钥, 默认 AES算法
        manager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return manager;
    }

    /**
     * 权限管理器
     */
    public WebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // realm
        manager.setRealm(realm());
        // session
//        manager.setSessionManager();
        // 缓存
//        manager.setCacheManager();
        // 记住我
        manager.setRememberMeManager(rememberMeManager());
        return manager;
    }

    /**
     * 规则
     */
    @Bean
    public ShiroFilterFactoryBean filter() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 设置 SecurityManager
        factoryBean.setSecurityManager(securityManager());

        // 登陆界面
        factoryBean.setLoginUrl("/toLogin");
        // 登陆成功跳转界面
        factoryBean.setSuccessUrl("/index");
        // 未授权界面
        factoryBean.setUnauthorizedUrl("/403");

        // 拦截器
        Map<String, String> filters = new HashMap<>();
        // 退出登陆
        filters.put("/logout", "logout");
        /*
         * 第一组认证过滤器:
         * anon  匿名访问
         * authc 需要登陆认证通过
         * user  记住我 / 认证通过
         *
         * 第二组认证过滤器:
         * perms 需要 "" 权限, 逗号分隔
         * roles 需要 "" 角色, 逗号分隔
         *
         * 例子:
         * /edit  = authc,perms[admin:edit]
         * /admin = authc,roles["admin","user"]
         */
        filters.put("/login", "anon");
        filters.put("/static/**", "anon");
        filters.put("/**", "authc");

        factoryBean.setFilterChainDefinitionMap(filters);
        return factoryBean;
    }
}
