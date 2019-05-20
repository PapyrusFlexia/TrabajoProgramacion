import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class JefeMedio extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textFieldid;
	private JTextField vidatotalfield;
	int VidaMedio = Dado.tirarDado(11) + 1;
	String atkInicial = "1d12";

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JefeMedio windowjM = new JefeMedio(); ////////////////////////////////////////////////////
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 * 
	 * @return
	 */
	public JefeMedio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(193, 179, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textFieldid = new JTextField();
		textFieldid.setBounds(193, 133, 86, 20);
		getContentPane().add(textFieldid);
		textFieldid.setColumns(10);

		JLabel lblid = new JLabel("id");
		lblid.setBounds(56, 136, 46, 14);
		getContentPane().add(lblid);

		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(56, 182, 46, 14);
		getContentPane().add(lblNombre);

		JLabel lblDmg = new JLabel("vida");
		lblDmg.setBounds(56, 232, 46, 14);
		getContentPane().add(lblDmg);

		JLabel lblValor = new JLabel("ataque");
		lblValor.setBounds(56, 284, 46, 14);
		getContentPane().add(lblValor);

		JLabel lblTipo = new JLabel("vida total");
		lblTipo.setBounds(56, 343, 46, 14);
		getContentPane().add(lblTipo);

		JLabel label = new JLabel("");
		label.setBounds(274, 192, 46, 14);
		getContentPane().add(label);

		JButton btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.setBounds(244, 491, 89, 23);
		getContentPane().add(btnFinalizar);

		JLabel vidaActual = new JLabel();
		vidaActual.setBounds(193, 232, 86, 14);
		getContentPane().add(vidaActual);

		JLabel label_2 = new JLabel("1d12");
		label_2.setBounds(193, 284, 46, 14);
		getContentPane().add(label_2);

		JLabel vidatotalfield = new JLabel();
		vidatotalfield.setBounds(193, 343, 183, 20);
		getContentPane().add(vidatotalfield);

		// vidatotalfield = new JTextField();
		// vidatotalfield.setBounds(193, 343, 183, 20);
		// getContentPane().add(vidatotalfield);
		// vidatotalfield.setColumns(10);

		final JFrame dado = new JFrame();
		JLabel lblBienvenido = new JLabel("BIENVENIDO A LA CREACION DE JEFES");
		lblBienvenido.setBounds(169, 42, 238, 14);
		getContentPane().add(lblBienvenido);

		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBaseDeDatos(textFieldid.getText(), textField.getText(), VidaMedio, atkInicial, VidaMedio); // RELLENAR

			}

		});
		btnCrear.setBounds(244, 399, 89, 23);
		getContentPane().add(btnCrear);

	
		JButton btndDdoce = new JButton("1d12 para crear la vida de un JEFE medio");
		// int VidaActual = VidaTotal;
		btndDdoce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Dado Tirada = new Dado();//
				// Tirada.tirarDado(6);//
				// int VidaTotal = Dado.tirarDado(8);

				JOptionPane.showMessageDialog(dado.getComponent(0), "Has sacado un " + VidaMedio); ///////// VIDATOTAL
				vidatotalfield.setText("El JEFE tiene " + VidaMedio + " de vida total");
				vidaActual.setText("El JEFE tiene " + VidaMedio + " de vida actual");

			}
		});

		btndDdoce.setBounds(56, 80, 238, 23);
		getContentPane().add(btndDdoce);
		
		

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 80, 89, 23);
		getContentPane().add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Interfaz();
				Interfaz interfazVisible = new Interfaz(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				interfazVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});

	}
	// public int getVidaActual () {
	// return VidaActual;
	// }
	// public void setVidaActual (int VidaActual){
	// this.VidaActual = VidaActual;
	// }

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public static void AddBaseDeDatos(String id, String nombre, int vida, String ataque, int vida_total) {
		Conexion.conectar();
		Conexion.EjecutarUpdate("INSERT INTO jefes VALUES (\"" + id + "\",\""+ nombre + "\",\"" + vida + "\",\"" + ataque
				+ "\",\"" + vida_total + "\")");

	}
}