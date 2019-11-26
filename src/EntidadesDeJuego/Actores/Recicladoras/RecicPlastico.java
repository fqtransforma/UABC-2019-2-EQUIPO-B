package EntidadesDeJuego.Actores.Recicladoras;

import Externo.Archivos.Imagenes.SetterDeImagenes;
import EntidadesDeJuego.Entidad.ActorDeJuego;
import EntidadesDeJuego.Entidad.ID;

import java.awt.*;

public class RecicPlastico extends ActorDeJuego {
    public RecicPlastico(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(SetterDeImagenes.recicPlastic,(int)x,(int)y,null);
        g.setColor(Color.cyan);
        g.fillRect((int)x,(int)y,200,128);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 200,128);
    }
}
