package ComponentesDeJuego;

import Externo.Archivos.Imagenes.Imagenes;
import Externo.Archivos.Jugador.Leaderboards;

import java.awt.*;

public class Menu{

    private Leaderboards lb;

    Menu(Leaderboards lb){
        this.lb = lb;
    }

    //pinta menu
    public void render(Graphics g){

        //color y font y tamano a las letras
        g.setFont(new Font("Serif Plain", 1, 30));

        //pinta el fondo
        if(Juego.estado == Juego.ESTADO.Menu)
            g.drawImage(Imagenes.menuBG, 0, 0, Juego.ANCHO,Juego.ALTURA,null);

        //pinta el arreglo de jugadores
        else if(Juego.estado == Juego.ESTADO.LeaderBoards){
            g.drawImage(Imagenes.leaderboardsBG,0,0,Juego.ANCHO,Juego.ALTURA,null);
            g.setColor(Color.white);
            if(lb.lista.size()<10)
            for (int i = 0; i < lb.lista.size(); i++) {
                g.drawString((i + 1) + ". " + lb.lista.get(i).getName() + " " + lb.lista.get(i).getScore(),
                        Juego.ANCHO / 2 - 120, (Juego.ALTURA / 4) + (i * 40));
            }
            else{
                for (int i = 0; i < 10; i++) {
                    g.drawString((i + 1) + ". " + lb.lista.get(i).getName() + " " + lb.lista.get(i).getScore(),
                            Juego.ANCHO / 2 - 120, (Juego.ALTURA / 4) + (i * 40));
                }
            }
        }
    }
}
