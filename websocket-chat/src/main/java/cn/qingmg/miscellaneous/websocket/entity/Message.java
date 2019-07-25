package cn.qingmg.miscellaneous.websocket.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Description 消息实体
 * @Author vhs
 * @Date 2019-07-25
 * @Version 1.0
 */
@Data
public class Message {
    public static final String ENTER = "ENTER";
    public static final String SPEAK = "SPEAK";
    public static final String QUIT = "QUIT";

    /**
     * 消息类型
     */
    private String type;
    /**
     * 发送人
     */
    private String username;
    /**
     * 发送消息
     */
    private String msg;
    /**
     * 在线用户数
     */
    private int onlineCount;

    public Message(String type, String username, String msg, int onlineCount) {
        this.type = type;
        this.username = username;
        this.msg = msg;
        this.onlineCount = onlineCount;
    }

    public static String jsonStr(String type, String username, String msg, int onlineTotal) {
        return JSON.toJSONString(new Message(type, username, msg, onlineTotal));
    }
}
