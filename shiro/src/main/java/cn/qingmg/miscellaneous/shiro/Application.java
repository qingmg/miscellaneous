package cn.qingmg.miscellaneous.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description 启动类
 * @Author vhs
 * @Date 2019-04-10
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("cn.qingmg.miscellaneous.shiro.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
