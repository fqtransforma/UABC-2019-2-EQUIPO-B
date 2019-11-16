package EntidadesDeJuego.Actores.Enemigos;

import Externo.Archivos.SetterDeImagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import ComponentesDeJuego.Controlador;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class EnemigoBasico extends ActorDeJuego {

    private Controlador controlador;
    private ActorDeJuego jugador;
    private float diffX, diffY, distancia;

    //constructor del enemigo basico
    public EnemigoBasico(int x, int y, ID id, Controlador controlador) {
        super(x, y, id);
        this.controlador = controlador;
        encuentraJugador();
    }

    //busca el jugador para poder seguirlo
    public void encuentraJugador(){
        for(int i = 0; i < controlador.object.size(); i++){
            if(controlador.object.get(i).getID() == ID.Jugador)
                jugador = controlador.object.get(i);
        }
    }

    //logica de nuestro enemigo basico
    @Override
    public void tick() {
        //algoritmo para saber hacia donde esta el jugador
        if(jugador != null) {
            diffX = x - jugador.getX();
            diffY = y - jugador.getY();
            distancia = (float) Math.sqrt((x - jugador.getX()) * (x - jugador.getX()) + (y - jugador.getY()) * (y - jugador.getY()));

            //if para saber si el jugador esta cerca o no
            //si no esta cerca no lo sigue
            if(distancia <300){
                velX = (float) ((-1.0/ distancia)*diffX);
                velY = (float) ((-1.0/ distancia)*diffY);
                x += velX;
                y += velY;
            }
        }
        else
            //en caso de no haber encontrado jugador lo vuelve a buscar
            encuentraJugador();
    }

    @Override
    //pinta imagen del enemigo
    public void render(Graphics g) {
        g.drawImage(SetterDeImagenes.enemigobasico,(int)x,(int)y,null);
    }

    //retorna un rectangulo del tamano de la imagen para la colision con el jugador
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 32,48);
    }
}
