package cn.qingmg.miscellaneous.another.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 获得 IP 的工具类
 * @Author vhs
 * @Date 2018/10/5 10:49
 * @Version 1.0
 */
public class IPUtil {

    /**
     * 获得真实IP地址
     *
     * @param request
     * @return
     */
    public static String getRealIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        return checkIP(ip) ? ip : (
                checkIP(ip = request.getHeader("Proxy-Client-IP")) ? ip : (
                        checkIP(ip = request.getHeader("WL-Proxy-Client-IP")) ? ip :
                                request.getRemoteAddr()));
    }

    /**
     * IP 不为空且类型非未知
     *
     * @param ip
     * @return
     */
    private static boolean checkIP(String ip) {
        return StringUtils.isNotEmpty(ip) && !"unknown".equalsIgnoreCase(ip);
    }
}
