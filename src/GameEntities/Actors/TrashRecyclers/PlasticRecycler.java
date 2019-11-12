package GameEntities.Actors.TrashRecyclers;

import External.ImageSetter;
import GameEntities.Entity.GameObject;
import GameEntities.Entity.ID;

import java.awt.*;

public class PlasticRecycler extends GameObject {
    public PlasticRecycler(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageSetter.plasticRecycler,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,ImageSetter.plasticRecycler.getWidth(),
                ImageSetter.plasticRecycler.getHeight());
    }
}
