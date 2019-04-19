package cn.qingmg.miscellaneous.common.util;

import java.util.List;
import java.util.Map;

/**
 * @Description 常用工具类
 * @Author vhs
 * @Date 2019-04-19
 * @Version 1.0
 */
public class CommonUtils {

    public static boolean isNotNullAndEmpty(Object object) {
        if (object instanceof String) {
            return object != null && !"".equals(object);
        } else if (object instanceof Integer) {
            return object != null && !"0".equals(object);
        } else if (object instanceof List) {
            return object != null && ((List) object).size() > 0;
        } else if (object instanceof Map) {
            return object != null && ((Map) object).size() > 0;
        } else {
            return object != null;
        }
    }
}
