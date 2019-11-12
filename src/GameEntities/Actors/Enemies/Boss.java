package GameEntities.Actors.Enemies;

import External.ImageSetter;
import GameComponents.Handler;
import GameEntities.Entity.GameObject;
import GameEntities.Entity.ID;

import java.awt.*;

public class Boss extends GameObject {

    private Handler handler;
    private GameObject player;
    private float diffX, diffY, distance;

    public Boss(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        findPlayer();
    }

    public void findPlayer(){
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getID() == ID.Player)
                player = handler.object.get(i);
        }
    }

    @Override
    public void tick() {
        //algoritmo para saber hacia donde esta el jugador
        if(player!=null) {
            diffX = x - player.getX();
            diffY = y - player.getY();
            distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

            //if para saber si el jugador esta cerca o no
            if(distance<1000){
                velX = (float) ((-1.0/distance)*diffX);
                velY = (float) ((-1.0/distance)*diffY);
                if(velX<0)
                    velX-=.8;
                else
                    velX+=.8;
                if(velY<0)
                    velY-=.8;
                else
                    velY+=.8;
                x += velX;
                y += velY;
            }
        }
        else
            findPlayer();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageSetter.boss,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,ImageSetter.boss.getWidth()-16,ImageSetter.boss.getHeight()-16);
    }
}
