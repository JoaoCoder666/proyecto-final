package laberinto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemigo {
	private int x, y, ancho = 60, alto = 60;
    private int movimiento = 40, inicioX = 0,   inicioY = 0;;
    private boolean moviendoseDerecha = true;
    
    public Enemigo(int x, int y) {
    	this.x = x;
        this.y = y;
        this.inicioX = x;
        this.inicioY = y;
    }
    
    public void paint(Graphics grafico) {
        grafico.setColor(Color.blue);
        grafico.fillOval(x, y, ancho, alto);

        grafico.setColor(Color.black);
        grafico.drawOval(x, y, ancho, alto);
    }

    public void mover() {
        if (moviendoseDerecha) {
            x += movimiento;
        } else {
            x -= movimiento;
        }

        // Cambia la dirección al encontrar una pared
        if (x <= 40 || x >= 800) {
            moviendoseDerecha = !moviendoseDerecha;
        }
    }
    public void mover2() {
        if (moviendoseDerecha) {
            x += movimiento;
        } else {
            x -= movimiento;
        }

        // Cambia la dirección al encontrar una pared
        if (x <= 40 || x >= 800) {
            moviendoseDerecha = !moviendoseDerecha;
        }
    }
    public void mover3() {
        if (moviendoseDerecha) {
            x += movimiento;
        } else {
            x -= movimiento;
        }

        // Cambia la dirección al encontrar una pared
        if (x <= 40 || x >= 800) {
            moviendoseDerecha = !moviendoseDerecha;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, ancho, alto);
    }
    public void reiniciar() { 
    	x = inicioX;
        y = inicioY;
        moviendoseDerecha = true;
        
    	
    }

}
