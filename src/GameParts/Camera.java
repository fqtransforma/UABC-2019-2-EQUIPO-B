package GameParts;

import GameObject.GameObject;
import GameObject.ID;
import java.awt.*;

public class Camera {

    private int x,y;
    private Handler handler;
    private GameObject tempPlayer = null;

    public Camera(int x, int y, Handler handler){
        this.x = x;
        this.y = y;
        this.handler = handler;
    }

    public void findPlayer(){
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getID() == ID.Player){
                tempPlayer = handler.object.get(i);
                break;
            }
        }
    }

    public void tick(){
        if(!(tempPlayer==null)){
            x = (int)tempPlayer.getX() - Game.WIDTH/2;
            y = (int)tempPlayer.getY() - (Game.HEIGHT- Game.HEIGHT/8)/2;
        }
        else
            findPlayer();
    }

    public void render(Graphics g){

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}