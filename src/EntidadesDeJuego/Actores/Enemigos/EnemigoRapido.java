package EntidadesDeJuego.Actores.Enemigos;

import Externo.Archivos.SetterDeImagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import ComponentesDeJuego.Controlador;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class EnemigoRapido extends ActorDeJuego {

    private Controlador controlador;
    private ActorDeJuego jugador;
    private float diffX, diffY, distancia;

    public EnemigoRapido(int x, int y, ID id, Controlador controlador) {
        super(x, y, id);
        this.controlador = controlador;
        encuentraJugador();
    }

    //buscac jugador para poder seguirlo
    public void encuentraJugador(){
        for(int i = 0; i < controlador.object.size(); i++){
            if(controlador.object.get(i).getID() == ID.Jugador)
                jugador = controlador.object.get(i);
        }
    }

    @Override
    public void tick() {
        if(jugador !=null) {
            diffX = x - jugador.getX();
            diffY = y - jugador.getY();
            distancia = (float) Math.sqrt((x - jugador.getX()) * (x - jugador.getX()) + (y - jugador.getY()) * (y - jugador.getY()));

            if(distancia <500){
                velX = (float) ((-1.0/ distancia)*diffX);
                velY = (float) ((-1.0/ distancia)*diffY);
                //si se mueve en - x, agregar velocidad negativa
                if(velX<0)
                    velX-=1.2;
                else //si se mueve en x, agregar velocidad positiva
                    velX+=1.2;
                if(velY<0) // si se mueve en -y, agregar velocidad negativa
                    velY-=1.2;
                else //si se mueve en y, agregar velocidad positiva
                    velY+=1.2;
                //agregamos velocidades a posicion del enemigo
                x += velX;
                y += velY;
            }
        }
        else
            //busca jugador en caso de no encontrarlo
            encuentraJugador();
    }

    //pinta imagen de enemigo
    @Override
    public void render(Graphics g) {
        if(velX>0)
            g.drawImage(SetterDeImagenes.enemigoRapido[1], (int) x, (int) y, null);
        else
            g.drawImage(SetterDeImagenes.enemigoRapido[0],(int)x,(int)y,null);
    }

    //retorna rectangulo del tamano de la imagen del enemigo
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 36,52);
    }
}
