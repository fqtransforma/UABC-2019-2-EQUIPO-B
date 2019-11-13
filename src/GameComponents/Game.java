package GameComponents;

import External.Files.ImageSetter;
import External.Files.Leaderboards;
import External.UserInput.KeyboardInput;
import External.UserInput.MouseClick;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    public static final int WIDTH = ((int)tk.getScreenSize().getWidth());
    public static final int HEIGHT = ((int)tk.getScreenSize().getHeight());
    //public static final int WIDTH = 1024;
    //public static final int HEIGHT = 600;
    private Thread thread;
    private boolean running = false;
    public static boolean capturePlayer;

    //partes del juego
    private Handler handler;
    private Menu menu;
    private Hud hud;
    private Level level;
    private Camera camera;
    private Leaderboards lb;
    private KeyboardInput kb;
    private MouseClick mc;

    //estados que controlan el juego
    public enum STATE{
        Menu(),
        Game(),
        LeaderBoards(),
        GameOver()
    }

    //estado inicial
    public static STATE state = STATE.Menu;

    //constructor del juego
    public Game(){
        init();
        new Window(WIDTH,HEIGHT,"Game",this);
        start();
    }

    //inicizizador de las partes del juego
    private void init(){
        ImageSetter.loadImages();
        handler = new Handler();
        lb = new Leaderboards();
        menu = new Menu(lb);
        hud = new Hud();
        level = new Level(handler);
        camera = new Camera(0,0,handler);
        kb = new KeyboardInput(handler,level);
        mc = new MouseClick(lb);
        this.addMouseListener(mc);
        this.addKeyListener(kb);
    }

    //inicializa hilo
    private synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    //detiene hilo
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

        if(state == STATE.Game) {
            //cambia a game over si se muere el jugador
            if(Hud.health == 0){
                state = STATE.GameOver;
            }
            //corre las variables de los componentes del juego
            level.tick();
            handler.tick();
            hud.tick();
            camera.tick();
        }
        else if(state == STATE.GameOver){
            //agrega jugador al arreglo, lo escribe y reinicia el juego
            if(capturePlayer) {
                lb.addRankedPlayer();
                lb.write();
                Hud.resetGame();
                level.resetLevels();
                handler.object.clear();
            }
            capturePlayer = false;
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

        //pinta menu
        if(state == STATE.Menu || state == STATE.LeaderBoards) {
            menu.render(g);
        }
        //pinta hud, nivel y actores
        else if(state == STATE.Game){
            g.setColor(Color.black);
            g.fillRect(0,0,WIDTH,HEIGHT);
            //g2d nos hace movernos con el jugador
            g2d.translate(-camera.getX(),-camera.getY());
            level.render(g);
            handler.render(g);
            g2d.translate(camera.getX(),camera.getY());
            //pinta hud
            hud.render(g);
        }
        else if(state == STATE.GameOver ) {
            //estado para cuando el jugador esta muerto
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

    //
    public static void main(String[] args) {
        new Game();
    }
}
