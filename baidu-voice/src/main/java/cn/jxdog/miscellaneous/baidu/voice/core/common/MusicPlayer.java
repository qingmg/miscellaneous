package cn.jxdog.miscellaneous.baidu.voice.core.common;

import lombok.extern.slf4j.Slf4j;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/23 11:37
 * @Version 1.0
 */
@Slf4j
public class MusicPlayer {
    private AudioFormat audioFormat;
    private SourceDataLine sourceDataLine;
    private DataLine.Info dataLine_info;
    private AudioInputStream audioInputStream;

    public MusicPlayer(byte[] data) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new ByteArrayInputStream(data));
            audioFormat = audioInputStream.getFormat();
            dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);
        } catch (Exception e) {
            log.error("{}: 初始化 MusicPlayer 失败，错误信息: ", new Date(), e);
        }
    }

    public MusicPlayer(String path) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(path));
        audioFormat = audioInputStream.getFormat();
        dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
        sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);
    }

    public void play() {
        try {
            byte[] b = new byte[1024];
            int len = 0;
            sourceDataLine.open(audioFormat, 1024);
            sourceDataLine.start();
            while ((len = audioInputStream.read(b)) > 0) {
                sourceDataLine.write(b, 0, len);
            }
            audioInputStream.close();
            sourceDataLine.drain();
            sourceDataLine.close();
        } catch (Exception e) {
            log.error("{}: MusicPlayer 播放失败，错误信息: ", new Date(), e);
        }
    }
}
