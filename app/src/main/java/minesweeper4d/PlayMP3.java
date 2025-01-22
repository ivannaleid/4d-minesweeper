package minesweeper4d;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;
import java.net.URL;

public class PlayMP3 extends Main{
    public void playSound(String sound) {
        try {
            InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(sound + ".mp3");
            if (resourceStream == null) {
                System.err.println("Could not find sound file: " + sound);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(resourceStream);
            AudioFormat baseFormat = audioStream.getFormat();
            AudioFormat decodedFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream decodedAudioStream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
            Clip clip = AudioSystem.getClip();
            clip.open(decodedAudioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

