package EntidadesDeJuego.Actores.Recicladoras;

import Externo.Archivos.SetterDeImagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class RecicCarton extends ActorDeJuego {
    public RecicCarton(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(SetterDeImagenes.recicCarton,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, SetterDeImagenes.recicCarton.getWidth(),
                SetterDeImagenes.recicCarton.getHeight());
    }
}
