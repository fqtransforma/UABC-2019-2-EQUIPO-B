package GameObject;

import External.ImageSetter;
import GameParts.Handler;
import GameParts.Hud;
import GameParts.Game;

import java.awt.*;

public class Player extends GameObject{

    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    //detecta colision con enemigos
    public void enemyCollision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(Hud.shield>0)
                        Hud.shield-=1;
                    else
                        Hud.health-=1;
                }
            }
        }
    }

    //detecta colision con basura
    public void trashCollision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.CardboardTrash) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    Hud.trash[0]+=1;
                    Hud.score+=10;
                }
            }

            else if(tempObject.getID() == ID.PlasticTrash) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    Hud.trash[1]+=1;
                    Hud.score+=10;
                }
            }

            else if(tempObject.getID() == ID.OrganicTrash) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    Hud.trash[2]+=1;
                    Hud.score+=10;
                }
            }

            else if(tempObject.getID() == ID.AluminumTrash) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    Hud.trash[3]+=1;
                    Hud.score+=10;
                }
            }
        }
    }

    //logica del jugador
    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        // Funcion CLAMP es para validar los limites de movimiento a traves de la ventana
        //x = Game.clamp(x,0, Game.WIDTH - 48);
        //y = Game.clamp(y,(Game.HEIGHT/8), Game.HEIGHT - 72);

        enemyCollision();
        trashCollision();
    }

    //pinta jugador
    @Override
    public void render(Graphics g) {
        g.drawImage(ImageSetter.player,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,32);
    }
}