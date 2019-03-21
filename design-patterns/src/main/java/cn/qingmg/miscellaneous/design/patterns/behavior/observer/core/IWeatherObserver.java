package cn.qingmg.miscellaneous.design.patterns.behavior.observer.core;

/**
 * @Description 观察者接口
 * @Author vhs
 * @Date 2019-03-21
 * @Version 1.0
 */
public interface IWeatherObserver {

    /**
     * 更新
     *
     * @param weather 天气
     * @param degree  度数
     */
    void update(String weather, Integer... degree);
}
