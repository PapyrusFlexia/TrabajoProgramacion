import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Jefe extends JFrame {

	private JFrame frame;
	static int tirada = Dado.tirarDado(4);
	int vidaActual;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jefe windowJ = new Jefe();
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

	public Jefe() {
		getContentPane().setLayout(null); ////////// LO QUE PASA ES QUE EL JEFE LLAMA A LA FUNCION QUE HACE UNA TIRADA
											////////// TOTALMENTE
		setBounds(100, 100, 596, 795); //////// DISTINTA A LA QUE SE HACE EN LA CLASE CREACION DE PERSONAJES
		final JFrame dado = new JFrame(); /////// PROBAR A HACERLO CON BASES DE DATOS
		Conexion.conectar();

		JButton btnNewButton = new JButton("PASAR TURNO");
		// int tirada = Dado.tirarDado(4);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Dado Tirada = new Dado();//
				// Tirada.tirarDado(6);//
				JOptionPane.showMessageDialog(dado.getComponent(0), "El jefe ha sacado " + tirada);

				String query = "SELECT * FROM jugadores WHERE nombre = \"manolo\"";
				System.out.println(query);

				try {

					ResultSet rs = Conexion.EjecutarSentencia("SELECT vida FROM jugadores WHERE nombre = \"manolo\"");
					// System.out.println(Conexion.EjecutarSentencia(query));
					while (rs.next()) {

						System.out.println(rs.getInt(1));
						vidaActual = rs.getInt(1);
					}

				} catch (SQLException e) {

					e.printStackTrace();
				}
				System.out.println(vidaActual);
				System.out.println(tirada);
				vidaActual = vidaActual - tirada;
				AddBaseDeDatos(vidaActual);

				/*
				 * CreacionPersonajes bajarVida = new CreacionPersonajes();
				 * VidaEnfrentamientoJefe = bajarVida.getVidaActual();
				 * System.out.println(VidaEnfrentamientoJefe);
				 * 
				 * VidaEnfrentamientoJefe = VidaEnfrentamientoJefe - tirada;
				 * JOptionPane.showMessageDialog(dado.getComponent(0), "Ahora tienes " +
				 * VidaEnfrentamientoJefe - + " de vida");
				 */

			}

		});
		
		

		btnNewButton.setBounds(197, 133, 145, 23);
		getContentPane().add(btnNewButton);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 11, 89, 23);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Pantano();
				Pantano pantanoVisible = new Pantano(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				pantanoVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});

	}

	/**
	 * Initialize the contents of the frame.
	 * 
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

	public static void AddBaseDeDatos(int vidaJugador) {

		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = \""+ vidaJugador +
		// "\"");
		Conexion.EjecutarUpdate("UPDATE jugadores SET vida = " + vidaJugador);
		System.out.println("fin");

	}
}