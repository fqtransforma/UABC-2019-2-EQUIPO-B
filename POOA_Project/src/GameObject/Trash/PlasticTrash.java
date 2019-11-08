package GameObject.Trash;

import External.ImageSetter;
import GameObject.GameObject;
import GameObject.ID;

import java.awt.*;

public class PlasticTrash extends GameObject {

    public PlasticTrash(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageSetter.plastic,(int)x,(int)y,null);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16 );
    }
}
