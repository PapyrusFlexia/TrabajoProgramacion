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

	int idJefeUno, idJefeDos, idJefeTres;

	int cogerId;
	int dmgJugador = tirarJugador();

	String consultaJefeUno = "SELECT * FROM jefes WHERE id= 1";
	String consultaJefeDos = "SELECT * FROM jefes WHERE id= 2";
	String consultaJefeTres = "SELECT * FROM jefes WHERE id= 3";

	ResultSet rsUno = Conexion.EjecutarSentencia(consultaJefeUno);
	ResultSet rsDos = Conexion.EjecutarSentencia(consultaJefeDos);
	ResultSet rsTres = Conexion.EjecutarSentencia(consultaJefeTres);

	ArrayList<turnoJugadorGetSet> meterRS = new ArrayList<turnoJugadorGetSet>();
	int sizeRSjefe = meterRS.size();
	turnoJugadorGetSet objetoJefe = new turnoJugadorGetSet(0, 0);
	Conexion cerrarConexion = new Conexion();

	public turnoJugador() {

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de vida");

		try {

			while (rsUno.next()) {

				vidaActualUno = rsUno.getInt("vida");

				if (rsUno.getInt("id") == 1) {
					idJefeUno = rsUno.getInt("id");

				}
				turnoJugadorGetSet kUno = new turnoJugadorGetSet(vidaActualUno, idJefeUno);

				meterRS.add(kUno);
				// rsUno.close();
			}
			while (rsDos.next()) {

				vidaActualDos = rsDos.getInt("vida");

				if (rsDos.getInt("id") == 2) {
					idJefeDos = rsDos.getInt("id");

				}
				turnoJugadorGetSet kDos = new turnoJugadorGetSet(vidaActualDos, idJefeDos);

				meterRS.add(kDos);
				// rsDos.close();
			}
			while (rsTres.next()) {

				vidaActualTres = rsTres.getInt("vida");

				if (rsTres.getInt("id") == 3) {
					idJefeTres = rsTres.getInt("id");
				}
				turnoJugadorGetSet kTres = new turnoJugadorGetSet(vidaActualTres, idJefeTres);

				meterRS.add(kTres);
				// rsTres.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public void primerJefePantano() {

	}

	public void segundoJefePantano() {
		vidaActualDos = (Integer) meterRS.get(0).getVida();
		vidaActualDos = vidaActualDos - dmgJugador;
		AddBaseDeDatosUno(vidaActualDos, idJefeDos);

		if (vidaActualDos < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}
	}

	public int tirarJugador() {
		return tirada = Dado.tirarDado(3) + 1;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public void AddBaseDeDatosUno(int vidaJugador, int idJefe) {

		Conexion.conectar();

		Conexion.EjecutarUpdate("UPDATE jefes SET vida =" + vidaJugador + " WHERE id =" + idJefe + "");

	}

}
