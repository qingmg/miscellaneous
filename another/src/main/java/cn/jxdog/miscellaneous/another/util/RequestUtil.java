package cn.jxdog.miscellaneous.another.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description Request 相关工具
 * @Author vhs
 * @Date 2018/10/5 10:46
 * @Version 1.0
 */
public class RequestUtil {

    private static RequestUtil instance;
    private static HttpServletRequest request;

    private RequestUtil() {
        request = HttpHolder.getRequest();
    }

    public static RequestUtil getInstance() {
        if (instance == null) {
            instance = new RequestUtil();
        }
        return instance;
    }

    /**
     * 获得 Request 所带参数的值
     *
     * @param key 键
     */
    public Object getParamters(HttpServletRequest request, String key) {
        return request.getParameter(key);
    }

    /**
     * 获得 Request 所带参数的值
     *
     * @param key 键
     */
    public Object getParamters(String key) {
        return request.getParameter(key);
    }

    /**
     * 获得头部信息
     *
     * @param key 键
     */
    public String getHeader(HttpServletRequest request, String key) {
        return request.getHeader(key);
    }

    /**
     * 获得头部信息
     *
     * @param key 键
     */
    public String getHeader(String key) {
        return request.getHeader(key);
    }

    /**
     * 获得 IP 地址
     */
    public String getIP(HttpServletRequest request) {
        return IPUtil.getRealIP(request);
    }

    /**
     * 获得 IP 地址
     */
    public String getIP() {
        return IPUtil.getRealIP(request);
    }

    /**
     * 获得请求的 url
     */
    public String getRequestURL(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }

    /**
     * 获得请求的 url
     */
    public String getRequestURL() {
        return request.getRequestURL().toString();
    }

    /**
     * 获得请求来源
     */
    public String getUserAgent(HttpServletRequest request) {
        return getHeader(request, "User-Agent");
    }

    /**
     * 获得请求来源
     */
    public String getUserAgent() {
        return getHeader("User-Agent");
    }

    /**
     * 获得方法名
     */
    public String getMethod(HttpServletRequest request) {
        return request.getMethod();
    }

    /**
     * 获得方法名
     */
    public String getMethod() {
        return request.getMethod();
    }
}
