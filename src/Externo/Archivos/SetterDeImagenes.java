package Externo.Archivos;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class SetterDeImagenes {

    //cargador de imagenes
    public static BufferedImageLoader BIL = new BufferedImageLoader();
    //imagenes completas
    public static BufferedImage menuBG = null;
    public static BufferedImage leaderboardsBG = null;
    public static BufferedImage nivel1 = null;
    public static BufferedImage nivel2 = null;
    public static BufferedImage jugadorSheet = null;
    public static BufferedImage enemigoSheet = null;
    public static BufferedImage basuraSheet = null;
    public static BufferedImage recicladoraSheet = null;
    //recortador de imagenes
    public static SpriteSheet jSheet = null;
    public static SpriteSheet eSheet = null;
    public static SpriteSheet tSheet = null;
    public static SpriteSheet rsheet = null;
    //imagenes recortadas
    public static BufferedImage jugador = null;
    public static BufferedImage enemigobasico = null;
    public static BufferedImage enemigoRapido = null;
    public static BufferedImage organico = null;
    public static BufferedImage aluminio = null;
    public static BufferedImage plastico = null;
    public static BufferedImage carton = null;
    public static BufferedImage recicOrganic = null;
    public static BufferedImage recicAlum = null;
    public static BufferedImage recicPlastic = null;
    public static BufferedImage recicCarton = null;
    public static BufferedImage jefe = null;

    public static void cargaImagenes(){
        try{
            //carga imagenes completas
            menuBG = BIL.loadImage("res/menuBG.png");
            leaderboardsBG = BIL.loadImage("res/leaderboardsbg.png");
            nivel1 = BIL.loadImage("res/nivel1.png");
            nivel2 = BIL.loadImage("res/nivel2.png");
            jugadorSheet = BIL.loadImage("res/Jugador.png");
            enemigoSheet = BIL.loadImage("res/Enemigo.png");
            basuraSheet = BIL.loadImage("res/Basura.png");
            recicladoraSheet = BIL.loadImage("res/Recicladoras.png");
            jefe = BIL.loadImage("res/Jefe.png");
        }catch (IOException e){
            e.printStackTrace();
        }
        //inicializa los recortadores
        jSheet = new SpriteSheet(jugadorSheet);
        eSheet = new SpriteSheet(enemigoSheet);
        tSheet = new SpriteSheet(basuraSheet);
        rsheet = new SpriteSheet(recicladoraSheet);
        //imagenes recortadas
        jugador = jSheet.grabImage(1,1,32,32);
        enemigobasico = eSheet.grabImage(1,1,32,48);
        enemigoRapido = eSheet.grabImage(1,1,32,17);
        organico = tSheet.grabImage(1,1,32,32);
        aluminio = tSheet.grabImage(2,1,32,32);
        plastico = tSheet.grabImage(3,1,32,32);
        carton = tSheet.grabImage(4,1,32,32);
        recicOrganic = rsheet.grabImage(1,1,96,64);
        recicAlum = rsheet.grabImage(2,1,96,64);
        recicPlastic = rsheet.grabImage(3,1,96,64);
        recicCarton = rsheet.grabImage(4,1,96,64);
    }
}
