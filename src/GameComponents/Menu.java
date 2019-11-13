package GameComponents;

import External.Files.ImageSetter;
import External.Files.Leaderboards;

import java.awt.*;

public class Menu{

    private Leaderboards lb;

    public Menu(Leaderboards lb){
        this.lb = lb;
    }

    //pinta menu
    public void render(Graphics g){

        //pinta el fondo
        g.drawImage(ImageSetter.bg, 0, 0, null);
        //color y font y tamano a las letras
        g.setColor(Color.white);
        g.setFont(new Font("Serif Plain", 1, 30));

        //pinta el menu, play, lb y exit
        if(Game.state == Game.STATE.Menu) {
            g.drawString("Play", Game.WIDTH / 2 - 30, Game.HEIGHT / 4);
            g.drawString("Leaderboards", Game.WIDTH / 2 - 90, Game.HEIGHT / 3);
            g.drawString("Exit", Game.WIDTH / 2 - 30, (int) (Game.HEIGHT / 2.5));
        }
        //pinta el arreglo de jugadores
        else if(Game.state == Game.STATE.LeaderBoards){
            g.drawString("Leaderboard", Game.WIDTH / 2 - 90, Game.HEIGHT / 4);
            for(int i = 0; i < lb.list.size(); i++){
                g.drawString((i+1)+"--"+lb.list.get(i).getName()+"--"+lb.list.get(i).getScore(),
                        Game.WIDTH / 2 - 120, (Game.HEIGHT/3)+(i*40));
            }
        }
    }
}
