package GameComponents;

import java.awt.*;

public class Hud {

    public static int level = 1;
    public static int health = 100;
    public static int shield = 0;
    public static float speed = 3;
    public static int bullets = 0;
    public static boolean[] trashCarrying = new boolean[4];
    public static int score = 0;
    public static int deliveredTrash = 0;

    public Hud(){
        //inicializa en falso porque no estamos cargando ninguna basura
        trashCarrying[0] = false;
        trashCarrying[1] = false;
        trashCarrying[2] = false;
        trashCarrying[3] = false;
    }

    //metodo para resetear todas las variables del hud
    public static void resetGame(){
        level = 1;
        health = 100;
        shield = 0;
        speed = 3;
        bullets = 0;
        trashCarrying[0] = false;
        trashCarrying[1] = false;
        trashCarrying[2] = false;
        trashCarrying[3] = false;
        score = 0;
        deliveredTrash = 0;
    }

    public void tick(){
        //no permite que estas variables se pasen de sus limites
        shield = (int) Game.clamp(shield, 0, 100);
        health = (int) Game.clamp(health, 0, 100);
    }

    //pinta el heads up display
    public void render(Graphics g){
        //rectangulo superior
        g.setColor(Color.gray);
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT/8);
        g.setColor(Color.black);
        g.drawRect(0,0, Game.WIDTH, Game.HEIGHT/8);
        g.setColor(Color.black);
        //letras del hud
        g.setFont(new Font("arial",0,20));
        g.drawString("Level: "+level,Game.WIDTH/26,Game.HEIGHT/24);
        g.drawString("Score: "+score,Game.WIDTH/26,Game.HEIGHT/12);
        if(trashCarrying[0]) {
            g.drawString("Carrying cardboard", Game.WIDTH / 3, Game.HEIGHT / 16);
        }
        else if(trashCarrying[1]) {
            g.drawString("Carrying plastic", Game.WIDTH / 3, Game.HEIGHT / 16);
        }
        else if(trashCarrying[2]) {
            g.drawString("Carrying organic", Game.WIDTH / 3, Game.HEIGHT / 16);
        }
        else if(trashCarrying[3]) {
            g.drawString("Carrying aluminum", Game.WIDTH / 3, Game.HEIGHT / 16);
        }
        g.drawString("Shield: ",(int)(Game.WIDTH/1.28),Game.HEIGHT/24);
        g.drawString("Health: ",(int)(Game.WIDTH/1.28),Game.HEIGHT/12);
        //rectangulo de la vida
        g.setColor(Color.red);
        g.fillRect((int)(Game.WIDTH/1.28)+75,Game.HEIGHT/15, 100, (int)(Game.HEIGHT/28.8));
        g.setColor(new Color(75,255,0));
        g.fillRect((int)(Game.WIDTH/1.28)+75, Game.HEIGHT/15, health,(int)(Game.HEIGHT/28.8));
        g.setColor(Color.black);
        g.drawRect((int)(Game.WIDTH/1.28)+75, Game.HEIGHT/15, 100,(int)(Game.HEIGHT/28.8));
        //rectangulo del escudo
        g.setColor(Color.lightGray);
        g.fillRect((int)(Game.WIDTH/1.28)+75,Game.HEIGHT/45, 100, (int)(Game.HEIGHT/28.8));
        g.setColor(new Color(36, 66, 255));
        g.fillRect((int)(Game.WIDTH/1.28)+75, Game.HEIGHT/45, shield,(int)(Game.HEIGHT/28.8));
        g.setColor(Color.black);
        g.drawRect((int)(Game.WIDTH/1.28)+75, Game.HEIGHT/45, 100,(int)(Game.HEIGHT/28.8));
    }

}
