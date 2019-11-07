package GameParts;

import java.awt.*;

public class Hud {

    public static int level = 1;
    public static int health = 1000;
    public static int shield = 0;
    public static float speed = 3;
    public static int bullets = 0;
    public static int[] trash = new int[4];
    //trash[0] = cardboard
    //trash[1] = plastic
    //trash[2] = organic
    //trash[3] = aluminum
    public static int score = 0;

    public Hud(){
        trash[0] = 0;
        trash[1] = 0;
        trash[2] = 0;
        trash[3] = 0;
    }

    public static void resetGame(){
        level = 1;
        health = 1000;
        shield = 0;
        speed = 3;
        bullets = 0;
        trash[0] = 0;
        trash[1] = 0;
        trash[2] = 0;
        trash[3] = 0;
        score = 0;
    }

    //logica del heads up display
    public void tick(){
        shield = (int) Game.clamp(shield, 0, 1000);
        health = (int) Game.clamp(health, 0, 1000);
    }

    //pinta el heads up display
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT/8);
        g.setColor(Color.black);
        g.drawRect(0,0, Game.WIDTH, Game.HEIGHT/8);
        g.setColor(Color.black);
        g.setFont(new Font("arial",0,20));
        g.drawString("Level: "+level,50,30);
        g.drawString("Score: "+score,50,60);
        g.drawString("Cardboard: "+trash[0],200,45);
        g.drawString("Plastic: "+trash[1],400,45);
        g.drawString("Organic: "+trash[2],600,45);
        g.drawString("Aluminum: "+trash[3],800,45);
        g.drawString("Shield: "+shield/10,1000,30);
        g.drawString("Health: "+health/10,1000,60);
    }

}
