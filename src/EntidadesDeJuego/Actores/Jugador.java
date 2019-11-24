package EntidadesDeJuego.Actores;

import Externo.Archivos.SetterDeImagenes;
import ComponentesDeJuego.Juego;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import ComponentesDeJuego.Controlador;
import ComponentesDeJuego.Hud;
import EntidadesDeJuego.Entidad.ID;
import Externo.InputUsuario.TecladoJugador;

import java.awt.*;

public class Jugador extends ActorDeJuego {

    private Controlador controlador;
    private int ancho = SetterDeImagenes.jugador[0].getWidth();
    private int altura = SetterDeImagenes.jugador[0].getHeight();
    private float aceleracion = 1f;
    private float desaceleracion = 0.5f;

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

    public void recompensaRecicladora(ID id){
        if(id == ID.RecicladoraCarton && Hud.cargaBasura[0]){
            Hud.cargaBasura[0] = false;
            Hud.puntaje += 90;
            Hud.basuraEntregada++;
            Hud.velocidadMAX += 0.5;
        }
        else if(id == ID.RecicladoraPlastico && Hud.cargaBasura[1]){
            Hud.cargaBasura[1] = false;
            Hud.puntaje += 90;
            Hud.basuraEntregada++;
            Hud.escudo +=5;
        }
        else if(id == ID.RecicladoraOrganica && Hud.cargaBasura[2]){
            Hud.cargaBasura[2] = false;
            Hud.puntaje += 90;
            Hud.basuraEntregada++;
            Hud.vida += 10;
        }
        else if(id == ID.RecicladoraAluminio && Hud.cargaBasura[3]){
            Hud.cargaBasura[3] = false;
            Hud.puntaje += 90;
            Hud.basuraEntregada++;
            Hud.escudo += 10;
        }
    }

    //detecta colision con recicladoras y valida que estemos cargando el material correcto
    public void colisionRecicladora(){

        for(int i = 0; i < controlador.object.size(); i++){

            ActorDeJuego tempObject = controlador.object.get(i);

            if(tempObject.getID() == ID.RecicladoraOrganica || tempObject.getID() == ID.RecicladoraPlastico
            || tempObject.getID() == ID.RecicladoraCarton || tempObject.getID() == ID.RecicladoraAluminio){

                if(getHorizontalBounds().intersects(tempObject.getBounds())){
                    recompensaRecicladora(tempObject.getID());
                    if(velX > 0){
                        velX = 0;
                        x = tempObject.getX() - ancho;
                    }
                    else if(velX < 0) {
                        velX = 0;
                        x = tempObject.getX() + 96;
                    }
                }

                if(getVerticalBounds().intersects(tempObject.getBounds())){
                    recompensaRecicladora(tempObject.getID());
                    if(velY > 0){
                        velY = 0;
                        y = tempObject.getY() - altura;
                    }
                    else if(velY < 0) {
                        velY = 0;
                        y = tempObject.getY() + 65;
                    }
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
                    Hud.puntaje+=100;
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

        //clamp para limitar velocidad
        velX = Juego.clamp(velX,-Hud.velocidadMAX,Hud.velocidadMAX);
        velY = Juego.clamp(velY,-Hud.velocidadMAX,Hud.velocidadMAX);

        //clamps para que no salga del nivel
        x = Juego.clamp(x,500, SetterDeImagenes.nivel1.getWidth()-500);
        y = Juego.clamp(y,500, SetterDeImagenes.nivel1.getHeight()-500);

        //movimiento horizontal
        if(TecladoJugador.teclas[0])
            velX+=aceleracion;
        else if(TecladoJugador.teclas[1])
            velX-=aceleracion;
        else if(!TecladoJugador.teclas[0] && !TecladoJugador.teclas[1]){
            velX = 0;
        }
        //movimiento vertical
        if(TecladoJugador.teclas[3])
            velY+=aceleracion;
        else if(TecladoJugador.teclas[2])
            velY-=aceleracion;
        else if(!TecladoJugador.teclas[2] && !TecladoJugador.teclas[3]){
            velY = 0;
        }

        //detecta todas las colisiones
        colisionEnemigo();
        colisionBasura();
        colisionRecicladora();
        colisionPortal();
    }

    //pinta jugador
    @Override
    public void render(Graphics g) {

        if(velX ==0 && velY == 0 || velY > 0)
            g.drawImage(SetterDeImagenes.jugador[2],(int)x,(int)y,null);
        else if(velY<0)
            g.drawImage(SetterDeImagenes.jugador[0],(int)x,(int)y,null);
        else if(velX>0)
            g.drawImage(SetterDeImagenes.jugador[1],(int)x,(int)y,null);
        else
            g.drawImage(SetterDeImagenes.jugador[3],(int)x,(int)y,null);
    }

    //retorna tamano del jugador
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,ancho,altura);
    }

    //rectangulo para detectar colisiones con obstaculos yendo horizontal
    public Rectangle getHorizontalBounds(){

        float bx = x + velX;
        float by = y;
        float bw = ancho + velX/3;
        float bh = altura;

        return new Rectangle((int)bx,(int)by,(int)bw,(int)bh);
    }

    //rectangulo para detectar colisiones con obstaculos yendo vertical
    public Rectangle getVerticalBounds(){

        float bx = x;
        float by = y + velY;
        float bw = ancho;
        float bh = altura + velY/3;

        return new Rectangle((int)bx,(int)by,(int)bw,(int)bh);
    }
}
