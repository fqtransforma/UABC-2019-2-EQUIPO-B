package GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//clase padre de todos los objetos de nuestro juego
public abstract class GameObject {

    protected float x, y;
    protected ID id;
    protected float velX, velY;
    public BufferedImage sprite = null;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    //setters y getters de las variables
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setID(ID id) {
        this.id = id;
    }
    public ID getID() {
        return id;
    }
    public void setVelX(float velX) {
        this.velX = velX;
    }
    public void setVelY(float velY) {
        this.velY = velY;
    }
    public float getVelX() {
        return velX;
    }
    public float velY() {
        return velY;
    }
}
