package ComponentesDeJuego;

import EntidadesDeJuego.Actores.Enemigos.EnemigoRapido;
import EntidadesDeJuego.Actores.Portal;
import Externo.Archivos.Imagenes.SetterDeImagenes;
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
    private boolean[] portal = new boolean[6];
    private boolean[] nivel = new boolean[6];
    private Random r;

    Nivel(Controlador handler) {
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
    
    private void abrePortales() {
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
        // Nivel 1
        if(Hud.nivel == 1 && nivel[0]) {

            nivel[0] = false;
            //AudioPlayer.playBackground("res/Sonido/Niveles/Nivel2.wav");
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000,2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300,2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700,2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000,2000, ID.RecicladoraCarton));
            // Basura
            controlador.agregaObject(new Plastico(1000,1200, ID.Plastico));
            controlador.agregaObject(new Aluminio(1250,1200, ID.Aluminio));
            controlador.agregaObject(new Organico(1750,1200, ID.BasuraOrganica));
            controlador.agregaObject(new Carton(2000,1200, ID.Carton));
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,1000, ID.EnemigoBasico, controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }
        // Nivel 2
        else if(Hud.nivel == 2 && nivel[1]) {
            nivel[1] = false;
            //AudioPlayer.playBackground("res/Sonido/Niveles/Nivel2.wav");
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000,2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300,2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700,2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000,2000, ID.RecicladoraCarton));
            // Basura
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480),510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480),510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Carton));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Carton));
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1000,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,2250, ID.EnemigoBasico, controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }
        // Nivel 3
        else if(Hud.nivel == 3 && nivel[2]) {
            nivel[2] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000,2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300,2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700,2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000,2000, ID.RecicladoraCarton));
            // Basura
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480),510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480),510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Carton));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480),510 + r.nextInt(690), ID.Carton));
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1000,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000,2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500,1700, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoRapido(500,500,ID.EnemigoRapido,controlador));
            controlador.agregaObject(new EnemigoRapido(2500,2500,ID.EnemigoRapido,controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }

        // Nivel 4
        else if(Hud.nivel == 4 && nivel[3]) {
            nivel[3] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000, 2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300, 2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700, 2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000, 2000, ID.RecicladoraCarton));
            // Basura
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Carton));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Carton));
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000, 1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000, 1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1000, 2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500, 2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000, 2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500, 1700, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoRapido(500, 500, ID.EnemigoRapido, controlador));
            controlador.agregaObject(new EnemigoRapido(2500, 2500, ID.EnemigoRapido, controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }

        // Nivel 5
        else if(Hud.nivel == 5 && nivel[4]) {
            nivel[4] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000, 2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300, 2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700, 2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000, 2000, ID.RecicladoraCarton));
            // Basura
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Carton));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Carton));
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000, 1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000, 1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1000, 2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500, 2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000, 2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500, 1700, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoRapido(500, 500, ID.EnemigoRapido, controlador));
            controlador.agregaObject(new EnemigoRapido(2500, 2500, ID.EnemigoRapido, controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
        }

        // Nivel 6
        else if(Hud.nivel == 6 && nivel[5]) {
            nivel[5] = false;
            // Limpia nivel pasado
            controlador.object.clear();
            // Recicladoras
            controlador.agregaObject(new RecicAlum(1000, 2000, ID.RecicladoraAluminio));
            controlador.agregaObject(new RecicPlastico(1300, 2000, ID.RecicladoraPlastico));
            controlador.agregaObject(new RecicOrganic(1700, 2000, ID.RecicladoraOrganica));
            controlador.agregaObject(new RecicCarton(2000, 2000, ID.RecicladoraCarton));
            // Basura
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Plastico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Plastico));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Aluminio(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Aluminio));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Organico(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.BasuraOrganica));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Carton));
            controlador.agregaObject(new Carton(510 + r.nextInt(1480), 510 + r.nextInt(690), ID.Carton));
            // Enemigos
            controlador.agregaObject(new EnemigoBasico(1000, 1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000, 1000, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1000, 2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500, 2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(2000, 2250, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoBasico(1500, 1700, ID.EnemigoBasico, controlador));
            controlador.agregaObject(new EnemigoRapido(500, 500, ID.EnemigoRapido, controlador));
            controlador.agregaObject(new EnemigoRapido(2500, 2500, ID.EnemigoRapido, controlador));
            // Jugador
            controlador.agregaObject(new Jugador(1500, 1900, ID.Jugador, controlador));
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
        else if(Hud.nivel == 4) {

            g.drawImage(SetterDeImagenes.nivel4,0, Juego.ANCHO /8,null);
        }
        else if(Hud.nivel == 5) {

            g.drawImage(SetterDeImagenes.nivel5,0, Juego.ANCHO /8,null);
        }
        else if(Hud.nivel == 6) {

            g.drawImage(SetterDeImagenes.nivel6,0, Juego.ANCHO /8,null);
        }
    }
}
