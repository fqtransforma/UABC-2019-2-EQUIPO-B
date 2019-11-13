package GameEntities.Actors.Enemies;

import External.Files.ImageSetter;
import GameEntities.Entity.GameObject;
import GameComponents.Handler;
import GameEntities.Entity.ID;

import java.awt.*;

public class BasicEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
    private float diffX, diffY, distance;

    //constructor del enemigo basico
    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        findPlayer();
    }

    //busca el jugador para poder seguirlo
    public void findPlayer(){
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getID() == ID.Player)
                player = handler.object.get(i);
        }
    }

    //logica de nuestro enemigo basico
    @Override
    public void tick() {
        //algoritmo para saber hacia donde esta el jugador
        if(player!=null) {
            diffX = x - player.getX();
            diffY = y - player.getY();
            distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

            //if para saber si el jugador esta cerca o no
            //si no esta cerca no lo sigue
            if(distance<300){
                velX = (float) ((-1.0/distance)*diffX);
                velY = (float) ((-1.0/distance)*diffY);
                x += velX;
                y += velY;
            }
        }
        else
            //en caso de no haber encontrado jugador lo vuelve a buscar
            findPlayer();
    }

    @Override
    //pinta imagen del enemigo
    public void render(Graphics g) {
        g.drawImage(ImageSetter.basicEnemy,(int)x,(int)y,null);
    }

    //retorna un rectangulo del tamano de la imagen para la colision con el jugador
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 32,48);
    }
}
