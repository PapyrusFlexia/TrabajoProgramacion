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

	final JFrame dado = new JFrame();
	static int tirada = Dado.tirarDado(3) + 1;
	int vidaActual;
	int idJugador;
	int cogerId;
	String nombreJugador;
	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;

	String consulta = "SELECT * FROM jugadores WHERE id= 1";
	String consultaEstadisticas = "SELECT * FROM inventario WHERE categoria = \"enfundado\" AND tipo = \"arma\"";

	// System.out.println("turno " + turnoActual);

	// String[] meterRS = new String[3];
	int poderEquipamiento;

	

	int dmgJefe = tirarJefe();
	
	int dmgTotalJefe;

	ArrayList<JefeGetSet> meterRS = new ArrayList<JefeGetSet>();
	int sizeRSjefe = meterRS.size();

	ArrayList<equipamientoGetSet> meterRSEquipamiento = new ArrayList<equipamientoGetSet>();
	// JefeGetSet objetoJefe = new JefeGetSet(0, 0);
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

		// this.combate = combate;

		// Dado Tirada = new Dado();//
		// Tirada.tirarDado(6);//

		ResultSet rs = Conexion.EjecutarSentencia(consulta);
		try {

			while (rs.next()) {

				vidaActual = rs.getInt("vida");

				nombreJugador = rs.getString("nombre");

				if (rs.getInt("id") == 1) {
					idJugador = rs.getInt("id");

				}
				JefeGetSet k = new JefeGetSet(vidaActual, idJugador, nombreJugador);

				meterRS.add(k);
				// rsUno.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsEstadisticas = Conexion.EjecutarSentencia(consultaEstadisticas);
		try {

			while (rsEstadisticas.next()) {

				poderEquipamiento = rsEstadisticas.getInt("poder");

				equipamientoGetSet kEstadisticas = new equipamientoGetSet(poderEquipamiento);

				meterRSEquipamiento.add(kEstadisticas);
				// rsUno.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		// rsUno.close();
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

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public void ataqueJefe() {
		/*
		 * vidaActualUno = (Integer) meterRS.get(0).getVida(); vidaActual = vidaActual -
		 * dmgJefe; if (vidaActual < 1) {
		 * JOptionPane.showMessageDialog(dado.getComponent(0), "Has muerto"); new
		 * Muerte(); Muerte muerteVisible = new Muerte(); // QUITAR CUANDO SE TERMINE EL
		 * PROGRAMA muerteVisible.setVisible(true);
		 * 
		 * setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); close(); }
		 */
		System.out.println(dmgTotalJefe);
		System.out.println(dmgJefe);
		System.out.println(vidaActual);

		dmgTotalJefe = dmgJefe - poderEquipamiento;
		vidaActual = vidaActual - dmgTotalJefe;

		System.out.println(dmgTotalJefe);
		System.out.println(dmgJefe);
		System.out.println(vidaActual);
		AddBaseDeDatos(vidaActual, idJugador);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"El JEFE te ha causado " + dmgJefe + " puntos de daño , mitigas: " + poderEquipamiento
						+ " de daño  , el JEFE te ha quitado: " + dmgTotalJefe + " de vida");

		if (vidaActual < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "Has muerto");
			new Muerte();
			Muerte muerteVisible = new Muerte(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
			muerteVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();
		}

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

	public void AddBaseDeDatos(int vidaJugador, int idJefe) {
		Conexion.conectar();
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = \""+ vidaJugador +
		// "\"");
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = " + vidaJugador + "
		// WHERE nombre = " + "\"manolo\"");
		Conexion.EjecutarUpdate("UPDATE jugadores SET vida =" + vidaJugador + " WHERE id =" + idJefe + "");

	}
}