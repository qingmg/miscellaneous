package cn.qingmg.miscellaneous.cloud.finchley.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 过滤类
 * @Author vhs
 * @Date 2019-01-15
 * @Version 1.0
 */
@Slf4j
@Component
public class MyFilter extends ZuulFilter {

    /**
     * 返回一个字符串代表过滤器类型
     * pre:     路由前
     * routing: 路由中
     * post:    路由后
     * error:   发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 写 if else 判断是否需要过滤
     * 这里是 true，说明所有都过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的业务逻辑
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            log.warn("token is empty.");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {

            }
            return null;
        }
        log.info("its ok.");
        return null;
    }
}
