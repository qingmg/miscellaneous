package cn.qingmg.miscellaneous.mybatis.mysql.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 逆向工程Main函数
 * @Author vhs
 * @Date 2019-04-12
 * @Version 1.0
 */
public class GenMain {
    public static void main(String[] args) {
        List<String> warnins = new ArrayList<>();
        boolean overwrite = true;
        String mbgConfig = "/mbgConfiguration.xml";
        File configFile = new File(GenMain.class.getResource(mbgConfig).getFile());
        ConfigurationParser parser = new ConfigurationParser(warnins);
        Configuration configuration = null;
        try {
            configuration = parser.parseConfiguration(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator generator = null;
        try {
            generator = new MyBatisGenerator(configuration, callback, warnins);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            generator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
