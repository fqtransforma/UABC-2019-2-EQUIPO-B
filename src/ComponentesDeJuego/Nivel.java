package ComponentesDeJuego;

import Externo.Archivos.SetterDeImagenes;
import EntidadesDeJuego.Actores.Enemigos.EnemigoBasico;
import EntidadesDeJuego.Actores.Enemigos.Jefe;
import EntidadesDeJuego.Actores.Enemigos.EnemigoRapido;
import EntidadesDeJuego.Actores.Jugador;
import EntidadesDeJuego.Actores.Recicladoras.RecicAlum;
import EntidadesDeJuego.Actores.Recicladoras.RecicCarton;
import EntidadesDeJuego.Actores.Recicladoras.RecicOrganic;
import EntidadesDeJuego.Actores.Recicladoras.RecicPlastico;
import EntidadesDeJuego.Actores.TiposBasura.Aluminio;
import EntidadesDeJuego.Actores.TiposBasura.Carton;
import EntidadesDeJuego.Actores.TiposBasura.Organico;
import EntidadesDeJuego.Actores.TiposBasura.Plastico;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;
import java.util.Random;

public class Nivel {

    private Controlador controlador;
    private boolean nivel1;
    private Random r;

    public Nivel(Controlador handler){
        this.controlador = handler;
        nivel1 = true;
        r = new Random();
    }

    //resetea booleandos para que objetos puedan volver a aparecer
    public void resetNiveles(){
        this.nivel1 = true;
    }

    //agrega los objetos correspondientes a cada nivel
    public void tick(){
        if(Hud.nivel == 1 && nivel1){
            nivel1 = false;
            controlador.agregaObject(new RecicAlum(48,448, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicCarton(48,650,ID.RecicladoraCarton));
            controlador.agregaObject(new RecicPlastico(48,800,ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(48,900,ID.RecicladoraOrganica));
            controlador.agregaObject(new Aluminio(500,500,ID.Aluminio));
            controlador.agregaObject(new Carton(500,700,ID.Carton));
            controlador.agregaObject(new Organico(500,800,ID.BasuraOrganica));
            controlador.agregaObject(new Plastico(500,600,ID.Plastico));
            controlador.agregaObject(new EnemigoBasico(r.nextInt(Juego.ANCHO), Juego.ALTURA /8+r.nextInt(Juego.ALTURA - Juego.ALTURA /8), ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoRapido(r.nextInt(Juego.ANCHO), Juego.ALTURA /8+r.nextInt(Juego.ALTURA - Juego.ALTURA /8), ID.EnemigoRapido, controlador));
            controlador.agregaObject(new Jefe(r.nextInt(Juego.ANCHO), Juego.ALTURA /8+r.nextInt(Juego.ALTURA - Juego.ALTURA /8), ID.Jefe, controlador));
            controlador.agregaObject(new Jugador(SetterDeImagenes.levelbg.getWidth()/2-32, SetterDeImagenes.levelbg.getHeight()/2-32, ID.Jugador, controlador));
        }
    }

    //pinta el fondo correspondiente de cada nivel
    public void render(Graphics g){
        if(Hud.nivel == 1){
            g.drawImage(SetterDeImagenes.levelbg,0, Juego.ANCHO /8,null);
        }
    }
}
