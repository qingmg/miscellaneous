package cn.qingmg.miscellaneous.cloud.finchley.consumer.feign.service;

import org.springframework.stereotype.Component;

/**
 * @Description 当前接口断路器的实现类
 * @Author vhs
 * @Date 2019-01-15
 * @Version 1.0
 */
@Component
public class HelloServiceImplForHystrix implements HelloService {

    @Override
    public String show() {
        return "This is Feign's show request error tag!";
    }

    @Override
    public String sayHello(String name) {
        return "This is Feign's sayHello request error tag! And param is " + name;
    }
}
