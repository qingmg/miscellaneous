package cn.qingmg.moscellaneous.cloud.finchley.consumer.ribbon.resttemplate.service.impl;

import cn.qingmg.moscellaneous.cloud.finchley.consumer.ribbon.resttemplate.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 服务实现层
 * @Author vhs
 * @Date 2018-12-04
 * @Version 1.0
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "showError")
    @Override
    public String show() {
        return restTemplate.getForObject("http://EUREKA-CLIENT/show", String.class);
    }

    @HystrixCommand(fallbackMethod = "sayHelloError")
    @Override
    public String sayHello(final String name) {
        return restTemplate.postForObject("http://EUREKA-CLIENT/hello",new LinkedMultiValueMap<String, Object>() {{
            add("name", name);
        }}, String.class);
    }

    public String showError() {
        return "Hi man, This is show's request Error tag!";
    }

    public String sayHelloError(String name) {
        return "Hi man, This is sayHello's request Error tag! And param is " + name;
    }
}
