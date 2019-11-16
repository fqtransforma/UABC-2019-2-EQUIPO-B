package ComponentesDeJuego;

import EntidadesDeJuego.Entidad.ActorDeJuego;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Controlador {

    //arreglo con los objetos del juego
    public ArrayList<ActorDeJuego> object = new ArrayList<ActorDeJuego>();
    private Random r = new Random();

    //corre las variables de los actores
    public void tick() {
        for(int i = 0; i < object.size(); i++) {

            ActorDeJuego tempObject = object.get(i);
            tempObject.tick();
        }
    }

    //pinta a los actores
    public void render(Graphics g) {
        for(int i = 0; i < object.size(); i++) {

            ActorDeJuego tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    //limpia a todos los actores pero conserva la posicion del jugador
    /*public void clearEnemies(){
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = null;
            tempObject = object.get(i);

            if(tempObject.getID() == ID.Player) {
                object.clear();
                if(Juego.estado == Juego.ESTADO.Juego) {
                    addObject(new Jugador((int)tempObject.getX(),(int)tempObject.getY(),ID.Player,this));
                }
            }
        }
    }*/

    public void agregaObject(ActorDeJuego object) {
        this.object.add(object);
    }

    public void quitarObject(ActorDeJuego object) {
        this.object.remove(object);
    }

}