package Laberinto;

import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Juego extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Laberinto laberinto = new Laberinto ();
	int num;
	Personaje personaje = new Personaje ();
	
	public Juego (int num) {
		addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				personaje.teclaPresionada(e, num);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		setFocusable(true);
		
	}
	
	public void paint (Graphics grafico) {
		
		laberinto.paint(grafico);
		personaje.paint(grafico);
		
		
	}

	
	
	  public void inicializarJuego(int num) throws InterruptedException {
	  JFrame miVentana = new JFrame ("Laberinto");
		
		
		Juego game = new Juego (num);
		
		miVentana.add(game); 
		miVentana.setSize(590, 360);
		miVentana.setBounds(267, 85, 590, 360);
		miVentana.setVisible(true);
		
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while(true) {
			
			Thread.sleep(10);
			game.repaint();
			
			
		}

	}
	 		
	
}
