package cn.jxdog.miscellaneous.baidu.voice.core.common;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/23 9:08
 * @Version 1.0
 */
public enum Constant {
    /**
     * APP_ID
     * API_KEY
     * SECRET_KEY
     */
    APP_ID("***"), API_KEY("***"), SECRET_KEY("***");

    /**
     * 成员变量, 值
     */
    private String value;

    /**
     * 带参构造函数
     *
     * @param value
     */
    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getValue(String str) {
        for (Constant c : Constant.values()) {
            if (c.name().equals(str)) {
                return c.value;
            }
        }
        return null;
    }
}
