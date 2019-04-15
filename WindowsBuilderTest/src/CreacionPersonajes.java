import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class CreacionPersonajes extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreacionPersonajes window = new CreacionPersonajes(); ////////////////////////////////////////////////////
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public CreacionPersonajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(193, 179, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

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

		JLabel label_1 = new JLabel("Tienes  de vida actualmente");
		label_1.setBounds(193, 232, 46, 14);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Tienes  de ataque");
		label_2.setBounds(193, 284, 46, 14);
		getContentPane().add(label_2);

		textField_1 = new JTextField();
		textField_1.setBounds(193, 343, 183, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		final JFrame dado = new JFrame();
		JLabel lblBienvenido = new JLabel("BIENVENIDO A LA CREACION DE PERSONAJES");
		lblBienvenido.setBounds(180, 100, 238, 14);
		getContentPane().add(lblBienvenido);

		JButton btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBaseDeDatos(textField.getText());

			}

		});

		JButton btndParaTu = new JButton("1d8 para tu vida");
		btndParaTu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Dado Tirada = new Dado();//
				// Tirada.tirarDado(6);//
				int VidaTotal = Dado.tirarDado(8);
				JOptionPane.showMessageDialog(dado.getComponent(0), "Has sacado un " + VidaTotal);
				textField_1.setText("Tienes " + VidaTotal + " de vida");

			}
		});

		btndParaTu.setBounds(21, 140, 144, 23);
		getContentPane().add(btndParaTu);

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

	public static void AddBaseDeDatos(String nombre) {
		Conexion.conectar();

		Conexion.EjecutarUpdate("INSERT INTO jugadores VALUES (\"" + nombre + "\")");

	}
}