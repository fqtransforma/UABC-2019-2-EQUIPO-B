package GameObject;

import External.ImageSetter;
import GameParts.Handler;

import java.awt.*;

public class FastEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
    private float diffX, diffY, distance;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getID() == ID.Player)
                player = handler.object.get(i);
        }
    }

    @Override
    public void tick() {
        diffX = x - player.getX();
        diffY = y - player.getY();
        distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));

        if(distance<500){
            velX = (float) ((-1.0/distance)*diffX);
            velY = (float) ((-1.0/distance)*diffY);
            if(velX<0)
                velX-=1;
            else
                velX+=1;
            if(velY<0)
                velY-=1;
            else
                velY+=1;
            x += velX;
            y += velY;
        }
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
