package EntidadesDeJuego.Actores.Enemigos;

import Externo.Archivos.Imagenes.SetterDeImagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import ComponentesDeJuego.Controlador;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class EnemigoRapido extends ActorDeJuego {

    private Controlador controlador;
    private ActorDeJuego jugador;

    public EnemigoRapido(int x, int y, ID id, Controlador controlador) {
        super(x, y, id);
        this.controlador = controlador;
        encuentraJugador();
    }

    //buscac jugador para poder seguirlo
    private void encuentraJugador(){
        for(int i = 0; i < controlador.object.size(); i++){
            if(controlador.object.get(i).getID() == ID.Jugador)
                jugador = controlador.object.get(i);
        }
    }

    private void colisionRecicladora() {

        for(int i = 0; i < controlador.object.size(); i++) {

            ActorDeJuego tempObject = controlador.object.get(i);

            if(tempObject.getID() == ID.RecicladoraOrganica || tempObject.getID() == ID.RecicladoraPlastico
                    || tempObject.getID() == ID.RecicladoraCarton || tempObject.getID() == ID.RecicladoraAluminio) {

                if(getHorizontalBounds().intersects(tempObject.getBounds())) {
                    if(velX > 0){
                        velX = 0;
                        x = tempObject.getX() - 48;
                    }
                    else if(velX < 0) {
                        velX = 0;
                        x = tempObject.getX() + 200;
                    }
                }

                if(getVerticalBounds().intersects(tempObject.getBounds())) {
                    if(velY > 0){
                        velY = 0;
                        y = tempObject.getY() - 64;
                    }
                    else if(velY < 0) {
                        velY = 0;
                        y = tempObject.getY() + 128;
                    }
                }
            }
        }
    }

    @Override
    public void tick() {
        float diffX, diffY, distancia;
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

            colisionRecicladora();
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

    private Rectangle getHorizontalBounds() {

        float bx = x + velX;
        float by = y;
        float bw = 48 + velX/3;
        float bh = 64;

        return new Rectangle((int)bx,(int)by,(int)bw,(int)bh);
    }

    // Rectángulo para detectar colisiones con obstáculos eje horizontal
    private Rectangle getVerticalBounds() {

        float bx = x;
        float by = y + velY;
        float bw = 48;
        float bh = 64 + velY/3;

        return new Rectangle((int)bx,(int)by,(int)bw,(int)bh);
    }
}
