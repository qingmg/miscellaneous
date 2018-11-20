package cn.jxdog.miscellaneous.soap.config;

import cn.jxdog.miscellaneous.soap.service.DemoService;
import cn.jxdog.miscellaneous.soap.service.impl.DemoServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.xml.ws.Endpoint;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/9 15:30
 * @Version 1.0
 */
@Configuration
public class CxfConfig {

    /**
     * Springboot 默认上传配置
     */
    @Autowired
    private MultipartConfigElement multipartConfigElement;

    /**
     * 普通的 Controller 处理
     */
    @Bean
    public ServletRegistrationBean registrationRestBean() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // controller 包路径
        context.scan("cn.jxdog.miscellaneous.soap.controller");
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.setMultipartConfig(multipartConfigElement);
        // 映射路径自定义,必须设置一个不重复的名称
        registrationBean.addUrlMappings("/restful/*");
        registrationBean.setName("rest");
        return registrationBean;
    }

    /**
     * 定义拦截
     */
    @Bean
    public ServletRegistrationBean registrationBean() {
        return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /**
     * 服务
     */
    private DemoService demoService() {
        return new DemoServiceImpl();
    }

    /**
     * 定义 tmDisInfoService 的切入点
     */
    @Bean
    public Endpoint demoEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), demoService());
        endpoint.publish("/demo");
        return endpoint;
    }
}
