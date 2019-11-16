package ComponentesDeJuego;

import Externo.Archivos.SetterDeImagenes;
import Externo.Archivos.Leaderboards;
import Externo.InputUsuario.Teclado;
import Externo.InputUsuario.Mouse;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Juego extends Canvas implements Runnable {

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    //public static final int WIDTH = ((int)tk.getScreenSize().getWidth());
    //public static final int HEIGHT = ((int)tk.getScreenSize().getHeight());
    public static final int ANCHO = 1024;
    public static final int ALTURA = 600;
    private Thread thread;
    private boolean corriendo = false;
    public static boolean capturaJugador;

    //partes del juego
    private Controlador controlador;
    private Menu menu;
    private Hud hud;
    private Nivel nivel;
    private Camara camara;
    private Leaderboards lb;
    private Teclado teclado;
    private Mouse mouse;

    //estados que controlan el juego
    public enum ESTADO {
        Menu(),
        Juego(),
        LeaderBoards(),
        GameOver()
    }

    //estado inicial
    public static ESTADO estado = ESTADO.Menu;

    //constructor del juego
    public Juego(){
        init();
        new Pantalla(ANCHO, ALTURA,"Game",this);
        start();
    }

    //inicizizador de las partes del juego
    private void init(){
        SetterDeImagenes.cargaImagenes();
        controlador = new Controlador();
        lb = new Leaderboards();
        menu = new Menu(lb);
        hud = new Hud();
        nivel = new Nivel(controlador);
        camara = new Camara(0,0, controlador);
        teclado = new Teclado(controlador, nivel);
        mouse = new Mouse(lb);
        this.addMouseListener(mouse);
        this.addKeyListener(teclado);
        lb.leer();
    }

    //inicializa hilo
    private synchronized void start(){
        thread = new Thread(this);
        thread.start();
        corriendo = true;
    }

    //detiene hilo
    private synchronized void stop(){
        try{
            thread.join();
            corriendo = false;
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
        while(corriendo) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(corriendo)
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

        if(estado == ESTADO.Juego) {
            //cambia a game over si se muere el jugador
            if(Hud.vida == 0){
                estado = ESTADO.GameOver;
            }
            //corre las variables de los componentes del juego
            nivel.tick();
            controlador.tick();
            hud.tick();
            camara.tick();
        }
        else if(estado == ESTADO.GameOver){
            //agrega jugador al arreglo, lo escribe y reinicia el juego
            if(capturaJugador) {
                lb.addRankedPlayer();
                lb.escribre();
                Hud.resetJuego();
                nivel.resetNiveles();
                controlador.object.clear();
            }
            capturaJugador = false;
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
        if(estado == ESTADO.Menu || estado == ESTADO.LeaderBoards) {
            menu.render(g);
        }
        //pinta hud, nivel y actores
        else if(estado == ESTADO.Juego){
            g.setColor(Color.black);
            g.fillRect(0,0, ANCHO, ALTURA);
            //g2d nos hace movernos con el jugador
            g2d.translate(-camara.getX(),-camara.getY());
            nivel.render(g);
            controlador.render(g);
            g2d.translate(camara.getX(), camara.getY());
            //pinta hud
            hud.render(g);
        }
        else if(estado == ESTADO.GameOver ) {
            //estado para cuando el jugador esta muerto
            g.setColor(Color.black);
            g.fillRect(0,0, ANCHO, ALTURA);
            g.setColor(Color.white);
            g.setFont(new Font("arial",3,100));
            g.drawString("GAME OVER!!!", ANCHO /3, ALTURA /2);
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
        new Juego();
    }
}
