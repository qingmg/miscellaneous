package cn.qingmg.miscellaneous.soap.config;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 返回处理的一个切面
 * @Author vhs
 * @Date 2018/10/23 14:34
 * @Version 1.0
 */
@Aspect
@Configuration
public class AspectForReturn {

    private static final Logger log = LoggerFactory.getLogger(AspectForReturn.class);

    @Pointcut("execution(* cn.qingmg.miscellaneous.soap.service.impl..*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 获得原返回结果
        Object result = point.proceed();
        // 转成 String 返回
        return JSON.toJSONString(result);
    }
}
