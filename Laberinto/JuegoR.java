package laberinto;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JuegoR extends JPanel {
    private static final long serialVersionUID = 1L;
    private LaberintoR laberinto;
    private PersonajeR personaje;
    public static int nivel = 1;

    public JuegoR() {
        this.laberinto = new LaberintoR();
        this.personaje = new PersonajeR(laberinto);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                personaje.teclaPresionada(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        setFocusable(true);
    }

    public void paint(Graphics grafico) {
        laberinto.paint(grafico);
        personaje.paint(grafico);
    }

    public static int cambiarNivel() {
        return nivel++;
    }

    public static int obtieneNivel() {
        return nivel;
    }

    public void iniciarJuego() throws InterruptedException {
        JFrame miVentana = new JFrame("Laberinto");
        JuegoR game = new JuegoR();
        miVentana.add(game);
        miVentana.setUndecorated(true);
        miVentana.setSize(920, 540);
        miVentana.setLocation(500, 200);
        miVentana.setVisible(true);

        while (true) {
            Thread.sleep(10);
            game.repaint();
            if (obtieneNivel() > 20) {
                miVentana.setVisible(false);
                break;
            }
        }
    }
}
