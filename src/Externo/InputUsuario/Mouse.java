package Externo.InputUsuario;

import Externo.Archivos.Jugador.Leaderboards;
import ComponentesDeJuego.Juego;
import Externo.Archivos.Sonido.Audio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    private Leaderboards lb;
    private Audio audio;

    public Mouse(Leaderboards lb, Audio audio){
        this.lb = lb;
        this.audio = audio;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(Juego.estado == Juego.ESTADO.Menu) {
            //boton de play
            if (mouseOver(mx, my, Juego.ANCHO / 2 - 137, Juego.ALTURA / 3 - 55, 235, 82)) {
                //cambia a juego y activa la captura de jugador
                Juego.estado = Juego.ESTADO.Juego;
                Juego.capturaJugador = true;
                audio.clip.stop();
            //boton de leaderboards
            } else if (mouseOver(mx, my, Juego.ANCHO / 2 - 255, Juego.ALTURA / 2 - 50, 470, 82)) {
                //carga el arreglo
                //lb.leer();
                //lb.ordenamiento();
                Juego.estado = Juego.ESTADO.LeaderBoards;
            //boton de exit
            } else if (mouseOver(mx, my, Juego.ANCHO / 2 - 137, (int) (Juego.ALTURA / 1.5) - 42, 235, 82)) {
                System.exit(1);
            }
        }
    }

    //metodo que nos dice si el click del mouse fue sobre una posicion que deseamos
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
