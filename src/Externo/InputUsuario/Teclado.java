package Externo.InputUsuario;

import ComponentesDeJuego.Juego;
import ComponentesDeJuego.Controlador;
import ComponentesDeJuego.Hud;
import ComponentesDeJuego.Nivel;
import Externo.Archivos.Sonido.Audio;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {

    private Controlador handler;
    private Nivel level;
    private Audio audio;

    public Teclado(Controlador handler, Nivel level, Audio audio) {
        this.handler = handler;
        this.level = level;
        this.audio = audio;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if(Juego.estado == Juego.ESTADO.Menu){
            if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        }

        else if(Juego.estado == Juego.ESTADO.LeaderBoards){
            if(key == KeyEvent.VK_ESCAPE) {
                Juego.estado = Juego.ESTADO.Menu;
            }
        }

        else if(Juego.estado == Juego.ESTADO.Juego){
            if(key == KeyEvent.VK_ESCAPE) {
                Juego.estado = Juego.ESTADO.Menu;
                Hud.resetJuego();
                handler.object.clear();
                level.resetNivel();
                level.audio.clip.close();
                audio.clip.close();
            }

            else if(key == KeyEvent.VK_1)
                Hud.nivel++;

            else if(key == KeyEvent.VK_2)
                Hud.basuraEntregada+=1;
        }

        else if(Juego.estado == Juego.ESTADO.GameOver || Juego.estado == Juego.ESTADO.Win){
            if(key == KeyEvent.VK_ENTER)
                Juego.estado = Juego.ESTADO.Menu;
                audio.clip.close();
                audio.playSonidoBG("res/sonido/Background/bensound-scifi.wav");
        }
    }
}
