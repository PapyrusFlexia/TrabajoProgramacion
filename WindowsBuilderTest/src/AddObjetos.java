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

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bosque window = new Bosque();
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

		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(56, 179, 46, 14);
		getContentPane().add(lblNombre);

		JLabel lblDmg = new JLabel("dmg");
		lblDmg.setBounds(56, 232, 46, 14);
		getContentPane().add(lblDmg);

		JLabel lblValor = new JLabel("valor");
		lblValor.setBounds(56, 284, 46, 14);
		getContentPane().add(lblValor);

		JLabel lblTipo = new JLabel("tipo");
		lblTipo.setBounds(56, 343, 46, 14);
		getContentPane().add(lblTipo);

		JButton btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBaseDeDatos(textField.getText(), textField_1.getText(), textField_2.getText(),
						textField_3.getText());

			}

		});
		btnAadir.setBounds(356, 253, 89, 23);
		getContentPane().add(btnAadir);

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

	public static void AddBaseDeDatos(String nombre, String dmg, String valor, String tipo) {
		Conexion.conectar();

		Conexion.EjecutarUpdate(
				"INSERT INTO armas VALUES (\"" + nombre + "\", " + dmg + ", " + valor + ", \"" + tipo + "\");");
	}
}