package Laberinto;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int num;
   Juego juego = new Juego (num);
    
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Menu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Facil");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new Thread(() -> {
                    try {
                        juego.inicializarJuego(1);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }).start();
            	dispose();
            
            	
            }
        });
        btnNewButton.setBounds(169, 77, 85, 21);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Dificil");
        btnNewButton_1.setBounds(169, 172, 85, 21);
        contentPane.add(btnNewButton_1);
        
        JButton btnMedio = new JButton("Medio");
        btnMedio.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnMedio.setBounds(169, 127, 85, 21);
        contentPane.add(btnMedio);
    }
}