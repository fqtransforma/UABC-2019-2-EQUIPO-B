package EntidadesDeJuego.Actores.TiposBasura;

import Externo.Archivos.Imagenes.Imagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class Carton extends ActorDeJuego {


    public Carton(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Imagenes.carton,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {

        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
