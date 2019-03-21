package cn.qingmg.miscellaneous.design.patterns.behavior.observer;

import cn.qingmg.miscellaneous.design.patterns.behavior.observer.core.WeatherObserver;
import cn.qingmg.miscellaneous.design.patterns.behavior.observer.subject.Weather;

/**
 * @Description 主函数
 * @Author vhs
 * @Date 2019-03-21
 * @Version 1.0
 */
public class Observer {

    public static void main(String[] args) {
        Weather weather = new Weather();
        WeatherObserver observer = new WeatherObserver(weather);

        weather.setData("晴朗", 27, 35);
        weather.setData("多云", 12, 20);

        weather.removeObserver(observer);
        weather.setData("多云", 13, 21);
    }
}
