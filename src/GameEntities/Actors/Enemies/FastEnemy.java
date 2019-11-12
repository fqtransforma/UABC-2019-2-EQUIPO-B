package GameEntities.Actors.Enemies;

import External.ImageSetter;
import GameEntities.Entity.GameObject;
import GameComponents.Handler;
import GameEntities.Entity.ID;

import java.awt.*;

public class FastEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
    private float diffX, diffY, distance;

    public FastEnemy(int x, int y, ID id, Handler handler) {
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
        if(player!=null) {
            diffX = x - player.getX();
            diffY = y - player.getY();
            distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

            if(distance<500){
                velX = (float) ((-1.0/distance)*diffX);
                velY = (float) ((-1.0/distance)*diffY);
                if(velX<0)
                    velX-=1.2;
                else
                    velX+=1.2;
                if(velY<0)
                    velY-=1.2;
                else
                    velY+=1.2;
                x += velX;
                y += velY;
            }
        }
        else
            findPlayer();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageSetter.fastEnemy,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 32,16);
    }
}
