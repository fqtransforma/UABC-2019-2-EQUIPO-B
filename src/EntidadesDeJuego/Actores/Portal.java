package EntidadesDeJuego.Actores;

import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;
import java.util.Random;

public class Portal extends ActorDeJuego {

    private Random r;

    public Portal(float x, float y, ID id) {
        super(x, y, id);
        r = new Random();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(r.nextInt(255),0,r.nextInt(255)));
        g.fillRect((int)x,(int)y,75,150);
        g.setColor(Color.black);
        g.drawRect((int)x,(int)y,75,150);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,75,150);
    }
}