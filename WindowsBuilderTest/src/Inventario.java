import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;



public class Inventario extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario windowI = new Inventario();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public Inventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("103127.png"));
		lblNewLabel.setBounds(73, 0, 335, 114);
		getContentPane().add(lblNewLabel);
		
		JLabel lblInventario = new JLabel("INVENTARIO");
		lblInventario.setBounds(113, 40, 78, 14);
		getContentPane().add(lblInventario);
		
		JLabel lblArmas = new JLabel("ARMAS");
		lblArmas.setBounds(73, 165, 46, 14);
		getContentPane().add(lblArmas);
		
		JLabel lblNewLabel_1 = new JLabel("New label1");
		lblNewLabel_1.setBounds(73, 190, 78, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label2");
		label.setBounds(73, 215, 78, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("New label3");
		label_1.setBounds(73, 240, 78, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("New label4");
		label_2.setBounds(73, 265, 78, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("New label5");
		label_3.setBounds(73, 290, 78, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("New label6");
		label_4.setBounds(145, 190, 78, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("New label7");
		label_5.setBounds(145, 215, 78, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("New label8");
		label_6.setBounds(145, 240, 78, 14);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("New label9");
		label_7.setBounds(145, 265, 78, 14);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("New label10");
		label_8.setBounds(145, 290, 78, 14);
		getContentPane().add(label_8);
		
		JLabel lblArmaduras = new JLabel("ARMADURAS");
		lblArmaduras.setBounds(145, 165, 69, 14);
		getContentPane().add(lblArmaduras);
		
		JLabel lblPocion = new JLabel("POCIONES");
		lblPocion.setBounds(235, 165, 76, 14);
		getContentPane().add(lblPocion);
		
		JLabel label_9 = new JLabel("New label11");
		label_9.setBounds(233, 190, 78, 14);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("New label12");
		label_10.setBounds(233, 215, 78, 14);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("New label13");
		label_11.setBounds(233, 240, 78, 14);
		getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("New label14");
		label_12.setBounds(233, 265, 78, 14);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("New label15");
		label_13.setBounds(233, 290, 78, 14);
		getContentPane().add(label_13);
		
		JLabel lblOro = new JLabel("ORO:");
		lblOro.setBounds(386, 165, 46, 14);
		getContentPane().add(lblOro);
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 11, 89, 23);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tienda();
				Tienda tiendaVisible = new Tienda();  
				tiendaVisible.setVisible(true);
				
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});
		
		
		
				
		
		
	}
	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}