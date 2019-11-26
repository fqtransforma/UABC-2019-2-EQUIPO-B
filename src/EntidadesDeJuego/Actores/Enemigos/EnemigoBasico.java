package EntidadesDeJuego.Actores.Enemigos;

import Externo.Archivos.Imagenes.SetterDeImagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import ComponentesDeJuego.Controlador;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class EnemigoBasico extends ActorDeJuego {

    private Controlador controlador;
    private ActorDeJuego jugador;

    //constructor del enemigo basico
    public EnemigoBasico(int x, int y, ID id, Controlador controlador) {
        super(x, y, id);
        this.controlador = controlador;
        encuentraJugador();
    }

    //busca el jugador para poder seguirlo
    private void encuentraJugador(){
        for(int i = 0; i < controlador.object.size(); i++){
            if(controlador.object.get(i).getID() == ID.Jugador)
                jugador = controlador.object.get(i);
        }
    }

    //logica de nuestro enemigo basico
    @Override
    public void tick() {
        float diffX, diffY, distancia;
        //algoritmo para saber hacia donde esta el jugador
        if(jugador != null) {
            diffX = x - jugador.getX();
            diffY = y - jugador.getY();
            distancia = (float) Math.sqrt((x - jugador.getX()) * (x - jugador.getX()) + (y - jugador.getY()) * (y - jugador.getY()));

            //if para saber si el jugador esta cerca o no
            //si no esta cerca no lo sigue
            if(distancia < 300){
                velX = (float) ((-1.0/ distancia)*diffX);
                velY = (float) ((-1.0/ distancia)*diffY);
                if(velX<0)
                    velX-=0.8;
                else //si se mueve en x, agregar velocidad positiva
                    velX+=0.8;
                if(velY<0) // si se mueve en -y, agregar velocidad negativa
                    velY-=0.8;
                else //si se mueve en y, agregar velocidad positiva
                    velY+=0.8;
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
        if(velX>0)
                g.drawImage(SetterDeImagenes.enemigoBasico[1], (int) x, (int) y, null);
        else
            g.drawImage(SetterDeImagenes.enemigoBasico[0],(int)x,(int)y,null);
    }

    //retorna un rectangulo del tamano de la imagen para la colision con el jugador
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 36,52);
    }
}
