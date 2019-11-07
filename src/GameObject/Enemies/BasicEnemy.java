package GameObject.Enemies;

import External.ImageSetter;
import GameObject.GameObject;
import GameParts.Handler;
import GameObject.ID;

import java.awt.*;

public class BasicEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
    private float diffX, diffY, distance;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        //busca jugador
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getID() == ID.Player)
                player = handler.object.get(i);
        }
    }

    //logica de nuestro enemigo basico
    @Override
    public void tick() {
        //algoritmo para saber hacia donde esta el jugador
        diffX = x - player.getX();
        diffY = y - player.getY();
        distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));

        //if para saber si el jugador esta cerca o no
        if(distance<300){
            velX = (float) ((-1.0/distance)*diffX);
            velY = (float) ((-1.0/distance)*diffY);
            x += velX;
            y += velY;
        }

    }

    @Override
    //pinta enemigo basico
    public void render(Graphics g) {
        g.drawImage(ImageSetter.basicEnemy,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 32,48);
    }
}
