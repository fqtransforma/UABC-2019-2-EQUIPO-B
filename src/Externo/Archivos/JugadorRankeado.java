package Externo.Archivos;

import ComponentesDeJuego.Hud;
import java.io.Serializable;

public class JugadorRankeado implements Serializable {

    private String name;
    private int score;
    private int level;
    private int recycledTrash;

    //agarramos los datos que queremos guardar del hud para mostrar en leaderboards
    //el unico dato extra es el nombre del jugador
    public JugadorRankeado(String name) {
        this.name = name;
        this.score = Hud.puntaje;
        this.level = Hud.nivel;
        this.recycledTrash = Hud.basuraEntregada;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRecycledTrash() {
        return recycledTrash;
    }

    public void setRecycledTrash(int recycledTrash) {
        this.recycledTrash = recycledTrash;
    }

}
