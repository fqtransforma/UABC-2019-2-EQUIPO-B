package GameEntities.Actors.TrashRecyclers;

import External.Files.ImageSetter;
import GameEntities.Entity.GameObject;
import GameEntities.Entity.ID;

import java.awt.*;

public class CardboardRecycler extends GameObject {
    public CardboardRecycler(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageSetter.cardboardRecycler,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,ImageSetter.cardboardRecycler.getWidth(),
                ImageSetter.cardboardRecycler.getHeight());
    }
}
