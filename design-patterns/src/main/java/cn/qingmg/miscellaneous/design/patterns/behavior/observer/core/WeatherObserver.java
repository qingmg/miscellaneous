package cn.qingmg.miscellaneous.design.patterns.behavior.observer.core;

import cn.qingmg.miscellaneous.design.patterns.behavior.observer.subject.IWeather;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description 观察者
 * @Author vhs
 * @Date 2019-03-21
 * @Version 1.0
 */
public class WeatherObserver implements IWeatherObserver {

    /**
     * 观察者要订阅的主题
     */
    private IWeather weather;

    public WeatherObserver(IWeather weather) {
        this.weather = weather;
        this.weather.registerObserver(this);
    }

    @Override
    public void update(String weather, Integer... degree) {
        System.out.println("当前天气为: " + weather + "");
        Integer max = Collections.max(Arrays.asList(degree));
        Integer min = Collections.min(Arrays.asList(degree));
        System.out.println("当前度数范围为: " + min + "-" + max);
    }
}
