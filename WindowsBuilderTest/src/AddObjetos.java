import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class AddObjetos extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					AddObjetos windowA = new AddObjetos(); // BOSQUE
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
	public AddObjetos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);

		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setBounds(180, 100, 79, 14);
		getContentPane().add(lblBienvenido);

		textField = new JTextField();
		textField.setBounds(173, 176, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(173, 229, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(173, 281, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(173, 337, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(173, 381, 86, 20);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(173, 422, 86, 20);
		getContentPane().add(textField_5);

		JLabel lblNombre = new JLabel("id");
		lblNombre.setBounds(56, 179, 46, 14);
		getContentPane().add(lblNombre);

		JLabel lblDmg = new JLabel("nombre");
		lblDmg.setBounds(56, 232, 46, 14);
		getContentPane().add(lblDmg);

		JLabel lblValor = new JLabel("poder");
		lblValor.setBounds(56, 284, 46, 14);
		getContentPane().add(lblValor);

		JLabel lblTipo = new JLabel("valor");
		lblTipo.setBounds(56, 343, 46, 14);
		getContentPane().add(lblTipo);

		JLabel labelCategoria = new JLabel("categoria");
		labelCategoria.setBounds(56, 384, 46, 14);
		getContentPane().add(labelCategoria);

		JLabel labelTipo = new JLabel("tipo");
		labelTipo.setBounds(56, 425, 46, 14);
		getContentPane().add(labelTipo);

		JButton btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBaseDeDatos(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(),
						textField_4.getText(), textField_5.getText());

			}

		});
		btnAadir.setBounds(356, 253, 89, 23);
		getContentPane().add(btnAadir);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 11, 89, 23);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tienda();
				Tienda tiendaVisible = new Tienda(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
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
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public static void AddBaseDeDatos(String id, String nombre, String poder, String valor, String categoria,
			String tipo) {
		Conexion.conectar();
		Conexion.EjecutarUpdate("INSERT INTO items VALUES (\"" + id + "\",\"" + nombre + "\",\"" + poder + "\",\""
				+ valor + "\",\"" + categoria + "\",\"" + tipo + "\")");

	}
}

/**
 * Create the frame.
 */
