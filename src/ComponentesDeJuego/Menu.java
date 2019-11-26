package ComponentesDeJuego;

import Externo.Archivos.Imagenes.SetterDeImagenes;
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
        if(Juego.estado == Juego.ESTADO.Menu) {
            g.drawImage(SetterDeImagenes.menuBG, 0, 0, null);
        }

        //pinta el arreglo de jugadores
        else if(Juego.estado == Juego.ESTADO.LeaderBoards){
            g.drawImage(SetterDeImagenes.leaderboardsBG,0,0,null);
            g.setColor(Color.white);
            g.drawString("Leaderboards", Juego.ANCHO / 2 - 90, Juego.ALTURA / 4);
            if(lb.lista.size() >= 9) {
                for (int i = 0; i < 9; i++) {
                    g.drawString((i + 1) + ". " + lb.lista.get(i).getName() + " " + lb.lista.get(i).getScore(),
                            Juego.ANCHO / 2 - 120, (Juego.ALTURA / 3) + (i * 40));
                }
            }
            else{
                for (int i = 0; i < lb.lista.size(); i++) {
                    g.drawString((i + 1) + ". " + lb.lista.get(i).getName() + " " + lb.lista.get(i).getScore(),
                            Juego.ANCHO / 2 - 120, (Juego.ALTURA / 3) + (i * 40));
                }
            }

        }
    }
}
