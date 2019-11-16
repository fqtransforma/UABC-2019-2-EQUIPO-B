package EntidadesDeJuego.Actores.Recicladoras;

import Externo.Archivos.SetterDeImagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;

import java.awt.*;
import EntidadesDeJuego.Entidad.ID;

public class RecicAlum extends ActorDeJuego {

    public RecicAlum(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(SetterDeImagenes.recicAlum,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, SetterDeImagenes.recicAlum.getWidth(),
                SetterDeImagenes.recicAlum.getHeight());
    }
}
