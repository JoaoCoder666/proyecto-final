package Laberinto;

import java.awt.Color;
import java.awt.Graphics;

import Kernel.Laberintos;

public class Laberinto {
	private int fila = 0, columna = 0, numeroFilas = 13, numeroColumnas = 23, anchoBloque= 25, altoBloque= 25,num;		
	Laberintos lab = new Laberintos ();
	
	public void paint (Graphics grafico) {
		int laberinto[][] = lab.obtieneLaberinto(num);
		for(fila = 0 ; fila < numeroFilas ; fila++) {
			for(columna = 0 ; columna < numeroColumnas ; columna++ ) {
				if(laberinto [fila][columna] == 1) {
					
					grafico.setColor(Color.blue);
					grafico.fillRect(columna*25, fila*25, anchoBloque, altoBloque);
					grafico.setColor(Color.black);
					grafico.drawRect(columna*25, fila*25, anchoBloque, altoBloque);
					
				}
				if(laberinto [fila][columna] == 0) {
					grafico.setColor(Color.white);
					grafico.fillRect(columna*25, fila*25, anchoBloque, altoBloque);
					
					
				}
				
				
			}
		}
	}
		
		
}
	
	
