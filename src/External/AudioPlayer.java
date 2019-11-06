package External;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioPlayer {

    public static void playBackground(String soundLocation) {
        try {
            File soundPath = new File(soundLocation);

            if(soundPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else
                System.out.println("No se encuentra archivo");

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void playSound(String soundLocation) {
        try {
            File soundPath = new File(soundLocation);

            if(soundPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else
                System.out.println("No se encuentra archivo");

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}

