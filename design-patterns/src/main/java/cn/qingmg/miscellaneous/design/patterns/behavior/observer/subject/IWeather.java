package cn.qingmg.miscellaneous.design.patterns.behavior.observer.subject;

import cn.qingmg.miscellaneous.design.patterns.behavior.observer.core.IWeatherObserver;

/**
 * @Description 主题接口
 * @Author vhs
 * @Date 2019-03-21
 * @Version 1.0
 */
public interface IWeather {

    /**
     * 增加观察者
     */
    void registerObserver(IWeatherObserver observer);

    /**
     * 删除观察者
     */
    void removeObserver(IWeatherObserver observer);

    /**
     * 更新数据，通知通知观察者
     */
    void notifyObserver();

}
