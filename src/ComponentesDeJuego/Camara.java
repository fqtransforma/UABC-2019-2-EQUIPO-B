package ComponentesDeJuego;

import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;

public class Camara {

    private int x,y;
    private Controlador handler;
    private ActorDeJuego tempPlayer = null;

    public Camara(int x, int y, Controlador handler){
        this.x = x;
        this.y = y;
        this.handler = handler;
    }

    private void findPlayer(){
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getID() == ID.Jugador){
                tempPlayer = handler.object.get(i);
                break;
            }
        }
    }

    public void tick(){
        findPlayer();
        x = (int)tempPlayer.getX() - Juego.ANCHO /2;
        y = (int)tempPlayer.getY() - (Juego.ALTURA - Juego.ALTURA /8)/2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
