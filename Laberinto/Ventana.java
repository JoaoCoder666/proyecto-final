package Laberinto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;

public class Ventana {

	Juego juego = new Juego ();
	Juego2 juego2 = new Juego2 ();
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 340);
		frame.setUndecorated(true);
		
		/*
		 * change background color
		 * 
		 */
		Color colorHex = Color.decode("#DAF7A6");
		Container contentPane = frame.getContentPane();
        contentPane.setBackground(colorHex);
		
		/*
		 * Create Full screen button 
		 * Creates the events handlers
		 */
		JLabel lblFullScreen = new JLabel("");
		lblFullScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullScreen.setEnabled(false);
		lblFullScreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				lblFullScreen.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				lblFullScreen.setEnabled(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(frame.getExtendedState() != Frame.MAXIMIZED_BOTH)
				{
					frame.setExtendedState(Frame.MAXIMIZED_BOTH);
					lblFullScreen.setIcon(new ImageIcon(Ventana.class.getResource("/resources/oui-icons-15-512 (1).png")));
				}
				else
				{
					frame.setExtendedState(Frame.NORMAL);
					lblFullScreen.setIcon(new ImageIcon(Ventana.class.getResource("/resources/imagen_2024-06-05_210048925.png")));
				}
			}
		});
		lblFullScreen.setIcon(new ImageIcon(Ventana.class.getResource("/resources/imagen_2024-06-05_210048925.png")));
		
		
		/*
		 * Create closing frame button 
		 * Creates the events handlers
		 */
		JLabel lblCloseScreen = new JLabel("");
		lblCloseScreen.setEnabled(false);
		lblCloseScreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				lblCloseScreen.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				lblCloseScreen.setEnabled(false);
			}
		});
		lblCloseScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseScreen.setIcon(new ImageIcon(Ventana.class.getResource("/resources/99862 (1).png")));
		
		JLabel lblTituloJuego = new JLabel("Magic Maze");
		lblTituloJuego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				lblTituloJuego.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				lblTituloJuego.setEnabled(false);
			}
		});
		lblTituloJuego.setForeground(Color.BLACK);
		lblTituloJuego.setFont(new Font("Bookman Old Style", Font.BOLD, 52));
		lblTituloJuego.setEnabled(false);
		
		JLabel lblInfoPrNivel = new JLabel("");
		lblInfoPrNivel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(null, "~ Tres niveles sin obstaculos");
			}
		});
		lblInfoPrNivel.setIcon(new ImageIcon(Ventana.class.getResource("/resources/81147 (1).png")));

		
		JLabel lblInfoSegNivel = new JLabel("");
		lblInfoSegNivel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(null, "~ Tres niveles cada uno con un enemigo");
			}
		});
		lblInfoSegNivel.setIcon(new ImageIcon(Ventana.class.getResource("/resources/81147 (1).png")));
		
		
		JLabel lblInfoTerNivel_1_1 = new JLabel("");
		lblInfoTerNivel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(null, "~ Mapas aleatorios sin enemigos, pero con un reto de tiempo");
			}
		});
		lblInfoTerNivel_1_1.setIcon(new ImageIcon(Ventana.class.getResource("/resources/81147 (1).png")));
		
		/*
		 * Create the button that guides to the easy mode
		 * Creates the events handlers
		 */
		JButton btnModoFacil = new JButton("Facil");
		btnModoFacil.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
		btnModoFacil.setForeground(Color.DARK_GRAY);
		btnModoFacil.setBackground(Color.LIGHT_GRAY);
		btnModoFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Thread(() -> {
                    try {
                        juego2.iniciarJuego();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }).start();
				
				btnModoFacil.setVisible(false);
				btnModoFacil.setEnabled(false);
				lblInfoPrNivel.setVisible(false);
				lblInfoPrNivel.setEnabled(false);
			}
		});
		btnModoFacil.setIcon(new ImageIcon(Ventana.class.getResource("/resources/yawning-face-emoji-2005x2048-npui9qri (1).png")));
		/*
		 * Create the button that guides to the hard mode
		 * Creates the events handlers
		 */
		JButton btnModoDificil = new JButton("Dificil");
		btnModoDificil.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
		btnModoDificil.setForeground(Color.DARK_GRAY);
		btnModoDificil.setBackground(Color.LIGHT_GRAY);
		btnModoDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(() -> {
                    try {
                        juego.iniciarJuego();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }).start();
				
				btnModoDificil.setVisible(false);
				btnModoDificil.setEnabled(false);
				lblInfoSegNivel.setVisible(false);
				lblInfoSegNivel.setEnabled(false);
				
			}
		});
		btnModoDificil.setIcon(new ImageIcon(Ventana.class.getResource("/resources/grimacing-face-emoji-2048x2048-zs0bknyt (1).png")));
		/*
		 * Create the button that guides to the time race mode
		 * Creates the events handlers
		 */
		JButton btnContraReloj = new JButton("Contra Reloj");
		btnContraReloj.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
		btnContraReloj.setForeground(Color.DARK_GRAY);
		btnContraReloj.setBackground(Color.LIGHT_GRAY);
		btnContraReloj.setIcon(new ImageIcon(Ventana.class.getResource("/resources/1f975 (1).png")));
		
		JLabel lblAyuda = new JLabel("");
		lblAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(null, "~ Para Moverse utilice las flechas "
						+ "\n~ Debe completar el nivel en el menor tiempo posble "
						+ "\n~ Los enemigos reiniciaran el mapa completo "
						+ "\n~ Si el timpo se acaba perderá ");
			}
		});
		lblAyuda.setIcon(new ImageIcon(Ventana.class.getResource("/resources/Question_Mark_Icon (1).png")));
		
		JLabel lblPodio = new JLabel("");
		lblPodio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				lblPodio.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				lblPodio.setEnabled(false);
			}
		});
		lblPodio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodio.setIcon(new ImageIcon(Ventana.class.getResource("/resources/607834 (1).png")));
		lblPodio.setEnabled(false);
		
		JLabel lblGatoBailando = new JLabel("");
		lblGatoBailando.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGatoBailando.setIcon(new ImageIcon(Ventana.class.getResource("/resources/cat-meme-funny.gif")));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblTituloJuego)
					.addPreferredGap(ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
					.addComponent(lblFullScreen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCloseScreen)
					.addGap(12))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnModoFacil, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnModoDificil, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnContraReloj, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblInfoPrNivel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblInfoSegNivel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblInfoTerNivel_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAyuda, Alignment.TRAILING)
						.addComponent(lblPodio, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(553, Short.MAX_VALUE)
					.addComponent(lblGatoBailando, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCloseScreen)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPodio, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblAyuda, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTituloJuego, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addGap(82)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblInfoPrNivel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnModoFacil, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addGap(13)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblInfoSegNivel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnModoDificil))
								.addGap(16)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnContraReloj)
									.addComponent(lblInfoTerNivel_1_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblFullScreen))
					.addGap(82)
					.addComponent(lblGatoBailando, GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
	
	/*
	 * method that closes all current games
	 */
	public void cerrarJuego() {
        juego.cerrarJuego();
        juego2.cerrarJuego();
    }
}
