package GameEntities.Actors.TrashTypes;

import External.ImageSetter;
import GameEntities.Entity.GameObject;
import GameEntities.Entity.ID;

import java.awt.*;

public class CardboardTrash extends GameObject {


    public CardboardTrash(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageSetter.cardboard,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {

        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
