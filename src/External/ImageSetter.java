package External;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageSetter {

    public static BufferedImageLoader BIL = new BufferedImageLoader();
    //imagenes grandotas
    public static BufferedImage playerSheet = null;
    public static BufferedImage enemySheet = null;
    public static BufferedImage trashSheet = null;
    public static BufferedImage recyclerSheet = null;
    //recortador de imagenes
    public static SpriteSheet pSheet = null;
    public static SpriteSheet eSheet = null;
    public static SpriteSheet tSheet = null;
    public static SpriteSheet rsheet = null;
    //imagenes recortadas
    public static BufferedImage bg = null;
    public static BufferedImage levelbg = null;
    public static BufferedImage player = null;
    public static BufferedImage basicEnemy = null;
    public static BufferedImage fastEnemy = null;
    public static BufferedImage organic = null;
    public static BufferedImage aluminum = null;
    public static BufferedImage plastic = null;
    public static BufferedImage cardboard = null;
    public static BufferedImage organicRecycler = null;
    public static BufferedImage aluminumRecycler = null;
    public static BufferedImage plasticRecycler = null;
    public static BufferedImage cardboardRecycler = null;
    public static BufferedImage boss = null;

    public static void loadImages(){
        try{
            playerSheet = BIL.loadImage("res/player.png");
            enemySheet = BIL.loadImage("res/enemy.png");
            trashSheet = BIL.loadImage("res/trash.png");
            recyclerSheet = BIL.loadImage("res/recyclers.png");
            bg = BIL.loadImage("res/bg.jpg");
            levelbg = BIL.loadImage("res/level.jpg");
            boss = BIL.loadImage("res/Boss.png");
        }catch (IOException e){
            e.printStackTrace();
        }
        pSheet = new SpriteSheet(playerSheet);
        eSheet = new SpriteSheet(enemySheet);
        tSheet = new SpriteSheet(trashSheet);
        rsheet = new SpriteSheet(recyclerSheet);
        player = pSheet.grabImage(1,1,32,32);
        basicEnemy = eSheet.grabImage(1,1,32,48);
        fastEnemy = eSheet.grabImage(1,1,32,17);
        organic = tSheet.grabImage(1,1,32,32);
        aluminum = tSheet.grabImage(2,1,32,32);
        plastic = tSheet.grabImage(3,1,32,32);
        cardboard = tSheet.grabImage(4,1,32,32);
        organicRecycler = rsheet.grabImage(1,1,96,64);
        aluminumRecycler = rsheet.grabImage(2,1,96,64);
        plasticRecycler = rsheet.grabImage(3,1,96,64);
        cardboardRecycler = rsheet.grabImage(4,1,96,64);
    }
}
