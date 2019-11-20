package Externo.InputUsuario;

import ComponentesDeJuego.Juego;
import ComponentesDeJuego.Controlador;
import ComponentesDeJuego.Hud;
import ComponentesDeJuego.Nivel;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {

    private Controlador handler;
    private Nivel level;
    private boolean[] keyDown = new boolean[4];

    public Teclado(Controlador handler, Nivel level) {
        this.handler = handler;
        this.level = level;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
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
            for(int i = 0; i < handler.object.size(); i++) {
                ActorDeJuego tempObject = handler.object.get(i);
                //busca al jugador
                if(tempObject.getID() == ID.Jugador) {
                    //mueve jugador
                    if(key == KeyEvent.VK_W) {tempObject.setVelY(-Hud.velocidad); keyDown[0] = true;}
                    if(key == KeyEvent.VK_S) {tempObject.setVelY(Hud.velocidad); keyDown[1] = true;}
                    if(key == KeyEvent.VK_D) {tempObject.setVelX(Hud.velocidad); keyDown[2] = true;}
                    if(key == KeyEvent.VK_A) {tempObject.setVelX(-Hud.velocidad); keyDown[3] = true;}
                }
            }
        }

        else if(Juego.estado == Juego.ESTADO.GameOver){
            if(key == KeyEvent.VK_ENTER)
                Juego.estado = Juego.ESTADO.Menu;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if(Juego.estado == Juego.ESTADO.Juego) {
            for(int i = 0; i < handler.object.size(); i++) {
                ActorDeJuego tempObject = handler.object.get(i);
                //busca jugador
                if(tempObject.getID() == ID.Jugador) {
                    //detiene jugador
                    if(key == KeyEvent.VK_W) keyDown[0] = false;
                    if(key == KeyEvent.VK_S) keyDown[1] = false;
                    if(key == KeyEvent.VK_D) keyDown[2] = false;
                    if(key == KeyEvent.VK_A) keyDown[3] = false;

                    if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                    if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
                }
            }
        }
    }
}
