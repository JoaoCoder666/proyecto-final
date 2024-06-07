package laberinto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LaberintoR {
    private static final int NUM_FILAS = 13;
    private static final int NUM_COLUMNAS = 23;
    private static final int ANCHO_BLOQUE = 40;
    private static final int ALTO_BLOQUE = 40;
    
    private int[][][] mapas = new int[20][NUM_FILAS][NUM_COLUMNAS];
    
    public LaberintoR() {
        for (int i = 0; i < mapas.length; i++) {
            mapas[i] = generarLaberinto();
        }
    }

    public void paint(Graphics grafico) {
        int[][] laberinto = obtieneLaberinto();
        for (int fila = 0; fila < NUM_FILAS; fila++) {
            for (int columna = 0; columna < NUM_COLUMNAS; columna++) {
                if (laberinto[fila][columna] == 1) {
                    grafico.setColor(Color.darkGray);
                    grafico.fillRect(columna * ANCHO_BLOQUE, fila * ANCHO_BLOQUE, ANCHO_BLOQUE, ALTO_BLOQUE);
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna * ANCHO_BLOQUE, fila * ANCHO_BLOQUE, ANCHO_BLOQUE, ALTO_BLOQUE);
                } else if (laberinto[fila][columna] == 0) {
                    grafico.setColor(Color.white);
                    grafico.fillRect(columna * ANCHO_BLOQUE, fila * ANCHO_BLOQUE, ANCHO_BLOQUE, ALTO_BLOQUE);
                }
            }
        }
    }

    public int[][] obtieneLaberinto() {
        int nivel = JuegoR.obtieneNivel();
        if (nivel > 0 && nivel <= mapas.length) {
            return mapas[nivel - 1];
        }
        return mapas[0];
    }

    public int[][] generarLaberinto() {
        int[][] laberinto = new int[NUM_FILAS][NUM_COLUMNAS];
        for (int i = 0; i < NUM_FILAS; i++) {
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                laberinto[i][j] = 1;
            }
        }

        int currentRow = 1;
        int currentCol = 1;
        laberinto[currentRow][currentCol] = 0;
        Random rand = new Random();

        while (currentRow < NUM_FILAS - 2 || currentCol < NUM_COLUMNAS - 2) {
            int direction = rand.nextInt(2);
            if (direction == 0 && currentRow < NUM_FILAS - 2) {
                currentRow++;
            } else if (direction == 1 && currentCol < NUM_COLUMNAS - 2) {
                currentCol++;
            }
            laberinto[currentRow][currentCol] = 0;
        }

        laberinto[currentRow][currentCol] = 2;

        for (int i = 1; i < NUM_FILAS - 1; i++) {
            for (int j = 1; j < NUM_COLUMNAS - 1; j++) {
                if (laberinto[i][j] == 1) {
                    continue;
                }
                if (rand.nextInt(4) == 0 && laberinto[i][j] != 2) {
                    laberinto[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < NUM_FILAS; i++) {
            laberinto[i][0] = 1;
            laberinto[i][NUM_COLUMNAS - 1] = 1;
        }
        for (int j = 0; j < NUM_COLUMNAS; j++) {
            laberinto[0][j] = 1;
            laberinto[NUM_FILAS - 1][j] = 1;
        }

        return laberinto;
    }
}
