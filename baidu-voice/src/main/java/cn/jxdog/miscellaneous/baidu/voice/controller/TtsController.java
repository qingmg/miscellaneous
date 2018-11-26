package cn.jxdog.miscellaneous.baidu.voice.controller;

import cn.jxdog.miscellaneous.baidu.voice.core.util.TtsUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/23 9:30
 * @Version 1.0
 */
@Slf4j
@RestController
public class TtsController {

    @RequestMapping("speak")
    public String speak(String text) {
        if (StringUtils.isEmpty(text)) {
            text = "你是智障吗?";
        }
        try {
            TtsUtils.speak(text);
        } catch (Exception e) {
            log.error("something error: ", e);
            return "error";
        }
        return "success";
    }
}
