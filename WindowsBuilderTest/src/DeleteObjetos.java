import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class DeleteObjetos extends JFrame {

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
					DeleteObjetos windowD = new DeleteObjetos();
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
	public DeleteObjetos() {
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

		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(56, 179, 46, 14);
		getContentPane().add(lblNombre);

		JButton btnAadir = new JButton("BORRAR");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBaseDeDatos(textField.getText());

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
<<<<<<< HEAD
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

	public static void AddBaseDeDatos(String nombre) {
		Conexion.conectar();

		Conexion.EjecutarUpdate("DELETE FROM items WHERE nombre = \"" + nombre + "\"");

=======
				Tienda tiendaVisible = new Tienda();  //QUITAR CUANDO SE TERMINE EL PROGRAMA
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

	public static void AddBaseDeDatos(String nombre) {
		Conexion.conectar();

		Conexion.EjecutarUpdate("DELETE FROM items WHERE nombre = \"" + nombre + "\"");
		
		
>>>>>>> branch 'master' of https://github.com/PapyrusFlexia/TrabajoProgramacion.git
	}
}