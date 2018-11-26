package cn.jxdog.miscellaneous.baidu.voice.core.util;

import cn.jxdog.miscellaneous.baidu.voice.core.common.Constant;
import cn.jxdog.miscellaneous.baidu.voice.core.common.MusicPlayer;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import sun.audio.AudioPlayer;

import java.io.*;
import java.util.HashMap;

@Slf4j
public class TtsUtils {
    /**
     * 发音人选择, 0为普通女声，1为普通男生，3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女声
     */
    private static final int per = 1;
    /**
     * 语速，取值0-15，默认为5中语速
     */
    private static final int spd = 5;
    /**
     * 音调，取值0-15，默认为5中语调
     */
    private static final int pit = 5;
    /**
     * 音量，取值0-9，默认为5中音量
     */
    private static final int vol = 5;

    /**
     * 下载的文件格式, 3：mp3(default) 4： pcm-16k 5： pcm-8k 6. wav
     */
    private static final int aue = 6;

    public static void speak(String text) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(Constant.getValue("APP_ID"), Constant.getValue("API_KEY"), Constant.getValue("SECRET_KEY"));

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        // 设置http代理
//        client.setHttpProxy("proxy_host", proxy_port);
//        // 设置socket代理
//        client.setSocketProxy("proxy_host", proxy_port);

        // 调用接口
        // 不得超过 1024 字节
        TtsResponse res = client.synthesis(text, "zh", 1,
                new HashMap<String, Object>(5) {{
                    // 发音人
                    put("per", per);
                    // 语速
                    put("spd", spd);
                    // 音调
                    put("pit", pit);
                    // 音量
                    put("vol", vol);
                    // 下载的文件格式
                    put("aue", aue);
                }});

        byte[] data = res.getData();
        if (data != null) {
            /*AudioPlayer.player.start(new ByteArrayInputStream(data));*/
            new MusicPlayer(data).play();
        }

        JSONObject res1 = res.getResult();
        if (res1 != null) {
            log.info(res1.toString(2));
        }

//        // 保存文件
//        Util.writeBytesToFileSystem(data, "F:\\output." + getFormat(aue));

//        // 识别语音文字
//        JSONObject asrObject = client.asr(data, "pcm", 16000, null);
//        log.info(asrObject.toString(2));
    }

    // 下载的文件格式, 3：mp3(default) 4： pcm-16k 5： pcm-8k 6. wav
    private String getFormat(int aue) {
        String[] formats = {"mp3", "pcm", "pcm", "wav"};
        return formats[aue - 3];
    }
}
