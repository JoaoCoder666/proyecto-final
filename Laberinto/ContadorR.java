package laberinto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ContadorR extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private int contador = 100;

    @SuppressWarnings("serial")
	public ContadorR() {
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
                new Object[][]{
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
                new String[]{
                        "N", "Nombre", "Score"
                }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[]{
                    Integer.class, String.class, Integer.class
            };

            @SuppressWarnings({ "rawtypes", "unchecked" })
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
                if (Juego.obtieneNivel() > 20 || Juego2.obtieneNivel() > 20 || contador == 0) {
                    table.setValueAt(Juego.obtieneNivel(), 6, 2);
                    break;
                } else {
                    contador--;
                }
                lbl_Contador.setText(String.valueOf(getContador()));
                try {
                    Thread.sleep(1000); // 1 segundo de intervalo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        JButton btnNewButton = new JButton("Ingresar nombre");
        btnNewButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Ingrese su nombre");
            table.setValueAt(name, 6, 1);
        });
        btnNewButton.setBounds(174, 538, 142, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Volver");
        btnNewButton_1.addActionListener(e -> {
            dispose();
        });
        btnNewButton_1.setBounds(193, 504, 89, 23);
        contentPane.add(btnNewButton_1);
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
