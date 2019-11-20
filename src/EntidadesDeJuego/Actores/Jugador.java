package EntidadesDeJuego.Actores;

import Externo.Archivos.SetterDeImagenes;
import ComponentesDeJuego.Juego;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import ComponentesDeJuego.Controlador;
import ComponentesDeJuego.Hud;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class Jugador extends ActorDeJuego {

    private Controlador controlador;

    public Jugador(int x, int y, ID id, Controlador controlador) {
        super(x, y, id);
        this.controlador = controlador;
    }

    //detecta colision con enemigos
    private void colisionEnemigo() {
        for(int i = 0; i < controlador.object.size(); i++) {

            ActorDeJuego tempObject = controlador.object.get(i);

            if(tempObject.getID() == ID.EnemigoBasico) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(Hud.escudo >0)
                        Hud.escudo -=2;
                    else
                        Hud.vida -=2;
                }
            }
            else if(tempObject.getID() == ID.EnemigoRapido){
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(Hud.escudo >0)
                        Hud.escudo -=1;
                    else
                        Hud.vida -=1;
                }
            }

            else if(tempObject.getID() == ID.Jefe){
                if(getBounds().intersects(tempObject.getBounds())) {
                    if(Hud.escudo >0)
                        Hud.escudo -=3;
                    else
                        Hud.vida -=3;
                }
            }
        }
    }

    //detecta colision con basura
    private void colisionBasura() {
        for(int i = 0; i < controlador.object.size(); i++) {

            ActorDeJuego tempObject = controlador.object.get(i);

            //if detecta con uso de booleanos que no este cargando otros tipos de basura
            if(tempObject.getID() == ID.Carton && !Hud.cargaBasura[0] && !Hud.cargaBasura[1]
            && !Hud.cargaBasura[2] && !Hud.cargaBasura[3]) {

                if(getBounds().intersects(tempObject.getBounds())) {
                    controlador.quitarObject(tempObject);
                    Hud.puntaje +=10;
                    Hud.cargaBasura[0] = true;
                }
            }

            else if(tempObject.getID() == ID.Plastico && !Hud.cargaBasura[0] && !Hud.cargaBasura[1]
                    && !Hud.cargaBasura[2] && !Hud.cargaBasura[3]) {

                if(getBounds().intersects(tempObject.getBounds())) {
                    controlador.quitarObject(tempObject);
                    Hud.puntaje +=10;
                    Hud.cargaBasura[1] = true;
                }
            }

            else if(tempObject.getID() == ID.BasuraOrganica && !Hud.cargaBasura[0] && !Hud.cargaBasura[1]
                    && !Hud.cargaBasura[2] && !Hud.cargaBasura[3]) {

                if(getBounds().intersects(tempObject.getBounds())) {
                    controlador.quitarObject(tempObject);
                    Hud.puntaje +=10;
                    Hud.cargaBasura[2] = true;
                }
            }

            else if(tempObject.getID() == ID.Aluminio && !Hud.cargaBasura[0] && !Hud.cargaBasura[1]
                    && !Hud.cargaBasura[2] && !Hud.cargaBasura[3]) {

                if(getBounds().intersects(tempObject.getBounds())) {
                    controlador.quitarObject(tempObject);
                    Hud.puntaje +=10;
                    Hud.cargaBasura[3] = true;
                }
            }
        }
    }

    //detecta colision con recicladoras y valida que estemos cargando el material correcto
    public void colisionRecicladora(){
        for(int i = 0; i < controlador.object.size(); i++) {

            ActorDeJuego tempObject = controlador.object.get(i);
            if (tempObject.getID() == ID.RecicladoraCarton && Hud.cargaBasura[0]){
                if(getBounds().intersects(tempObject.getBounds())) {
                    Hud.cargaBasura[0] = false;
                    /*try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        System.out.println("\n Error en Thread.sleep ...");
                    }*/
                    Hud.puntaje += 90;
                    Hud.basuraEntregada++;
                    Hud.velocidad += 0.1;
                }
            }
            else if (tempObject.getID() == ID.RecicladoraPlastico && Hud.cargaBasura[1]){
                if(getBounds().intersects(tempObject.getBounds())) {
                    Hud.cargaBasura[1] = false;
                    /*try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        System.out.println("\n Error en Thread.sleep ...");
                    }*/
                    Hud.puntaje += 90;
                    Hud.basuraEntregada++;
                }
            } // Pendiente las balas
            else if (tempObject.getID() == ID.RecicladoraOrganica && Hud.cargaBasura[2]){
                if(getBounds().intersects(tempObject.getBounds())) {
                    Hud.cargaBasura[2] = false;
                    /*try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        System.out.println("\n Error en Thread.sleep ...");
                    }*/
                    Hud.puntaje += 90;
                    Hud.basuraEntregada++;
                    Hud.vida += 10;
                }
            }
            else if (tempObject.getID() == ID.RecicladoraAluminio && Hud.cargaBasura[3]){
                if(getBounds().intersects(tempObject.getBounds())) {
                    Hud.cargaBasura[3] = false;
                    /*try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        System.out.println("\n Error en Thread.sleep ...");
                    }*/
                    Hud.puntaje += 90;
                    Hud.basuraEntregada++;
                    Hud.escudo += 10;
                }
            }
        }

    }

    public void colisionPortal(){
        for(int i = 0; i < controlador.object.size(); i++){
            ActorDeJuego tempObject = controlador.object.get(i);
            if(tempObject.getID() == ID.Portal){
                if(getBounds().intersects(tempObject.getBounds())){
                    Hud.nivel+=1;
                }
            }
        }
    }
    //logica del jugador
    @Override
    public void tick() {
        //movimiento
        x+=velX;
        y+=velY;

        //clamps para que no salga del nivel
        x = Juego.clamp(x,500, SetterDeImagenes.nivel1.getWidth()-500);
        y = Juego.clamp(y,500, SetterDeImagenes.nivel1.getHeight()-500);

        //detecta todas las colisiones
        colisionEnemigo();
        colisionBasura();
        colisionRecicladora();
        colisionPortal();
    }

    //pinta jugador
    @Override
    public void render(Graphics g) {
        g.drawImage(SetterDeImagenes.jugador,(int)x,(int)y,null);
    }

    //retorna tamano del jugador
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,32);
    }
}
