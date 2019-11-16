package EntidadesDeJuego.Actores.Recicladoras;

import Externo.Archivos.SetterDeImagenes;
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
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, SetterDeImagenes.recicPlastic.getWidth(),
                SetterDeImagenes.recicPlastic.getHeight());
    }
}
