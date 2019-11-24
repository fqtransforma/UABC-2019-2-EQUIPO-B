package ComponentesDeJuego;

import EntidadesDeJuego.Actores.Enemigos.EnemigoRapido;
import EntidadesDeJuego.Actores.Enemigos.Jefe;
import EntidadesDeJuego.Actores.Portal;
import Externo.Archivos.SetterDeImagenes;
import EntidadesDeJuego.Actores.Enemigos.EnemigoBasico;
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
    private boolean[] portal = new boolean[5];
    private boolean[] nivel = new boolean[5];
    private Random r;

    public Nivel(Controlador handler) {

        this.controlador = handler;

        for(int i = 0; i < 5; i++) {

            portal[i] = true;
            nivel[i] = true;
        }
        r = new Random();
    }

    // Resetea booleandos para que objetos puedan volver a aparecer
    public void resetNivel() {

        for(int i = 0; i < 5; i++) {

            portal[i] = true;
            nivel[i] = true;
        }
    }
    
    public void abrePortales() {

        if(Hud.basuraEntregada == 4 && Hud.nivel == 1 && portal[0]) {
            portal[0] = false;
            controlador.agregaObject(new Portal(1500,1500, ID.Portal));
        }
        else if(Hud.basuraEntregada == 12 && Hud.nivel == 2 && portal[1]) {
            portal[1] = false;
            controlador.agregaObject(new Portal(1500, 1500, ID.Portal));
        }
    }

    // Agrega los objetos correspondientes a cada nivel
    public void tick() {

        abrePortales();

        if(Hud.nivel == 1 && nivel[0]) {

            nivel[0] = false;
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000,1000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1000,2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(2000,1000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000,2000, ID.RecicladoraCarton));
            // Basura
            controlador.agregaObject(new Plastico(1500,1000, ID.Plastico));
            controlador.agregaObject(new Aluminio(1500,2000, ID.Aluminio));
            controlador.agregaObject(new Organico(1000,1500, ID.BasuraOrganica));
            controlador.agregaObject(new Carton(2000,1500, ID.Carton));
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(750,750, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2250,750, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(750,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2250,2250, ID.EnemigoBasico, controlador));
            // Jugador
            controlador.agregaObject(new Jugador(SetterDeImagenes.nivel1.getWidth()/2, SetterDeImagenes.nivel1.getHeight()/2, ID.Jugador, controlador));
        }
        else if(Hud.nivel == 2 && nivel[1]) {

            nivel[1] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000,1000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1000,2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(2000,1000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000,2000, ID.RecicladoraCarton));
            // Basura
            controlador.agregaObject(new Plastico(1500,1000, ID.Plastico));
            controlador.agregaObject(new Plastico(2500,1500, ID.Plastico));
            controlador.agregaObject(new Aluminio(1500,2000, ID.Aluminio));
            controlador.agregaObject(new Aluminio(1000,2000, ID.Aluminio));
            controlador.agregaObject(new Organico(1000,1500, ID.BasuraOrganica));
            controlador.agregaObject(new Organico(2000,1500, ID.BasuraOrganica));
            controlador.agregaObject(new Carton(2000,1600, ID.Carton));
            controlador.agregaObject(new Carton(1800,1300, ID.Carton));
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(750,750, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2250,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2250,750, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2250,750, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(750,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(750,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2250,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2250,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoRapido(1800, 1300, ID.EnemigoRapido, controlador));
            // Jugador
            controlador.agregaObject(new Jugador(SetterDeImagenes.nivel2.getWidth()/2, SetterDeImagenes.nivel2.getHeight()/2, ID.Jugador, controlador));
        }
        else if(Hud.nivel == 3 && nivel[2]) {

            nivel[2] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            // Basura
            // Enemigos
            controlador.agregaObject(new Jefe(500,500,ID.Jefe,controlador));
            // Jugador
            controlador.agregaObject(new Jugador(SetterDeImagenes.nivel3.getWidth()/2, SetterDeImagenes.nivel3.getHeight()/2, ID.Jugador, controlador));
        }
    }

    // Pinta el fondo correspondiente de cada nivel
    public void render(Graphics g){
        if(Hud.nivel == 1) {

            g.drawImage(SetterDeImagenes.nivel1,0, Juego.ANCHO /8,null);
        }
        else if(Hud.nivel == 2) {

            g.drawImage(SetterDeImagenes.nivel2,0, Juego.ANCHO /8,null);
        }
        else if(Hud.nivel == 3) {

            g.drawImage(SetterDeImagenes.nivel3,0, Juego.ANCHO /8,null);
        }
    }
}
