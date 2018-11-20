package cn.jxdog.miscellaneous.common.entity;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/9 9:03
 * @Version 1.0
 */
public class HttpResult {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 提示消息
     */
    private String msg;
    /**
     * 异常消息
     */
    private String bug;

    public HttpResult() {
    }

    private HttpResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private HttpResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    private HttpResult(int code, String msg, String bug) {
        this.code = code;
        this.msg = msg;
        this.bug = bug;
    }

    private HttpResult(int code, Object data, String msg, String bug) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.bug = bug;
    }

    public static HttpResult success(String msg) {
        return new HttpResult(200, msg);
    }

    public static HttpResult success(Object data, String msg) {
        return new HttpResult(200, data, msg);
    }

    public static HttpResult error(int code, String msg) {
        return new HttpResult(code, msg);
    }

    public static HttpResult error(int code, String msg, String bug) {
        return new HttpResult(code, msg, bug);
    }

    public static HttpResult error(int code, Object data, String msg) {
        return new HttpResult(code, data, msg);
    }

    public static HttpResult error(int code, Object data, String msg, String bug) {
        return new HttpResult(code, data, msg, bug);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBug() {
        return bug;
    }

    public void setBug(String bug) {
        this.bug = bug;
    }
}
