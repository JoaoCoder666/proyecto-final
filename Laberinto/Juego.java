package Laberinto;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;


import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Juego extends JPanel {

	 private static final long serialVersionUID = 2L;
	    LaberintoFacil laberinto = new LaberintoFacil();
	    static Personaje personaje = new Personaje();
	    static Enemigo enemigo = new Enemigo(1, 430); // Añadir enemigo
	    static Enemigo enemigo2 = new Enemigo(1, 330);
	    static Enemigo enemigo3 = new Enemigo(1, 130);
	    public static int nivel = 1;
	    private Timer timer;
	    private Timer timer1;
	    private Timer timer2;
	    JFrame miVentana = new JFrame("Laberinto");

	    public Juego() {
	        addKeyListener(new KeyListener() {
	            @Override
	            public void keyTyped(KeyEvent e) {}

	            @Override
	            public void keyPressed(KeyEvent e) {
	                personaje.teclaPresionada(e);

	                // Comprobar colisión con enemigo
	                if (nivel == 1 && personaje.getBounds().intersects(enemigo.getBounds())) {
	                	reiniciarJuegoCompleto();
	                }
	                if (nivel == 2 && personaje.getBounds().intersects(enemigo2.getBounds())) {
	                	 reiniciarJuegoCompleto();
	                }
	                if (nivel ==3 && personaje.getBounds().intersects(enemigo3.getBounds())) {
	                	 reiniciarJuegoCompleto();
	                }
	            }

	            @Override
	            public void keyReleased(KeyEvent e) {}
	        });
	        setFocusable(true);

	        iniciarTimers();
	    }

	    private void iniciarTimers() {
	        detenerTimers(); // Detener cualquier timer que esté en ejecución

	        ActionListener actionListener = new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                enemigo.mover();
	                repaint();
	            }
	        };
	        timer = new Timer(100, actionListener);
	        timer.start();

	        ActionListener actionListener2 = new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                enemigo2.mover2();
	                repaint();
	            }
	        };
	        timer1 = new Timer(100, actionListener2);
	        timer1.start();

	        ActionListener actionListener3 = new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                enemigo3.mover3();
	                repaint();
	            }
	        };
	        timer2 = new Timer(100, actionListener3);
	        timer2.start();
	    }

	    public void paint(Graphics grafico) {
	        laberinto.paint(grafico);
	        personaje.paint(grafico);
	        if (obtieneNivel() == 1) {
	            enemigo.paint(grafico);
	        }
	        if (obtieneNivel() == 2) {
	            enemigo2.paint(grafico);
	        }
	        if (obtieneNivel() == 3) {
	            enemigo3.paint(grafico);
	        }
	    }

	    public static int cambiarNivel() {
	        return nivel++;
	    }

	    public static int obtieneNivel() {
	        return nivel;
	    }

	    public void iniciarJuego() throws InterruptedException {

	       
	        Juego game = new Juego();
	        
	        detenerTimers();
	        miVentana.add(game);
	        miVentana.setSize(920, 540);
	        miVentana.setLocation(300, 200);
	        miVentana.setUndecorated(true);
	        miVentana.setVisible(true);
	        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        while (true) {
	            Thread.sleep(10);
	            game.repaint();

	            if (obtieneNivel() > 3) {
	                miVentana.setVisible(false);
	                break;
	            }

	            verificarColisiones(miVentana);
	        }
	    }

	    private void verificarColisiones(JFrame miVentana) {
	        try {
	            if (obtieneNivel() == 1 && personaje.getBounds().intersects(enemigo.getBounds())) {
	                manejarColision(miVentana);
	            }
	        } catch (HeadlessException e1) {
	            e1.printStackTrace();
	        }

	        try {
	            if (obtieneNivel() == 2 && personaje.getBounds().intersects(enemigo2.getBounds())) {
	            	reiniciarJuegoCompleto();
	                manejarColision(miVentana);
	            }
	        } catch (HeadlessException e1) {
	            e1.printStackTrace();
	        }

	        try {
	            if (obtieneNivel() == 3 && personaje.getBounds().intersects(enemigo3.getBounds())) {
	                manejarColision(miVentana);
	                reiniciarJuegoCompleto();
	            }
	        } catch (HeadlessException e1) {
	            e1.printStackTrace();
	        }
	    }

	    private void manejarColision(JFrame miVentana) {
	        detenerTimers();
	        
	        reiniciarNivel();
	      
	    }

	    public void reiniciarNivel() {
	        personaje.reiniciar();
	        enemigo.reiniciar();
	        enemigo2.reiniciar();
	        enemigo3.reiniciar();
	        iniciarTimers();
	        repaint();
	    }

	    private void detenerTimers() {
	        if (timer != null) timer.stop();
	        if (timer1 != null) timer1.stop();
	        if (timer2 != null) timer2.stop();
	    }
	    
	    public void reiniciarJuegoCompleto() {
	        nivel = 1;
	        detenerTimers();
	        reiniciarNivel();
	    }
	    public void cerrarJuego() {
	        detenerTimers();
	        if (miVentana != null) {
	            miVentana.dispose();
	        }
	    }

            
}
       

	
	
	


