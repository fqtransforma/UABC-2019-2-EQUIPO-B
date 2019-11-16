package ComponentesDeJuego;

import Externo.Archivos.SetterDeImagenes;
import Externo.Archivos.Leaderboards;

import java.awt.*;

public class Menu{

    private Leaderboards lb;

    public Menu(Leaderboards lb){
        this.lb = lb;
    }

    //pinta menu
    public void render(Graphics g){

        //pinta el fondo
        g.drawImage(SetterDeImagenes.bg, 0, 0, null);
        //color y font y tamano a las letras
        g.setColor(Color.white);
        g.setFont(new Font("Serif Plain", 1, 30));

        //pinta el menu, play, lb y exit
        if(Juego.estado == Juego.ESTADO.Menu) {
            g.drawString("Jugar", Juego.ANCHO / 2 - 30, Juego.ALTURA / 4);
            g.drawString("Leaderboards", Juego.ANCHO / 2 - 90, Juego.ALTURA / 3);
            g.drawString("Salir", Juego.ANCHO / 2 - 30, (int) (Juego.ALTURA / 2.5));
        }
        //pinta el arreglo de jugadores
        else if(Juego.estado == Juego.ESTADO.LeaderBoards){
            g.drawString("Leaderboards", Juego.ANCHO / 2 - 90, Juego.ALTURA / 4);
            for(int i = 0; i < lb.lista.size(); i++){
                g.drawString((i+1)+"--"+lb.lista.get(i).getName()+"--"+lb.lista.get(i).getScore(),
                        Juego.ANCHO / 2 - 120, (Juego.ALTURA /3)+(i*40));
            }
        }
    }
}
