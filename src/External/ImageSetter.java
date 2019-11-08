package External;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageSetter {

    public static BufferedImageLoader BIL = new BufferedImageLoader();
    //imagenes grandotas
    public static BufferedImage playerSheet = null;
    public static BufferedImage enemySheet = null;
    public static BufferedImage trashSheet = null;
    //recortador de imagenes
    public static SpriteSheet pSheet = null;
    public static SpriteSheet eSheet = null;
    public static SpriteSheet tSheet = null;
    //imagenes recortadas
    public static BufferedImage player = null;
    public static BufferedImage basicEnemy = null;
    public static BufferedImage fastEnemy = null;
    public static BufferedImage organic = null;
    public static BufferedImage aluminum = null;
    public static BufferedImage plastic = null;
    public static BufferedImage cardboard = null;

    public static void loadImages(){
        try{
            playerSheet = BIL.loadImage("res/player.png");
            enemySheet = BIL.loadImage("res/enemy.png");
            trashSheet = BIL.loadImage("res/trash2.png");
        }catch (IOException e){
            e.printStackTrace();
        }
        pSheet = new SpriteSheet(playerSheet);
        eSheet = new SpriteSheet(enemySheet);
        tSheet = new SpriteSheet(trashSheet);
        player = pSheet.grabImage(1,1,32,32);
        basicEnemy = eSheet.grabImage(1,1,32,48);
        fastEnemy = eSheet.grabImage(1,1,32,17);
        organic = tSheet.grabImage(1,1,16,16);
        aluminum = tSheet.grabImage(1,2,16,16);
        plastic = tSheet.grabImage(1,3,16,16);
        cardboard = tSheet.grabImage(1,4,16,16);
    }
}
