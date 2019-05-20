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

public class turnoJefe extends JFrame {

	final JFrame dado = new JFrame();
	static int tirada = Dado.tirarDado(3) + 1;
	int vidaActual;
	int idJugador;
	int cogerId;
	String nombreJugador;
	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;

	String consulta = "SELECT * FROM jugadores WHERE id= 1";
	String consultaEstadisticas = "SELECT * FROM inventario WHERE estado = \"equipado\" AND tipo = \"armadura\"";

	int poderEquipamiento;

	

	int dmgTotalJefe;

	ArrayList<JefeGetSet> meterRS = new ArrayList<JefeGetSet>();
	int sizeRSjefe = meterRS.size();

	ArrayList<equipamientoGetSet> meterRSEquipamiento = new ArrayList<equipamientoGetSet>();

	/** turno en el que el jefe te quita vida, dependiendo de la armadura equipada te quitara mas o menos **/
	
	public turnoJefe() {

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

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public void ataqueJefe() {

		int dmgJefe = tirarJefe();

		dmgTotalJefe = dmgJefe - poderEquipamiento;
		vidaActual = vidaActual - dmgTotalJefe;

		
		AddBaseDeDatos(vidaActual, idJugador);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"El JEFE te ha causado " + dmgJefe + " puntos de daño , mitigas: " + poderEquipamiento
						+ " de daño  , el JEFE te ha quitado: " + dmgTotalJefe + " de vida");

		if (vidaActual < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "Has muerto");
			new Muerte();
			Muerte muerteVisible = new Muerte();
			muerteVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();
			
			dispose();
		}

	}

	public int tirarJefe() {
		return tirada = Dado.tirarDado(4) + 1;
	}
	
	/** escribe las acciones del jefe en el log **/

	public void logJefe() {

		int dmgJefe = tirada;
		String dmgStringJefe = String.valueOf(dmgJefe);

		try {

			fh = new FileHandler("src\\Log.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			logger.info("Daño causado por el JEFE: " + dmgStringJefe + " \r\n");
			logger.info("El JUGADOR tiene: " + vidaActual + " de vida" + " \r\n");

			if (vidaActual < 1) {
				logger.info("HAS MUERTO ");
				
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * PARA ACTUALIZAR LOS JUGADORES
	 * @param vidaJugador
	 * @param idJefe
	 */
	public void AddBaseDeDatos(int vidaJugador, int idJefe) {
		Conexion.conectar();

		Conexion.EjecutarUpdate("UPDATE jugadores SET vida =" + vidaJugador + " WHERE id =" + idJefe + "");

	}
}