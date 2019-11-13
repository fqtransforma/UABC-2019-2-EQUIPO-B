package GameEntities.Actors.TrashRecyclers;

import External.Files.ImageSetter;
import GameEntities.Entity.GameObject;

import java.awt.*;
import GameEntities.Entity.ID;

public class AluminumRecycler extends GameObject {

    public AluminumRecycler(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageSetter.aluminumRecycler,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,ImageSetter.aluminumRecycler.getWidth(),
                ImageSetter.aluminumRecycler.getHeight());
    }
}
