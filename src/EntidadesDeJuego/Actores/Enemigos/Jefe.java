package EntidadesDeJuego.Actores.Enemigos;

import Externo.Archivos.SetterDeImagenes;
import ComponentesDeJuego.Controlador;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class Jefe extends ActorDeJuego {

    private Controlador controlador;
    private ActorDeJuego jugador;

    public Jefe(float x, float y, ID id, Controlador controlador) {
        super(x, y, id);
        this.controlador = controlador;
        encuentraJugador();
    }

    private void encuentraJugador(){
        for(int i = 0; i < controlador.object.size(); i++){
            if(controlador.object.get(i).getID() == ID.Jugador)
                jugador = controlador.object.get(i);
        }
    }

    @Override
    public void tick() {
        float diffX, diffY, distancia;
        //algoritmo para saber hacia donde esta el jugador
        if(jugador !=null) {
            diffX = x - jugador.getX();
            diffY = y - jugador.getY();
            distancia = (float) Math.sqrt((x - jugador.getX()) * (x - jugador.getX()) + (y - jugador.getY()) * (y - jugador.getY()));

            //if para saber si el jugador esta cerca o no
            if(distancia <1000){
                velX = (float) ((-1.0/ distancia)*diffX);
                velY = (float) ((-1.0/ distancia)*diffY);
                if(velX<0)
                    velX-=.8;
                else
                    velX+=.8;
                if(velY<0)
                    velY-=.8;
                else
                    velY+=.8;
                x += velX;
                y += velY;
            }
        }
        else
            encuentraJugador();
    }

    @Override
    public void render(Graphics g) {
            if(velX>0)
                g.drawImage(SetterDeImagenes.jefe[1],(int)x,(int)y,null);
            else
                g.drawImage(SetterDeImagenes.jefe[0],(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 76,108);
    }
}
