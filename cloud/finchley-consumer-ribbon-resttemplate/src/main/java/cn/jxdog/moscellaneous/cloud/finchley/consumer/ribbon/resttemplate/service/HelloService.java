package cn.jxdog.moscellaneous.cloud.finchley.consumer.ribbon.resttemplate.service;

/**
 * @Description 消费者服务层
 * @Author vhs
 * @Date 2018-12-04
 * @Version 1.0
 */
public interface HelloService {

    /**
     * DEMO
     *
     * @return
     */
    String show();

    /**
     * 何人说 hello
     *
     * @param name 何人
     * @return
     */
    String sayHello(String name);
}
