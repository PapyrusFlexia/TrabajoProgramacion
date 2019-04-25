import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Pantano extends JFrame {

	private JFrame frame;
	int VidaTotal = Dado.tirarDado(4);
	String id = "001";
	String nombre = "Frikón Ululante";
	String atkInicial = "1d4";

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantano windowP = new Pantano();
					// windowP.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public Pantano() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // EXIT
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);

		final JFrame dado = new JFrame();
		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setBounds(180, 116, 79, 14);
		getContentPane().add(lblBienvenido);

		JLabel lblTiraElDado = new JLabel("TIRA EL DADO");
		lblTiraElDado.setBounds(180, 11, 79, 14);
		getContentPane().add(lblTiraElDado);

		JPanel topPanel = new JPanel();

		JButton btnNewButton = new JButton("PRUEBA");
		// final JLabel label = new JLabel("Hello World"); //

		// label.setVisible(false); //
		// frame.add(topPanel); //
		// topPanel.add(btnNewButton); //
		// topPanel.add(label); //
		// frame.setVisible(true); //

		int tirada = Dado.tirarDado(20) + 1;

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Dado Tirada = new Dado();//
				// Tirada.tirarDado(6);//
				JOptionPane.showMessageDialog(dado.getComponent(0), "Has sacado un " + tirada); // EL
																								// 20
																								// ES
																								// LO
																								// MAXIMO
																								// DEL
																								// DADO

				// label.setVisible(true); //

				if (tirada > 10) {
					Tienda nwTienda = new Tienda();
					nwTienda.NewScreen();

					// contentPane.setVisible(false);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					close();

					new Tienda();
					Tienda tiendaVisible = new Tienda();
					tiendaVisible.setVisible(true);
				} else {
					DeleteBaseDeDatos();
					AddBaseDeDatos(id, nombre, VidaTotal, atkInicial, VidaTotal);
					
					Combate nwCombate = new Combate();
					nwCombate.NewScreen();

					// contentPane.setVisible(false);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					close();

					new Combate();
					Combate combateVisible = new Combate();
					combateVisible.setVisible(true);

				}

			}
		});

		btnNewButton.setBounds(170, 48, 89, 23);
		getContentPane().add(btnNewButton);

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
	public static void AddBaseDeDatos(String id, String nombre, int vida, String ataque, int vida_total) {
		Conexion.conectar();
		Conexion.EjecutarUpdate("INSERT INTO jefespantano VALUES (\"" + id + "\",\"" + nombre + "\",\"" + vida + "\",\"" + ataque
				+ "\",\"" + vida_total + "\")");

	}
	public static void DeleteBaseDeDatos() {
		Conexion.conectar();
		Conexion.EjecutarUpdate("DELETE FROM jefespantano LIMIT 1");
	}
}