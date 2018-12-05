package cn.jxdog.moscellaneous.cloud.finchley.consumer.ribbon.resttemplate.service.impl;

import cn.jxdog.moscellaneous.cloud.finchley.consumer.ribbon.resttemplate.service.HelloService;
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

    @Override
    public String show() {
        return restTemplate.getForObject("http://EUREKA-CLIENT/show", String.class);
    }

    @Override
    public String sayHello(final String name) {
        return restTemplate.postForObject("http://EUREKA-CLIENT/hello",new LinkedMultiValueMap<String, Object>() {{
            add("name", name);
        }}, String.class);
    }
}
