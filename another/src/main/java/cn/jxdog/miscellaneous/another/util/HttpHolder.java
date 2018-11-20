package cn.jxdog.miscellaneous.another.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 获得 Request, Response, Session 的工具类
 * @Author vhs
 * @Date 2018/10/5 10:33
 * @Version 1.0
 */
public class HttpHolder {

    private static final ServletRequestAttributes sqt = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

    /**
     * 获得 Request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return sqt.getRequest();
    }

    /**
     * 获得 Response
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return sqt.getResponse();
    }

    /**
     * 获得 Session
     *
     * @return
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 添加 Session
     *
     * @param key   键
     * @param value 值
     */
    public static void setSession(String key, Object value) {
        sqt.setAttribute(key, value, RequestAttributes.SCOPE_SESSION);
    }

    /**
     * 获得 Session
     *
     * @param key 键
     * @return
     */
    public static Object getSession(String key) {
        return sqt.getAttribute(key, RequestAttributes.SCOPE_SESSION);
    }

    /**
     * 删除 Session
     *
     * @param key 键
     */
    public static void removeSession(String key) {
        sqt.removeAttribute(key, RequestAttributes.SCOPE_SESSION);
    }

    /**
     * 获得 Session key 列表
     *
     * @return
     */
    public static List getSessionKeys() {
        return Arrays.asList(sqt.getAttributeNames(RequestAttributes.SCOPE_SESSION));
    }
}
