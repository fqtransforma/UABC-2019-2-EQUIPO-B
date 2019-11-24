package Externo.InputUsuario;

import ComponentesDeJuego.Juego;
import ComponentesDeJuego.Controlador;
import ComponentesDeJuego.Hud;
import ComponentesDeJuego.Nivel;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;
import Externo.Archivos.Leaderboards;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {

    private Controlador handler;
    private Nivel level;

    public Teclado(Controlador handler, Nivel level) {
        this.handler = handler;
        this.level = level;
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
            }

            else if(key == KeyEvent.VK_1)
                Hud.nivel++;
        }

        else if(Juego.estado == Juego.ESTADO.GameOver){
            if(key == KeyEvent.VK_ENTER)
                Juego.estado = Juego.ESTADO.Menu;
        }
    }
}
