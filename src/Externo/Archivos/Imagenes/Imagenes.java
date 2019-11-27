package Externo.Archivos.Imagenes;

import Externo.Archivos.Imagenes.BufferedImageLoader;
import Externo.Archivos.Imagenes.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Imagenes {

    // Cargador de imágenes
    private static BufferedImageLoader BIL = new BufferedImageLoader();
    // Imágenes completas
    public static BufferedImage menuBG = null;
    public static BufferedImage leaderboardsBG = null;
    public static BufferedImage gameoverBG = null;
    public static BufferedImage nivel1 = null;
    public static BufferedImage nivel2 = null;
    public static BufferedImage nivel3 = null;
    public static BufferedImage nivel4 = null;
    public static BufferedImage nivel5 = null;
    public static BufferedImage nivel6 = null;
    private static BufferedImage jugadorSheet = null;
    private static BufferedImage enemigoBSheet = null;
    private static BufferedImage enemigoRSheet = null;
    private static BufferedImage jefeSheet = null;
    private static BufferedImage basuraSheet = null;
    private static BufferedImage recicladoraSheet = null;
    // Imágenes recortadas
    public static BufferedImage[] jugador = new BufferedImage[17];
    public static BufferedImage[] enemigoBasico = new BufferedImage[12];
    public static BufferedImage[] enemigoRapido = new BufferedImage[12];
    public static BufferedImage organico = null;
    public static BufferedImage aluminio = null;
    public static BufferedImage plastico = null;
    public static BufferedImage carton = null;
    public static BufferedImage recicOrganic = null;
    public static BufferedImage recicAlum = null;
    public static BufferedImage recicPlastic = null;
    public static BufferedImage recicCarton = null;
    public static BufferedImage[] jefe = new BufferedImage[12];

    public static void cargaImagenes() {
        cargaFondo();
        cargaBasura();
        cargaEnemigos();
        cargaJugador();
    }

    private static void cargaFondo(){
        try {
            // Carga imágenes completas
            menuBG = BIL.loadImage("res/Background/menuBG.png");
            leaderboardsBG = BIL.loadImage("res/Background/leaderboardsbg.png");
            gameoverBG = BIL.loadImage("res/Background/gameoverBG.png");
            nivel1 = BIL.loadImage("res/Niveles/nivel1.png");
            nivel2 = BIL.loadImage("res/Niveles/nivel2.png");
            nivel3 = BIL.loadImage("res/Niveles/nivel3.png");
            nivel4 = BIL.loadImage("res/Niveles/nivel4.png");
            nivel5 = BIL.loadImage("res/Niveles/nivel5.png");
            nivel6 = BIL.loadImage("res/Niveles/nivel6.png");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargaBasura(){
        try {
            // Carga imágenes completas
            basuraSheet = BIL.loadImage("res/Basura/Basura.png");
            //recicladoraSheet = BIL.loadImage("res/Recicladoras.png");
        }catch (IOException e) {

            e.printStackTrace();
        }
        // Inicializa los recortadores
        SpriteSheet tSheet = new SpriteSheet(basuraSheet);
        //SpriteSheet rsheet = new SpriteSheet(recicladoraSheet);
        // Imágenes recortadas
        organico = tSheet.grabImage(1,1,32,32);
        aluminio = tSheet.grabImage(2,1,32,32);
        plastico = tSheet.grabImage(3,1,32,32);
        carton = tSheet.grabImage(4,1,32,32);
        /*
        recicOrganic = rsheet.grabImage(1,1,96,64);
        recicAlum = rsheet.grabImage(2,1,96,64);
        recicPlastic = rsheet.grabImage(3,1,96,64);
        recicCarton = rsheet.grabImage(4,1,96,64);

         */
    }

    private static void cargaEnemigos(){
        try {
            // Carga imágenes completas
            enemigoBSheet = BIL.loadImage("res/Enemigos/enemigoAZUL.png");
            enemigoRSheet = BIL.loadImage("res/Enemigos/enemigoROJO.png");
            jefeSheet = BIL.loadImage("res/Enemigos/Jefe.png");
        }catch (IOException e) {

            e.printStackTrace();
        }
        // Inicializa los recortadores
        SpriteSheet eSheet = new SpriteSheet(enemigoBSheet);
        int contador = 0;
        // Imágenes recortadas
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++)
            enemigoBasico[contador++] = eSheet.grabImage(j + 1, i + 1,48,64);
        }

        eSheet = new SpriteSheet(enemigoRSheet);
        contador = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++)
                enemigoRapido[contador++] = eSheet.grabImage(j + 1, i + 1,48,64);
        }

        eSheet = new SpriteSheet(jefeSheet);
        contador = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++)
                jefe[contador++] = eSheet.grabImage(j + 1, i + 1,120,160);
        }
    }

    private static void cargaJugador(){
        try{
            jugadorSheet = BIL.loadImage("res/Jugador/jugador.png");
        }catch (IOException e){
            e.printStackTrace();
        }

        SpriteSheet jSheet = new SpriteSheet(jugadorSheet);

        jugador[0] = jSheet.grabImage(3,1,32,64);

        try{
            jugadorSheet = BIL.loadImage("res/Jugador/playerUP.png");
        }catch (IOException e){
            e.printStackTrace();
        }

        jSheet = new SpriteSheet(jugadorSheet);

        jugador[1] = jSheet.grabImage(1,1,32,64);
        jugador[2] = jSheet.grabImage(2,1,32,64);
        jugador[3] = jSheet.grabImage(3,1,32,64);
        jugador[4] = jSheet.grabImage(4,1,32,64);

        try{
            jugadorSheet = BIL.loadImage("res/Jugador/playerDOWN.png");
        }catch (IOException e){
            e.printStackTrace();
        }

        jSheet = new SpriteSheet(jugadorSheet);

        jugador[5] = jSheet.grabImage(1,1,32,64);
        jugador[6] = jSheet.grabImage(2,1,32,64);
        jugador[7] = jSheet.grabImage(3,1,32,64);
        jugador[8] = jSheet.grabImage(4,1,32,64);

        try{
            jugadorSheet = BIL.loadImage("res/Jugador/playerRIGHT.png");
        }catch (IOException e){
            e.printStackTrace();
        }

        jSheet = new SpriteSheet(jugadorSheet);

        jugador[9] = jSheet.grabImage(1,1,32,64);
        jugador[10] = jSheet.grabImage(2,1,32,64);
        jugador[11] = jSheet.grabImage(3,1,32,64);
        jugador[12] = jSheet.grabImage(4,1,32,64);

        try{
            jugadorSheet = BIL.loadImage("res/Jugador/playerLEFT.png");
        }catch (IOException e){
            e.printStackTrace();
        }

        jSheet = new SpriteSheet(jugadorSheet);

        jugador[13] = jSheet.grabImage(1,1,32,64);
        jugador[14] = jSheet.grabImage(2,1,32,64);
        jugador[15] = jSheet.grabImage(3,1,32,64);
        jugador[16] = jSheet.grabImage(4,1,32,64);
    }
}