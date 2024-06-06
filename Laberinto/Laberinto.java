package Laberinto;

import java.awt.Color;
import java.awt.Graphics;

public class Laberinto {
	private int fila = 0, columna = 0, numeroFilas = 13, numeroColumnas = 23, anchoBloque = 40, altoBloque = 40;
	private int [][]lab = new int[13][23] ;
	
	public void paint(Graphics grafico) {
		int laberinto[][] = obtieneLaberinto();
		for (fila = 0; fila < numeroFilas; fila++) {
			for (columna = 0; columna < numeroColumnas; columna++) {
				if (laberinto[fila][columna] == 1) {
					if(Juego.obtieneNivel() == 1) {
						grafico.setColor(Color.darkGray);
					}
					if(Juego.obtieneNivel() == 2) {
						grafico.setColor(Color.pink);
					}
					if(Juego.obtieneNivel() == 3) {
						grafico.setColor(Color.magenta);
					}
					
					grafico.fillRect(columna * 40, fila * 40, anchoBloque, altoBloque);
					grafico.setColor(Color.black);
					grafico.drawRect(columna * 40, fila * 40, anchoBloque, altoBloque);
				}
				
				if (laberinto[fila][columna] == 0) {
					grafico.setColor(Color.white);
					grafico.fillRect(columna * 40, fila * 40, anchoBloque, altoBloque);

				}
			}
		}
		grafico.drawString("inicio", 5, 62);
		grafico.drawString("final", 850, 462);
	}

	public int[][] obtieneLaberinto() {
		if(Juego.obtieneNivel() == 1) {
			int laberinto[][]=
				{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{ 1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1},
				{ 1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1},
				{ 1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
				{ 1,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,1,0,1,0,1,1},
				{ 1,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,0,1,0,1,1},
				{ 1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1},
				{ 1,1,0,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,0,1,0,1,1},
				{ 1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1},
				{ 1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,1},
				{ 1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1},
				{ 1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
				{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			
			lab = laberinto;
		}
		if (Juego.obtieneNivel() == 2) {
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
			
			lab = laberinto;
		}
		if (Juego.obtieneNivel() == 3) {
			int laberinto [][]=
				{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{ 1,0,0,0,1,0,0,0,0,0,0,1,1,1,0,0,1,1,3,0,0,1,1},
				{ 1,1,1,0,1,0,1,0,1,1,1,0,0,0,1,0,0,0,1,1,0,1,1},
				{ 1,1,0,0,0,0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,1},
				{ 1,1,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,1,0,1,0,1,1},
				{ 1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,1,0,0,1,0,1,1},
				{ 1,1,1,0,1,0,1,1,1,1,0,0,0,0,1,0,0,1,0,1,0,1,1},
				{ 1,1,0,0,0,1,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,1,1},
				{ 1,1,0,1,1,0,0,1,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1},
				{ 1,1,0,1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1},
				{ 1,1,0,0,0,1,1,1,0,1,0,0,0,0,0,1,0,0,0,1,0,1,1},
				{ 1,1,0,1,0,0,0,1,0,0,0,1,1,1,1,0,0,1,0,1,0,0,1},
				{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			
			lab = laberinto;
		}
		
		 return lab;

	}

}
