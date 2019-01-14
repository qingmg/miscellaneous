package cn.qingmg.miscellaneous.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/9 10:08
 * @Version 1.0
 */
@Component
public class KafkaSender {

    @Autowired(required = false)
    KafkaTemplate<String, String> template;

    public void send(String text) {
        template.send("test", "key",  text);
    }
}
