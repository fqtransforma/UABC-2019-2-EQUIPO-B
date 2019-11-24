package ComponentesDeJuego;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

class Pantalla extends Canvas{

    //la pantalla de nuestro juego
    Pantalla(int width, int height, String title, Juego game) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
    }
}
