package cn.qingmg.miscellaneous.baidu.voice.core.common;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Date;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/23 11:37
 * @Version 1.0
 */
@Slf4j
public class MusicPlayer {

    private static MusicPlayer instance;

    /**
     * 实现单例
     *
     * @return
     */
    public static MusicPlayer getInstance() {
        if (instance == null) {
            synchronized (MusicPlayer.class) {
                if (instance == null) {
                    return new MusicPlayer();
                }
            }
        }
        return instance;
    }

    public void play(byte[] data) {
        try {
            @Cleanup AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new ByteArrayInputStream(data));
            play(audioInputStream);
        } catch (Exception e) {
            log.error("{}: MusicPlayer 播放失败，错误信息: ", new Date(), e);
        }
    }

    public void play(String path) {
        try {
            @Cleanup AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            play(audioInputStream);
        } catch (Exception e) {
            log.error("{}: MusicPlayer 播放失败，错误信息: ", new Date(), e);
        }
    }

    public void play(AudioInputStream audioInputStream) {
        try {
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
            @Cleanup SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);

            byte[] b = new byte[1024];
            int len;
            sourceDataLine.open(audioFormat, 1024);
            sourceDataLine.start();
            while ((len = audioInputStream.read(b)) > 0) {
                sourceDataLine.write(b, 0, len);
            }
            sourceDataLine.drain();
        } catch (Exception e) {
            log.error("{}: MusicPlayer 播放失败，错误信息: ", new Date(), e);
        }
    }
}
