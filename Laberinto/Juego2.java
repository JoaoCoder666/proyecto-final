package laberinto;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Juego2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	LaberintoDificil laberinto = new LaberintoDificil();
	Personaje2 personaje = new Personaje2();
	public static int nivel = 1;
	JFrame miVentana = new JFrame("Laberinto");

	public Juego2() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				personaje.teclaPresionada(e);

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		setFocusable(true);

	}

	public void paint(Graphics grafico) {

		laberinto.paint(grafico);
		personaje.paint(grafico);

	}
	
	
	
	public static int cambiarNivel () {
		return nivel++;
	}
	public static int obtieneNivel () {
		return nivel;
	}
	

	public void  iniciarJuego() throws InterruptedException {



		Juego2 game = new Juego2();

		miVentana.add(game);
		miVentana.setUndecorated(true);
		miVentana.setSize(920, 540);
		miVentana.setLocation(500, 200);
		miVentana.setVisible(true);

		while (true) {

			Thread.sleep(10);
			game.repaint();
			
			if (obtieneNivel () >3) {
				miVentana.setVisible(false);				
				break;
			}

		}

	}
	public void cerrarJuego() {
        
        if (miVentana != null) {
            miVentana.dispose();
        }
    }
	
	
	
	
}
