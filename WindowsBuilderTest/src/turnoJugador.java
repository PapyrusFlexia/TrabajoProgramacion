import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class turnoJugador extends JFrame {

	private JFrame frame;
	final JFrame dado = new JFrame();
	static int tirada = Dado.tirarDado(3) + 1;

	int vidaActualUno;
	int vidaActualDos;
	int vidaActualTres;

	int idActual;
	int idJefeUno, idJefeDos;

	int cogerId;
	int dmgJugador = tirarJugador();

	String consulta = "SELECT * FROM jefes WHERE id= 1";

	// System.out.println("turno " + turnoActual);

	ResultSet rs = Conexion.EjecutarSentencia(consulta);

	// String[] meterRS = new String[3];
	ArrayList<turnoJugadorGetSet> meterRS = new ArrayList<turnoJugadorGetSet>();
	int sizeRSjefe = meterRS.size();
	turnoJugadorGetSet objetoJefe = new turnoJugadorGetSet(0, 0);

	// JefeGetSet k = new JefeGetSet(vidaActual, id_jugador);

	/**
	 * Launch the application.
	 */
	/*
	 * public static void NewScreen() { EventQueue.invokeLater(new Runnable() {
	 * public void run() { try { Jefe windowJ = new Jefe(); //
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * }
	 * 
	 * }); }
	 */

	/**
	 * Create the frame.
	 */

	public turnoJugador() {

		// final JFrame dado = new JFrame();

		// this.combate = combate;

		// Dado Tirada = new Dado();//
		// Tirada.tirarDado(6);//
		JOptionPane.showMessageDialog(dado.getComponent(0),

				"Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de vida");

		try {

			// ResultSet rs = Conexion.EjecutarSentencia("SELECT vida FROM jugadores WHERE
			// nombre = \"manolo\"");
			// ResultSet rs = Conexion.EjecutarSentencia("SELECT * FROM jugadores ORDER BY
			// RAND() LIMIT 1");
			// id_jugador= rs.getInt("id");

			// System.out.println(Conexion.EjecutarSentencia(query));
			while (rs.next()) {

				// meterRS.add(rs.getString(1));

				vidaActualUno = rs.getInt("vida");
				vidaActualDos = rs.getInt("vida");
				// idJefeUno = rs.getInt("id");
				if (rs.getInt("id") == 1) {
					idJefeUno = rs.getInt("id");
				} else if (rs.getInt("id") == 2) {
					idJefeDos = rs.getInt("id");
				}

				// cogerId = rs.getInt("id");

				turnoJugadorGetSet k = new turnoJugadorGetSet(vidaActualUno, idJefeUno);

				meterRS.add(k);

				turnoJugadorGetSet kDos = new turnoJugadorGetSet(vidaActualDos, idJefeDos);

				meterRS.add(kDos);
			}

			System.out.println(meterRS);
			System.out.println(((turnoJugadorGetSet) meterRS.get(0)).getVida());

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void turno() {
		if (vidaActualUno > 1) {
			if (idJefeUno == 1) {

				System.out.println("id " + idJefeUno);
				System.out.println("dmg" + dmgJugador);
				// vidaActualUno = (Integer) meterRS.get(0).getVida();

				vidaActualUno = vidaActualUno - dmgJugador;
				AddBaseDeDatos(vidaActualUno, idJefeUno);
				if (vidaActualUno < 1) {
					JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
					new Tienda();
					Tienda tiendaVisible = new Tienda(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
					tiendaVisible.setVisible(true);

					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					close();

				}
			} else {
				System.out.println("Has fallado");
			}
		} else {
			do {
				if (idJefeDos == 2) {
					System.out.println("id " + idJefeDos);
					System.out.println("dmg" + dmgJugador);
					// vidaActualDos = (Integer) meterRS.get(0).getVida();

					vidaActualDos = vidaActualDos - dmgJugador;
					AddBaseDeDatos(vidaActualDos, idJefeDos);
					if (vidaActualDos < 1) {
						JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
						new Tienda();
						Tienda tiendaVisible = new Tienda(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
						tiendaVisible.setVisible(true);

						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						close();
					}

				}

			} while (vidaActualUno < 1);
		}
	}

	public int tirarJugador() {
		return tirada = Dado.tirarDado(3) + 1;
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

	public void AddBaseDeDatos(int vidaJugador, int idJefe) {
		Conexion.conectar();
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = \""+ vidaJugador +
		// "\"");
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = " + vidaJugador + "
		// WHERE nombre = " + "\"manolo\"");

		Conexion.EjecutarUpdate("UPDATE jefes SET vida =" + vidaJugador + " WHERE id =" + idJefe + "");

	}
}