package Laberinto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Personaje2 {
	LaberintoDificil lab = new LaberintoDificil();
	private int x = 40, y = 40, ancho = 40, alto = 40, movimiento = 40;

	public void paint(Graphics grafico) {

		grafico.setColor(Color.red);
		grafico.fillOval(x, y, ancho, alto);

		grafico.setColor(Color.black);
		grafico.drawOval(x, y, ancho, alto);

	}

	public void teclaPresionada(KeyEvent evento) {
		int[][] laberinto = lab.obtieneLaberinto();

		// Hacia la izquierda
		if (evento.getKeyCode() == 37) {// Hacia la izquierda
			if (laberinto[y / 40][(x / 40) - 1] != 1) {
				x = x - movimiento;
			}

		}
		if (evento.getKeyCode() == 39) {// Hacia la derecha
			if (laberinto[y / 40][(x / 40) + 1] != 1) {
				x = x + movimiento;
			}

		}
		if (evento.getKeyCode() == 40) {// Hacia abajo
			if (laberinto[(y / 40) + 1][(x / 40)] != 1) {
				y = y + movimiento;
			}

		}
		if (evento.getKeyCode() == 38) {// Hacia arriba
			if (laberinto[(y / 40) - 1][(x / 40)] != 1) {
				y = y - movimiento;
			}

		}
		
		if (x == 840 && y == 440) {
			Juego2.cambiarNivel();
			x = 40;
			y = 40;
			
		}

	}

}
