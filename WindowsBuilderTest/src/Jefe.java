import java.sql.*;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;
import java.io.IOException;

public class Jefe extends JFrame {

	static int tirada = Dado.tirarDado(3) + 1;
	int vidaActual;
	int idActual;
	int id_jugador;
	int cogerId;
	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;

	String consulta = "SELECT * FROM jugadores ORDER BY RAND() LIMIT 1";

	// System.out.println("turno " + turnoActual);

	ResultSet rs = Conexion.EjecutarSentencia(consulta);

	// String[] meterRS = new String[3];
	ArrayList<JefeGetSet> meterRS = new ArrayList<JefeGetSet>();
	int sizeRSjefe = meterRS.size();
	JefeGetSet objetoJefe = new JefeGetSet(0, 0);
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

	public Jefe() {

		final JFrame dado = new JFrame();

		int dmgJefe = tirarJefe();
		// this.combate = combate;

		// Dado Tirada = new Dado();//
		// Tirada.tirarDado(6);//
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"El jefe ha sacado " + dmgJefe + " , pierdes " + dmgJefe + " de vida");

		try {

			// ResultSet rs = Conexion.EjecutarSentencia("SELECT vida FROM jugadores WHERE
			// nombre = \"manolo\"");
			// ResultSet rs = Conexion.EjecutarSentencia("SELECT * FROM jugadores ORDER BY
			// RAND() LIMIT 1");
			// id_jugador= rs.getInt("id");

			// System.out.println(Conexion.EjecutarSentencia(query));
			while (rs.next()) {

				// meterRS.add(rs.getString(1));
				vidaActual = rs.getInt("vida");
				id_jugador = rs.getInt("id");
				// cogerId = rs.getInt("id");

				JefeGetSet k = new JefeGetSet(vidaActual, id_jugador);

				meterRS.add(k);

			}
			System.out.println(meterRS);
			System.out.println(((JefeGetSet) meterRS.get(0)).getVida());
			// System.out.println("id " +((JefeGetSet) meterRS.get(0)).getId());
			// objetoJefe.setVida() =

			// idActual = (Integer) meterRS.get(1).getId();
			if (id_jugador == 1) {

				System.out.println("id " + id_jugador);
				vidaActual = (Integer) meterRS.get(0).getVida();

				vidaActual = vidaActual - dmgJefe;
				if (vidaActual < 1) {
					JOptionPane.showMessageDialog(dado.getComponent(0), "Has muerto");
					new Muerte();
					Muerte muerteVisible = new Muerte(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
					muerteVisible.setVisible(true);

					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					close();
				}
			} else {
				System.out.println("El JEFE ha fallado");
			}

			System.out.println(vidaActual);

			/*
			 * System.out.println(k.getVida());
			 * System.out.println("1 la vida original es igual a " + vidaActual); vidaActual
			 * = k.getVida(); System.out.println("2 la vida actual es igual a " +
			 * vidaActual); vidaActual = vidaActual - dmgJefe;
			 * System.out.println("3 la vida actual es igual a " + vidaActual+
			 * " el daño del jefe es" + dmgJefe);
			 * 
			 * System.out.println("la vida actual " + vidaActual);
			 */

			// objetoJefe.setVida(); = meterRS.get(0);
			// System.out.println(JefeGetSet.getVida());

			// for(int x=0;x<sizeRSjefe;x++) {
			// vidaActual = vidaActual - dmgJefe;
			// int vidaTemporal = meterRS.get(0);
			// meterRS.get(1) = meterRS.get(1) - dmgJefe;
			// System.out.println(meterRS.toString());
			AddBaseDeDatos(vidaActual);
			// }

		} catch (SQLException e) {

			e.printStackTrace();

		}

		// for(int x=0;x<sizeRSjefe;x++) {
		// vidaActual = vidaActual - dmgJefe;
		// System.out.println(meterRS.get(x));
		// meterRS.get(x) = meterRS.get(x) - dmgJefe;
		// AddBaseDeDatos(vidaActual);
		// }

		/*
		 * if (vidaActual < 1) { JOptionPane.showMessageDialog(dado.getComponent(0),
		 * "Has muerto"); new Muerte(); Muerte muerteVisible = new Muerte(); // QUITAR
		 * CUANDO SE TERMINE EL PROGRAMA muerteVisible.setVisible(true);
		 * 
		 * setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); close(); }
		 */

	}

	public int tirarJefe() {
		return tirada = Dado.tirarDado(3) + 1;
	}

	public void logJefe() {
		// Jefe tiradaJefe = new Jefe();
		// int dmgJefe = tiradaJefe.tirarJefe();
		// String dmgStringJefe = String.valueOf(dmgJefe);
		int dmgJefe = tirada;
		String dmgStringJefe = String.valueOf(dmgJefe);

		try {

			// This block configure the logger with handler and formatter
			fh = new FileHandler("C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\src\\Log.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// the following statement is used to log any messages
			logger.info("Daño causado por el JEFE: " + dmgStringJefe);
			logger.info("El JUGADOR tiene: " + vidaActual + " de vida");

			if (vidaActual < 1) {
				logger.info("HAS MUERTO ");
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public void AddBaseDeDatos(int vidaJugador) {
		Conexion.conectar();
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = \""+ vidaJugador +
		// "\"");
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = " + vidaJugador + "
		// WHERE nombre = " + "\"manolo\"");
		Conexion.EjecutarUpdate("UPDATE jugadores SET vida =" + vidaJugador + " WHERE id =" + id_jugador + "");

	}
}