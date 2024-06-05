package Laberinto;

import java.awt.Color;
import java.awt.Graphics;

public class Laberinto {
	private int fila = 0, columna = 0, numeroFilas = 13, numeroColumnas = 23, anchoBloque= 40, altoBloque= 40;		
	
	public void paint (Graphics grafico) {
		int laberinto[][] = obtieneLaberinto();
		for(fila = 0 ; fila < numeroFilas ; fila++) {
			for(columna = 0 ; columna < numeroColumnas ; columna++ ) {
				if(laberinto [fila][columna] == 1) {
					
					grafico.setColor(Color.blue);
					grafico.fillRect(columna*40, fila*40, anchoBloque, altoBloque);
					grafico.setColor(Color.black);
					grafico.drawRect(columna*40, fila*40, anchoBloque, altoBloque);
					
				}
				if(laberinto [fila][columna] == 0) {
					grafico.setColor(Color.white);
					grafico.fillRect(columna*40, fila*40, anchoBloque, altoBloque);
					
					
				}
				
				
			}
		}
	}
	public int [][] obtieneLaberinto(){
		
		int laberinto[][]=
			{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{ 1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
			{ 1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1},
			{ 1,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
			{ 1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1},
			{ 1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,1},
			{ 1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1},
			{ 1,1,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
			{ 1,1,0,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1},
			{ 1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,1},
			{ 1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1},
			{ 1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
			{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

		 return laberinto;

}
		
		
	}
	
	
