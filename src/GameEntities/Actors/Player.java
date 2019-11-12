package GameEntities.Actors;

import External.ImageSetter;
import GameComponents.Game;
import GameEntities.Entity.GameObject;
import GameComponents.Handler;
import GameComponents.Hud;
import GameEntities.Entity.ID;

import java.awt.*;

public class Player extends GameObject{

    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    //detecta colision con enemigos
    private void enemyCollision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.BasicEnemy) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(Hud.shield>0)
                        Hud.shield-=2;
                    else
                        Hud.health-=2;
                }
            }
            else if(tempObject.getID() == ID.FastEnemy){
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(Hud.shield>0)
                        Hud.shield-=1;
                    else
                        Hud.health-=1;
                }
            }

            else if(tempObject.getID() == ID.Boss){
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(Hud.shield>0)
                        Hud.shield-=3;
                    else
                        Hud.health-=3;
                }
            }
        }
    }

    //detecta colision con basura
    private void trashCollision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.CardboardTrash && !Hud.trashCarrying[0] && !Hud.trashCarrying[1]
            && !Hud.trashCarrying[2] && !Hud.trashCarrying[3]) {

                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    Hud.score+=10;
                    Hud.trashCarrying[0] = true;
                }
            }

            else if(tempObject.getID() == ID.PlasticTrash && !Hud.trashCarrying[0] && !Hud.trashCarrying[1]
                    && !Hud.trashCarrying[2] && !Hud.trashCarrying[3]) {

                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    Hud.score+=10;
                    Hud.trashCarrying[1] = true;
                }
            }

            else if(tempObject.getID() == ID.OrganicTrash && !Hud.trashCarrying[0] && !Hud.trashCarrying[1]
                    && !Hud.trashCarrying[2] && !Hud.trashCarrying[3]) {

                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    Hud.score+=10;
                    Hud.trashCarrying[2] = true;
                }
            }

            else if(tempObject.getID() == ID.AluminumTrash && !Hud.trashCarrying[0] && !Hud.trashCarrying[1]
                    && !Hud.trashCarrying[2] && !Hud.trashCarrying[3]) {

                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    Hud.score+=10;
                    Hud.trashCarrying[3] = true;
                }
            }
        }
    }

    public void recyclerCollision(){
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.CardboardRecycler && Hud.trashCarrying[0]){
                if(getBounds().intersects(tempObject.getBounds())) {
                    Hud.trashCarrying[0] = false;
                    Hud.score += 90;
                    Hud.deliveredtTrash++;
                    Hud.speed += 0.1;
                }
            }
            else if (tempObject.getID() == ID.PlasticRecycler && Hud.trashCarrying[1]){
                if(getBounds().intersects(tempObject.getBounds())) {
                    Hud.trashCarrying[1] = false;
                    Hud.score += 90;
                    Hud.deliveredtTrash++;
                }
            } // Pendiente las balas
            else if (tempObject.getID() == ID.OrganicRecycler && Hud.trashCarrying[2]){
                if(getBounds().intersects(tempObject.getBounds())) {
                    Hud.trashCarrying[2] = false;
                    Hud.score += 90;
                    Hud.deliveredtTrash++;
                    Hud.health += 10;
                }
            }
            else if (tempObject.getID() == ID.AluminumRecycler && Hud.trashCarrying[3]){
                if(getBounds().intersects(tempObject.getBounds())) {
                    Hud.trashCarrying[3] = false;
                    Hud.score += 90;
                    Hud.deliveredtTrash++;
                    Hud.shield += 10;
                }
            }
        }

    }

    //logica del jugador
    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        x = Game.clamp(x,0, ImageSetter.levelbg.getWidth()-24);
        y = Game.clamp(y,(Game.HEIGHT/8)+68, ImageSetter.levelbg.getHeight()+(Game.HEIGHT/8)+32);

        enemyCollision();
        trashCollision();
        recyclerCollision();
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
