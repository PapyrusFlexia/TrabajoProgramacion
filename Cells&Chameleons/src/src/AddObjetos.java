package src;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import src.BBDD.Conexion;

import java.awt.event.*;

public class AddObjetos extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					AddObjetos windowA = new AddObjetos();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
 /** Se añaden los botones y los JLabel, y en btnAadir, se añaden a la base de datos **/
	public AddObjetos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 143, 596, 795);
		getContentPane().setLayout(null);

		Toolkit marco = Toolkit.getDefaultToolkit();

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);

		setTitle("Cells&Chameleons");

		JLabel lblBienvenido = new JLabel("AÑADIR OBJETOS");
		lblBienvenido.setBounds(232, 82, 149, 14);
		getContentPane().add(lblBienvenido);

		textField = new JTextField();
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});

		textField.setBounds(173, 176, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!((c >= 'a') && (c <= 'z') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		textField_1.setBounds(173, 229, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		textField_2.setBounds(173, 281, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		textField_3.setBounds(173, 337, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!((c >= 'a') && (c <= 'z') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(173, 381, 86, 20);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!((c >= 'a') && (c <= 'z') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
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
		labelCategoria.setBounds(56, 384, 77, 14);
		getContentPane().add(labelCategoria);

		JLabel labelTipo = new JLabel("tipo");
		labelTipo.setBounds(56, 425, 46, 14);
		getContentPane().add(labelTipo);

		JButton btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBaseDeDatos(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), //ME AÑADE LOS DATOS A LA BASE DE DATOS
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
				Tienda tiendaVisible = new Tienda(); 
				tiendaVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});

	}
	
	/**  para cerrar la pestaña **/

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
 
	/**
	 * añade a la base de datos los items que se creen
	 * @param id
	 * @param nombre
	 * @param poder
	 * @param valor
	 * @param categoria
	 * @param tipo
	 */
	public static void AddBaseDeDatos(String id, String nombre, String poder, String valor, String categoria,
			String tipo) {
		Conexion.conectar();
		Conexion.EjecutarUpdate("INSERT INTO items VALUES (\"" + id + "\",\"" + nombre + "\",\"" + poder + "\",\""
				+ valor + "\",\"" + categoria + "\",\"" + tipo + "\")");

	}
}
