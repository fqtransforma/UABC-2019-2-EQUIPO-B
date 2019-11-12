package External;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage image = sheet.getSubimage(col*width-width,row*height-height,width,height);
        return image;
    }
}
