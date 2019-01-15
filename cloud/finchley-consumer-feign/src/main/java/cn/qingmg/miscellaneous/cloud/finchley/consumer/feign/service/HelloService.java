package cn.qingmg.miscellaneous.cloud.finchley.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 消费者服务层
 * @Author vhs
 * @Date 2018-12-05
 * @Version 1.0
 */
@FeignClient(value = "EUREKA-CLIENT", fallback = HelloServiceImplForHystrix.class)
public interface HelloService {

    /**
     * DEMO
     *
     * @return
     */
    @RequestMapping(value = "/show")
    String show();

    /**
     * 何人说 hello
     *
     * @param name 何人
     * @return
     */
    @RequestMapping(value = "/hello")
    String sayHello(@RequestParam(value = "name") String name);

}
