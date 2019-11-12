package GameComponents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClick extends MouseAdapter {

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(Game.state == Game.STATE.Menu) {
            if (mouseOver(mx, my, Game.WIDTH / 2 - 30, Game.HEIGHT / 4 - 22, 60, 25)) {
                Game.state = Game.STATE.Game;
            } else if (mouseOver(mx, my, Game.WIDTH / 2 - 90, Game.HEIGHT / 3 - 22, 195, 25)) {
                Game.state = Game.STATE.LeaderBoards;
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
