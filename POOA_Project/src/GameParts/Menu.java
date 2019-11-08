package GameParts;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {

    //detecta cuando el mouse es presionado
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
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

    //pinta menu
    public void render(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("arial",0,50));
        g.drawString("Press Enter", Game.WIDTH/2-100, Game.HEIGHT/8);

    }
}
