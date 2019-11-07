package GameParts;

import GameObject.GameObject;
import GameObject.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyboardInput(Handler handler) {
        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(Game.state == Game.STATE.Menu){
            if(key == KeyEvent.VK_ENTER)
                Game.state = Game.STATE.Game;
        }

        else if(Game.state == Game.STATE.Game){
            for(int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);
                //busca al jugador
                if(tempObject.getID() == ID.Player) {
                    //mueve jugador
                    if(key == KeyEvent.VK_W) {tempObject.setVelY(-Hud.speed); keyDown[0] = true;}
                    if(key == KeyEvent.VK_S) {tempObject.setVelY(Hud.speed); keyDown[1] = true;}
                    if(key == KeyEvent.VK_D) {tempObject.setVelX(Hud.speed); keyDown[2] = true;}
                    if(key == KeyEvent.VK_A) {tempObject.setVelX(-Hud.speed); keyDown[3] = true;}
                }
            }
        }
        else if(Game.state == Game.STATE.GameOver){
            if(key == KeyEvent.VK_ENTER)
                Game.state = Game.STATE.Menu;
        }

        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(Game.state == Game.STATE.Game) {
            for(int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);
                //busca jugador
                if(tempObject.getID() == ID.Player) {
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
