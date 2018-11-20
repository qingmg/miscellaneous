package cn.jxdog.miscellaneous.another.custom.anno.aspect;

import cn.jxdog.miscellaneous.another.custom.anno.ShowLog;
import cn.jxdog.miscellaneous.another.util.AspectUtil;
import cn.jxdog.miscellaneous.another.util.RegexUtil;
import cn.jxdog.miscellaneous.another.util.RequestUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description 通过切面实现注解, ShowLog 的实现类
 * @Author vhs
 * @Date 2018/10/4 17:52
 * @Version 1.0
 */
@Aspect
@Component
public class ShowLogAspect {

    private static final Logger log = LoggerFactory.getLogger(ShowLog.class);

    @Pointcut("@annotation(cn.jxdog.miscellaneous.another.custom.anno.ShowLog)")
    public void pointcut() {
    }

    /**
     * 定义一个环绕通知
     */
    @Around("pointcut()")
    public void writeLog(ProceedingJoinPoint point) throws Throwable {
        // 执行业务
        point.proceed();

        try {
            int testIntParam = 10_10_10;
            // 打印日志
            handle(point);
        } catch (Exception e) {
            log.error("日志环绕通知时出现异常: ", e);
        }
    }

    /**
     * 异常输出
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint point, Throwable ex) {
        log.error("出现异常: ", ex);
    }

    /**
     * 打印日志业务
     */
    private void handle(ProceedingJoinPoint point) throws Exception {
        // 拦截方法参数
        String className = AspectUtil.getClassName(point);
        Method currentMethod = AspectUtil.getMethod(point);

        // 获取操作名称
        ShowLog annotation = currentMethod.getAnnotation(ShowLog.class);
        String bussinessName = parseContent(point.getArgs(), annotation.value());
        log.info("{} - {}.{}", bussinessName, className, currentMethod.getName());
        log.info("IP: {}, Method: {}, Request URL: {}", RequestUtil.getInstance().getIP(), RequestUtil.getInstance().getMethod(), RequestUtil.getInstance().getRequestURL());
        log.info("User-Agent: {}", RequestUtil.getInstance().getUserAgent());
    }

    private String parseContent(Object[] params, String bussinessName) {
        if (bussinessName.contains("{") && bussinessName.contains("}")) {
            List<String> result = RegexUtil.match(bussinessName, "(?<=\\{)(\\d+)");
            for (String s : result) {
                int index = Integer.parseInt(s);
                bussinessName = bussinessName.replaceAll("\\{" + index + "\\}", String.valueOf(params[index - 1]));
            }
        }
        return bussinessName;
    }

    public static void main(String[] args) {
        Integer temp = 1_2_3_4_5_6;
        System.out.println(temp);
    }
}
