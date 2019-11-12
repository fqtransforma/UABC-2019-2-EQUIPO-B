package GameComponents;

import External.ImageSetter;
import GameEntities.Actors.Enemies.BasicEnemy;
import GameEntities.Actors.Enemies.Boss;
import GameEntities.Actors.Enemies.FastEnemy;
import GameEntities.Actors.Player;
import GameEntities.Actors.TrashRecyclers.AluminumRecycler;
import GameEntities.Actors.TrashRecyclers.CardboardRecycler;
import GameEntities.Actors.TrashRecyclers.OrganicRecycler;
import GameEntities.Actors.TrashRecyclers.PlasticRecycler;
import GameEntities.Actors.TrashTypes.AluminumTrash;
import GameEntities.Actors.TrashTypes.CardboardTrash;
import GameEntities.Actors.TrashTypes.OrganicTrash;
import GameEntities.Actors.TrashTypes.PlasticTrash;
import GameEntities.Entity.ID;

import java.awt.*;
import java.util.Random;

public class Level {

    private Handler handler;
    private boolean level1;
    private Random r;

    public Level(Handler handler){
        this.handler = handler;
        level1 = true;
        r = new Random();
    }

    public void resetLevels(){
        this.level1 = true;
    }

    public void tick(){
        if(Hud.level == 1 && level1){
            level1 = false;
            handler.addObject(new AluminumRecycler(48,448, ID.AluminumRecycler));
            handler.addObject(new CardboardRecycler(48,650,ID.CardboardRecycler));
            handler.addObject(new PlasticRecycler(48,800,ID.PlasticRecycler));
            handler.addObject(new OrganicRecycler(48,900,ID.OrganicRecycler));
            handler.addObject(new AluminumTrash(500,500,ID.AluminumTrash));
            handler.addObject(new CardboardTrash(500,700,ID.CardboardTrash));
            handler.addObject(new OrganicTrash(500,800,ID.OrganicTrash));
            handler.addObject(new PlasticTrash(500,600,ID.PlasticTrash));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),Game.HEIGHT/8+r.nextInt(Game.HEIGHT-Game.HEIGHT/8), ID.BasicEnemy,handler));
            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),Game.HEIGHT/8+r.nextInt(Game.HEIGHT-Game.HEIGHT/8), ID.FastEnemy,handler));
            handler.addObject(new Boss(r.nextInt(Game.WIDTH),Game.HEIGHT/8+r.nextInt(Game.HEIGHT-Game.HEIGHT/8), ID.Boss,handler));
            handler.addObject(new Player(ImageSetter.levelbg.getWidth()/2-32,ImageSetter.levelbg.getHeight()/2-32, ID.Player,handler));
        }
    }

    public void render(Graphics g){
        if(Hud.level == 1){
            g.drawImage(ImageSetter.levelbg,0,Game.WIDTH/8,null);
        }
    }
}
