package cn.qingmg.miscellaneous.another.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @Description 关于类相关的工具类
 * @Author vhs
 * @Date 2019-01-22
 * @Version 1.0
 */
public class BeanUtils {

    /**
     * 获得 type 供 JSON 进行转化
     *
     * @param raw
     * @param args
     * @return
     */
    public static Type getType(final Class<?> raw, final Type... args) {
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return args;
            }

            @Override
            public Type getRawType() {
                return raw;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("", "string");
        jsonObject.put("paramInt", 1);
        jsonObject.put("paramDou", 1.1);

        String str_1 = "{\"paramStr\": {\"paramStr\": 1.2}, \"paramInt\": {\"paramStr\": 1.2}, \"paramDou\": {\"paramStr\": 1.2}}";
        Type type = getType(Map.class, String.class, Map.class, String.class, Double.class);
        Map map_ = JSON.parseObject(str_1, Map.class);
        System.out.println(map_.toString());
        Map<String, Integer> map = JSON.parseObject(str_1, type);
        System.out.println(map);
    }
}
