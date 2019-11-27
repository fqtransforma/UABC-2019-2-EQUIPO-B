package Externo.Archivos.Sonido;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Audio {

    public File sonidoPath;
    public AudioInputStream audioInput;
    public Clip clip;

    public void playSonido(String location){
        try{
            sonidoPath = new File(location);

            if(sonidoPath.exists()){
                 audioInput = AudioSystem.getAudioInputStream(sonidoPath);
                 clip = AudioSystem.getClip();
                 clip.open(audioInput);
                 clip.start();
            }
            else{
                System.out.println("No audio");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void playSonidoBG(String location){
        try{
            sonidoPath = new File(location);

            if(sonidoPath.exists()){
                audioInput = AudioSystem.getAudioInputStream(sonidoPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else{
                System.out.println("No audio");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
