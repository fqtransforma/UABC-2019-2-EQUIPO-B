package ComponentesDeJuego;

import EntidadesDeJuego.Entidad.ActorDeJuego;

import java.awt.Graphics;
import java.util.ArrayList;

public class Controlador {

    //arreglo con los objetos del juego
    public ArrayList<ActorDeJuego> object = new ArrayList<ActorDeJuego>();

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

    void agregaObject(ActorDeJuego object) {
        this.object.add(object);
    }

    public void quitarObject(ActorDeJuego object) {
        this.object.remove(object);
    }

}