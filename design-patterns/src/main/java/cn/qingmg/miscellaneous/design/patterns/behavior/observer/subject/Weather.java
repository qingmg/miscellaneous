package cn.qingmg.miscellaneous.design.patterns.behavior.observer.subject;

import cn.qingmg.miscellaneous.design.patterns.behavior.observer.core.IWeatherObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 主题
 * @Author vhs
 * @Date 2019-03-21
 * @Version 1.0
 */
public class Weather implements IWeather {

    /**
     * 所有的观察者
     */
    private List<IWeatherObserver> observers;

    /**
     * 一些有的没的参数
     */
    private String weather;
    private Integer[] degree;

    public Weather() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(IWeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IWeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (IWeatherObserver observer : observers) {
            observer.update(weather, degree);
        }
    }

    public void dataChange() {
        notifyObserver();
    }

    public void setData(String weather, Integer... degree) {
        this.weather = weather;
        this.degree = degree;

        dataChange();
    }
}
