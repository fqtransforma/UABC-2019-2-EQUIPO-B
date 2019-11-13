package External;

import GameComponents.Hud;

import java.io.Serializable;

public class RankedPlayer implements Serializable {

    private String name;
    private int score;
    private int level;
    private int recycledTrash;

    public RankedPlayer(String name) {
        this.name = name;
        this.score = Hud.score;
        this.level = Hud.level;
        this.recycledTrash = Hud.deliveredTrash;
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
