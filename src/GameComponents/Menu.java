package GameComponents;

import External.ImageSetter;
import External.Leaderboards;
import GameEntities.Actors.Player;
import GameEntities.Entity.ID;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu{

    private Leaderboards lb;

    public Menu(Leaderboards lb){
        this.lb = lb;
    }

    public void tick(){
        lb.read();
    }

    //pinta menu
    public void render(Graphics g){

        g.drawImage(ImageSetter.bg, 0, 0, null);
        g.setColor(Color.white);
        g.setFont(new Font("Serif Plain", 1, 30));

        if(Game.state == Game.STATE.Menu) {
            g.drawString("Play", Game.WIDTH / 2 - 30, Game.HEIGHT / 4);
            g.drawString("Leaderboards", Game.WIDTH / 2 - 90, Game.HEIGHT / 3);
            g.drawString("Exit", Game.WIDTH / 2 - 30, (int) (Game.HEIGHT / 2.5));
        }
        else if(Game.state == Game.STATE.LeaderBoards){

            g.drawString("Leaderboard", Game.WIDTH / 2 - 90, Game.HEIGHT / 4);
            for(int i = 0; i < lb.list.size(); i++){
                g.drawString((i+1)+"--"+lb.list.get(i).getName()+"--"+lb.list.get(i).getScore(),
                        Game.WIDTH / 2 - 120, (Game.HEIGHT/3)+(i*40));
            }
        }
    }
}
