package cn.qingmg.miscellaneous.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/9 10:11
 * @Version 1.0
 */
@Component
public class KafkaReceiver {

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            System.out.println("record: " + record);
            System.out.println("msg: " + msg);
        }
    }

//    @KafkaListener(topics = {"test"})
//    public void listen(String message) {
//        System.out.println("msg: " + message);
//    }
}
