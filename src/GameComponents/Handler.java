package GameComponents;

import GameEntities.Actors.Player;
import GameEntities.Entity.GameObject;
import GameEntities.Entity.ID;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Handler {

    //arreglo con los objetos del juego
    public ArrayList<GameObject> object = new ArrayList<GameObject>();
    private Random r = new Random();

    //corre las variables de los actores
    public void tick() {
        for(int i = 0; i < object.size(); i++) {

            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    //pinta a los actores
    public void render(Graphics g) {
        for(int i = 0; i < object.size(); i++) {

            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    //limpia a todos los actores pero conserva la posicion del jugador
    public void clearEnemies(){
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = null;
            tempObject = object.get(i);

            if(tempObject.getID() == ID.Player) {
                object.clear();
                if(Game.state == Game.STATE.Game) {
                    addObject(new Player((int)tempObject.getX(),(int)tempObject.getY(),ID.Player,this));
                }
            }
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}