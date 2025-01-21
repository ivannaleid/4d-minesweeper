import jaco.mp3.player.MP3Player;
import java.io.File;

public class PlayMP3 extends Main{
    public void playSound(String sound) {
        try {
            File f = new File(sound + ".mp3");
            MP3Player mp3Player = new MP3Player(f);
            mp3Player.play();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

