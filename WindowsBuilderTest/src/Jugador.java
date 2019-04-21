import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Jugador extends JFrame {

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
					Jugador windowJu = new Jugador();
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

	public Jugador() {
		getContentPane().setLayout(null);

		setBounds(100, 100, 596, 795);
		final JFrame dado = new JFrame();

		JButton btnNewButton = new JButton("PASAR TURNO");
		// int tirada = Dado.tirarDado(4);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Dado Tirada = new Dado();//
				// Tirada.tirarDado(6);//
				JOptionPane.showMessageDialog(dado.getComponent(0),
						"El jefe ha sacado " + tirada + " , pierdes " + tirada + " de vida");

				try {

					ResultSet rs = Conexion.EjecutarSentencia("SELECT vida FROM jugadores WHERE nombre = \"manolo\"");
					// System.out.println(Conexion.EjecutarSentencia(query));
					while (rs.next()) {

						vidaActual = rs.getInt(1);
					}

				} catch (SQLException e) {

					e.printStackTrace();
				}

				vidaActual = vidaActual - tirada;
				AddBaseDeDatos(vidaActual);

				if (vidaActual < 1) {
					JOptionPane.showMessageDialog(dado.getComponent(0), "Has muerto");
					new Muerte();
					Muerte muerteVisible = new Muerte(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
					muerteVisible.setVisible(true);

					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					close();
				}

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

	} ////////////////////

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

	}
}