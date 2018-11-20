package cn.jxdog.miscellaneous.kafka;

import cn.jxdog.miscellaneous.kafka.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/9 10:06
 * @Version 1.0
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    KafkaSender sender;

    @RequestMapping("/send")
    public String send() {
        String text = "{\"ackState\":0,\"alarmSeverity\":1,\"alarmStatus\":\"03CA5C4E74F4A65D0E7419372A015A\",\"alarmText\":\"CBE920036464A13EF45C100DD01669\",\"alarmTitle\":\"1A7736E2A425D15061AE4C4B84B10D\",\"\n" +
                "alarmUniqueClearId\":\"50F48327FB41E83E9B635F1B8DB76A\",\"alarmUniqueId\":\"C97C3D1B22FF12855D81295A888C26\",\"cancelTime\":1541671545886,\"equipmentClass\":1,\"eventTime\":1541671545886,\"locateInfo\":\"8D082ADF9BC0D1D5007B8B28F99458\",\"locateNeName\":\"414DA4B41B716210529D54785CA78D\",\"locateNeSdn\":\"78414BFF3B018C3770C0F5C99B65FB\",\"locateNeType\":0,\"msgSerial\":1,\"neName\":\"2B146FBE45CC9BC9FA8A5F235E03FB\",\"nmsAlarmId\":\"DF6A8D621AC004E35F6CB961353888\",\"railwayAdmin\":\"9860BC734AB6991CD5A564F97473C3\",\"railwaySection\":\"BBDB97BB850145B35E7DB8A314822C\",\"sdn\":\"322CFD481C5B0434E3A915B6BF7C7A\",\"sheetNo\":\"6DAEC13348A97F387DD0FFDE6DA6B7\",\"sheetSendStatus\":1,\"sheetStatus\":1,\"standardAlarmName\":\"1114ED7E582E57C54E397C0464419D\",\"systemName\":\"71FDAED9F9A46D1077E9838294D060\",\"vendor\":1,\"vendorAlarmId\":\"7AA6AB8483D79C8B95AEED7DD04135\",\"vendorAlarmType\":\"D5161F3F1D21ACE2ACCC1424A88D60\",\"vendorSeverity\":\"A1ADF53E284FB4FD27C53F4F4DA0B9\",\"workArea\":\"C3F0894D8ECB13CE111C40379A4E10\",\"workshop\":\"15C4055303AF163C6D1FD5018B6FD8\"}\n";
        sender.send(text);
        return "success";
    }
}
