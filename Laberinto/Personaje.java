package Laberinto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Kernel.Laberintos;

public class Personaje {
	Laberintos lab = new Laberintos ();
	private int x = 25, y = 25, ancho = 25, alto = 25, movimiento = 25;	
	
	public void paint (Graphics grafico) {
		
		grafico.setColor(Color.red);
		grafico.fillOval(x, y, ancho, alto);
		
		grafico.setColor(Color.black);
		grafico.drawOval(x, y, ancho, alto);
		
	}
	
	public void teclaPresionada (KeyEvent evento, int num) {
		int [][] laberinto = lab.obtieneLaberinto(num);
		
		//Hacia la izquierda
		if(evento.getKeyCode() == 37) {//Hacia la izquierda
			if(laberinto [y /25][(x/25)-1] != 1) {
				x = x - movimiento;
			}

		}if(evento.getKeyCode() == 39) {//Hacia la derecha
			if(laberinto [y /25][(x/25)+1] != 1) {
				x = x + movimiento;
			}
		
			
		}if(evento.getKeyCode() == 40) {//Hacia abajo
			if(laberinto [(y /25)+1][(x/25)] != 1) {
				y = y + movimiento;
			}
			
			
			
		}if(evento.getKeyCode() == 38) {//Hacia arriba
			if(laberinto [(y /25)-1][(x/25)] != 1) {
				y = y - movimiento;
			}

			
		}
		
	}

}
