package laberinto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Contador extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private int contador = 0;
    private String nombreArchivo = "puntuaciones.txt";
    private Juego game;
    
    @SuppressWarnings("serial")
	public Contador() {
        setUndecorated(true);
        setBounds(10, 100, 378, 639);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lbl_Contador = new JLabel("Contador");
        lbl_Contador.setBounds(29, 542, 46, 14);
        contentPane.add(lbl_Contador);
        
        JLabel lblNewLabel = new JLabel("Tiempo:");
        lblNewLabel.setBounds(29, 517, 46, 14);
        contentPane.add(lblNewLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 62, 222, 399);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {1, "Tomate", 15},
                {2, "JuanD", 20},
                {3, "PapeaPe", 22},
                {4, "Nikolucas", 23},
                {5, "I miss her", 25},
                {6, "He miss me", 30},
                {7, null, null},
                {8, null, null},
                {9, null, null},
                {10, null, null},
                {11, null, null},
                {12, null, null},
                {13, null, null},
                {14, null, null},
                {15, null, null},
                {16, null, null},
                {17, null, null},
                {18, null, null},
                {19, null, null},
                {20, null, null},
                {21, null, null},
                {22, null, null},
                {23, null, null},
                {24, null, null},
                {25, null, null},
            },
            new String[] {
                "N", "Nombre", "Score"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
                Integer.class, String.class, Integer.class
            };
            @SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        
        table.getColumnModel().getColumn(0).setPreferredWidth(21);
        table.getColumnModel().getColumn(1).setPreferredWidth(143);
        table.getColumnModel().getColumn(2).setPreferredWidth(47);
        scrollPane.setViewportView(table);
        
        new Thread(() -> {
            while (true) {
                if(Juego.obtieneNivel() > 3 || Juego2.obtieneNivel() > 3) {
                    table.setValueAt(contador, 6, 2);
                    guardarPuntuacion("Desconocido", contador); // Cambiar "Desconocido" por el nombre del jugador
                    break;
                } else {
                    contador++;
                }
                
                lbl_Contador.setText(String.valueOf(getContador()));
                
                JButton btnNewButton = new JButton("Ingresar nombre");
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String name = JOptionPane.showInputDialog("Ingrese su nombre");
                        table.setValueAt(name, 6, 1);
                        guardarPuntuacion(name, contador);
                    }
                });
                btnNewButton.setBounds(174, 538, 142, 23);
                contentPane.add(btnNewButton);
                
                JButton btnNewButton_1 = new JButton("Volver");
                btnNewButton_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                btnNewButton_1.setBounds(193, 504, 89, 23);
                contentPane.add(btnNewButton_1);
                
                JButton btnNewButton_2 = new JButton("Reiniciar juego");
                btnNewButton_2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        game.reiniciarJuegoCompleto();
                        contador = 0;
                        lbl_Contador.setText(String.valueOf(contador));
                        for (int i = 0; i < table.getRowCount(); i++) {
                            table.setValueAt(null, i, 1);
                            table.setValueAt(null, i, 2);
                        }
                    }
                });
                btnNewButton_2.setBounds(29, 504, 142, 23);
                contentPane.add(btnNewButton_2);
                
                try {
                    Thread.sleep(1000); // 1 segundo de intervalo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    private void guardarPuntuacion(String nombre, int puntuacion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(nombre + " - " + puntuacion);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGame(Juego game) {
        this.game = game;
    }
}

