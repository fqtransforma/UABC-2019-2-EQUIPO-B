package Externo.Archivos.Sonido;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonido implements Runnable{

    private String direccion;

    public Sonido(String direccion){
        this.direccion = direccion;
    }

    public void play(){
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        playSound(direccion);
    }

    private void playSound(String nombre){
        File soundFile = new File(nombre);
        AudioInputStream ais = null;
        try{
            ais = AudioSystem.getAudioInputStream(soundFile);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        AudioFormat aF = ais.getFormat();
        SourceDataLine linea = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class,aF);
        try{
            linea = (SourceDataLine) AudioSystem.getLine(info);
        }
        catch (LineUnavailableException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        linea.start();
        int nBytesRead = 0;
        byte[] abData = new byte[12800];
        while(nBytesRead != -1){
            try{
                nBytesRead = ais.read(abData, 0, abData.length);
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if(nBytesRead >= 0){
                int nBytesWritten = linea.write(abData, 0, nBytesRead);
            }
        }
        linea.drain();
        linea.close();
    }
}
