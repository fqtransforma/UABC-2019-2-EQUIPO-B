package EntidadesDeJuego.Actores.Recicladoras;

import Externo.Archivos.Imagenes.SetterDeImagenes;
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
        g.setColor(Color.gray);
        g.fillRect((int)x,(int)y,200,128);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 200, 128);
    }
}
