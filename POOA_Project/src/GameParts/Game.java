package GameParts;

import External.ImageSetter;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    public static final int WIDTH = ((int)tk.getScreenSize().getWidth());
    public static final int HEIGHT = ((int)tk.getScreenSize().getHeight());
    //public static final int WIDTH = 1024;
    //public static final int HEIGHT = 600;
    private Thread thread;
    private boolean running = false;

    //partes del juego
    private Handler handler;
    private Menu menu;
    private Hud hud;
    private KeyboardInput kb;
    private Camera camera;

    //estados que controlan el juego
    public enum STATE{
        Menu(),
        Game(),
        GameOver()
    }

    public static STATE state = STATE.Menu;

    public Game(){
        init();
        new Window(WIDTH,HEIGHT,"Game",this);
        start();
    }

    //inicizizador de las partes del juego
    private void init(){
        ImageSetter.loadImages();
        handler = new Handler();
        menu = new Menu();
        hud = new Hud();
        kb = new KeyboardInput(handler);
        this.addMouseListener(menu);
        this.addKeyListener(kb);
        camera = new Camera(0,0,handler);
        handler.testObjects();
    }

    private synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //ciclo del juego
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double ammountOfTicks = 60.0;
        double ns = 1000000000 / ammountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running)
                render();

            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    //metodo que maneja la logica del juego
    private void tick(){
        if(state == STATE.Menu){

        }
        else if(state == STATE.Game) {
            if(Hud.health == 0){
                state = STATE.GameOver;
                Hud.resetGame();
            }
            handler.tick();
            hud.tick();
            camera.tick();
        }
        else if(state == STATE.GameOver ) {

        }
    }

    //metodo que pinta el juego
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D)g;

        if(state == STATE.Menu) {
            g.setColor(Color.black);
            g.fillRect(0,0,WIDTH,HEIGHT);
            menu.render(g);
        }
        else if(state == STATE.Game){
            g.setColor(new Color(123, 57, 23));
            g.fillRect(0,0,WIDTH,HEIGHT);
            //g2d.translate(-camera.getX(),-camera.getY());
            handler.render(g);
            //g2d.translate(camera.getX(),camera.getY());
            hud.render(g);
        }
        else if(state == STATE.GameOver ) {
            g.setColor(Color.black);
            g.fillRect(0,0,WIDTH,HEIGHT);
            g.setColor(Color.white);
            g.setFont(new Font("arial",3,100));
            g.drawString("YOU DIED",WIDTH/3,HEIGHT/2);
        }


        g.dispose();
        bs.show();
    }

    //metodo para limitar una variable a un valor minimo y maximo
    public static float clamp(float var, float min, float max){
        if(var >= max)
            return (var = max);
        else if(var <= min)
            return (var = min);
        else return var;
    }

    public static void main(String[] args) {
        new Game();
    }
}
