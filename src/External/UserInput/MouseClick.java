package External.UserInput;

import External.Files.Leaderboards;
import GameComponents.Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClick extends MouseAdapter {

    private Leaderboards lb;

    public MouseClick(Leaderboards lb){
        this.lb = lb;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(Game.state == Game.STATE.Menu) {
            //boton de play
            if (mouseOver(mx, my, Game.WIDTH / 2 - 30, Game.HEIGHT / 4 - 22, 60, 25)) {
                //cambia a juego y activa la captura de jugador
                Game.state = Game.STATE.Game;
                Game.capturePlayer = true;
            //boton de leaderboards
            } else if (mouseOver(mx, my, Game.WIDTH / 2 - 90, Game.HEIGHT / 3 - 22, 195, 25)) {
                //carga el arreglo
                lb.read();
                Game.state = Game.STATE.LeaderBoards;
            //boton de exit
            } else if (mouseOver(mx, my, Game.WIDTH / 2 - 30, (int) (Game.HEIGHT / 2.5) - 22, 60, 25)) {
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
