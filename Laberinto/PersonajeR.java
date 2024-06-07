package laberinto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class PersonajeR {
    private LaberintoR lab;
    private int x = 40, y = 40, ancho = 40, alto = 40, movimiento = 40;

    public PersonajeR(LaberintoR lab) {
        this.lab = lab;
    }

    public void paint(Graphics grafico) {
        grafico.setColor(Color.red);
        grafico.fillOval(x, y, ancho, alto);
        grafico.setColor(Color.black);
        grafico.drawOval(x, y, ancho, alto);
    }

    public void teclaPresionada(KeyEvent evento) {
        int[][] laberinto = lab.obtieneLaberinto();
        if (evento.getKeyCode() == 37 && laberinto[y / 40][(x / 40) - 1] != 1) {
            x = x - movimiento;
        }
        if (evento.getKeyCode() == 39 && laberinto[y / 40][(x / 40) + 1] != 1) {
            x = x + movimiento;
        }
        if (evento.getKeyCode() == 40 && laberinto[(y / 40) + 1][(x / 40)] != 1) {
            y = y + movimiento;
        }
        if (evento.getKeyCode() == 38 && laberinto[(y / 40) - 1][(x / 40)] != 1) {
            y = y - movimiento;
        }
        if (x == 840 && y == 440) {
            JuegoR.cambiarNivel();
            x = 40;
            y = 40;
        }
    }
}
