package cn.qingmg.miscellaneous.common.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 查询类
 * @Author vhs
 * @Date 2019-04-19
 * @Version 1.0
 */
public class Criteria {

    private Map<String, Object> condition;

    public Criteria() {
        condition = new HashMap<>();
    }

    public void clear() {
        condition.clear();
    }

    public void put(String key, Object value) {
        this.condition.put(key, value);
    }

    public void remove(String key) {
        this.condition.remove(key);
    }
}
