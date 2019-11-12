package GameEntities.Actors.TrashRecyclers;

import External.ImageSetter;
import GameEntities.Entity.GameObject;
import GameEntities.Entity.ID;

import java.awt.*;

public class OrganicRecycler extends GameObject {
    public OrganicRecycler(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageSetter.organicRecycler,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,ImageSetter.organicRecycler.getWidth(),
                ImageSetter.organicRecycler.getHeight());
    }
}
