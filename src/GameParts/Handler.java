package GameParts;

import GameObject.*;
import GameObject.Enemies.BasicEnemy;
import GameObject.Enemies.FastEnemy;
import GameObject.Trash.AluminumTrash;
import GameObject.Trash.CardboardTrash;
import GameObject.Trash.OrganicTrash;
import GameObject.Trash.PlasticTrash;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Handler {

    //arreglo con los objetos del juego
    public ArrayList<GameObject> object = new ArrayList<GameObject>();
    private Random r = new Random();

    //corre la logica de los objetos del juego
    public void tick() {
        for(int i = 0; i < object.size(); i++) {

            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    //pinta la logica de los objetos del juego
    public void render(Graphics g) {
        for(int i = 0; i < object.size(); i++) {

            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void testObjects(){
        addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player,this));
        addObject(new BasicEnemy(r.nextInt(Game.WIDTH),Game.HEIGHT/8+r.nextInt(Game.HEIGHT-Game.HEIGHT/8), ID.BasicEnemy,this));
        addObject(new FastEnemy(r.nextInt(Game.WIDTH),Game.HEIGHT/8+r.nextInt(Game.HEIGHT-Game.HEIGHT/8), ID.FastEnemy,this));
        addObject(new OrganicTrash(50,Game.WIDTH/8+50, ID.OrganicTrash));
        addObject(new PlasticTrash(80,Game.WIDTH/8+100, ID.PlasticTrash));
        addObject(new CardboardTrash(100, Game.WIDTH/8+150, ID.CardboardTrash));
        addObject(new AluminumTrash(700,Game.WIDTH/8+300, ID.AluminumTrash));
    }
}