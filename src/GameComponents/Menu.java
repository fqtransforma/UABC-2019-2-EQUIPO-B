package GameComponents;

import External.ImageSetter;
import GameEntities.Actors.Player;
import GameEntities.Entity.ID;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu{

    //pinta menu
    public void render(Graphics g){
        g.drawImage(ImageSetter.bg,0,0,null);
        g.setColor(Color.white);
        g.setFont(new Font("Serif Plain",1,30));
        g.drawString("Play",Game.WIDTH/2-30,Game.HEIGHT/4);
        g.drawString("Leaderboards",Game.WIDTH/2-90,Game.HEIGHT/3);
        g.drawString("Exit",Game.WIDTH/2-30,(int)(Game.HEIGHT/2.5));
    }
}
