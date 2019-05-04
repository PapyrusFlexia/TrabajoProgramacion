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
	int vidaActualCuatro;
	int vidaActualCinco;
	int vidaActualSeis;

	int idActual;

	int idJefeUno, idJefeDos, idJefeTres, idJefeCuatro, idJefeCinco, idJefeSeis;

	int cogerId;
	int dmgJugador = tirarJugador();

	int cogerIdMontana;

	String consultaJefeUno = "SELECT * FROM jefespantano WHERE id= 1";
	String consultaJefeDos = "SELECT * FROM jefespantano WHERE id= 2";
	String consultaJefeTres = "SELECT * FROM jefespantano WHERE id= 3";
	String consultaJefeCuatro = "SELECT * FROM jefesmontana WHERE id= 4";
	String consultaJefeCinco = "SELECT * FROM jefesmontana WHERE id= 5";
	String consultaJefeSeis = "SELECT * FROM jefesmontana WHERE id= 6";

	// ResultSet rsUno = Conexion.EjecutarSentencia(consultaJefeUno);
	// ResultSet rsDos = Conexion.EjecutarSentencia(consultaJefeDos);
	// ResultSet rsTres = Conexion.EjecutarSentencia(consultaJefeTres);

	ArrayList<turnoJugadorGetSet> meterRS = new ArrayList<turnoJugadorGetSet>();
	int sizeRSjefe = meterRS.size();
	turnoJugadorGetSet objetoJefe = new turnoJugadorGetSet(0, 0);
	Conexion cerrarConexion = new Conexion();

	public turnoJugador() {

		//JOptionPane.showMessageDialog(dado.getComponent(0),
			//	"Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de vida");

		ResultSet rsUno = Conexion.EjecutarSentencia(consultaJefeUno);
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

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsDos = Conexion.EjecutarSentencia(consultaJefeDos);
		try {
			while (rsDos.next()) {

				vidaActualDos = rsDos.getInt("vida");

				if (rsDos.getInt("id") == 2) {
					idJefeDos = rsDos.getInt("id");

				}
				turnoJugadorGetSet kDos = new turnoJugadorGetSet(vidaActualDos, idJefeDos);

				meterRS.add(kDos);
				// rsDos.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsTres = Conexion.EjecutarSentencia(consultaJefeTres);
		try {
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
		ResultSet rsCuatro = Conexion.EjecutarSentencia(consultaJefeCuatro);
		try {
			while (rsCuatro.next()) {

				vidaActualCuatro = rsCuatro.getInt("vida");

				if (rsCuatro.getInt("id") == 4) {
					idJefeTres = rsCuatro.getInt("id");
				}
				turnoJugadorGetSet kCuatro = new turnoJugadorGetSet(vidaActualCuatro, idJefeCuatro);

				meterRS.add(kCuatro);
				// rsTres.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		ResultSet rsCinco = Conexion.EjecutarSentencia(consultaJefeCinco);
		try {
			while (rsCinco.next()) {

				vidaActualCinco = rsCinco.getInt("vida");

				if (rsCinco.getInt("id") == 5) {
					idJefeCinco = rsCinco.getInt("id");
				}
				turnoJugadorGetSet kCinco = new turnoJugadorGetSet(vidaActualCinco, idJefeCinco);

				meterRS.add(kCinco);
				// rsTres.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		ResultSet rsSeis = Conexion.EjecutarSentencia(consultaJefeSeis);
		try {
			while (rsSeis.next()) {

				vidaActualSeis = rsSeis.getInt("vida");

				if (rsSeis.getInt("id") == 6) {
					idJefeSeis = rsSeis.getInt("id");
				}
				turnoJugadorGetSet kSeis = new turnoJugadorGetSet(vidaActualSeis, idJefeSeis);

				meterRS.add(kSeis);
				// rsTres.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public int getVidaActualUno() {
		return vidaActualUno;
	}

	public void setVidaActualUno(int vidaActualUno) {
		this.vidaActualUno = vidaActualUno;
	}

	public int getVidaActualDos() {
		return vidaActualDos;
	}

	public void setVidaActualDos(int vidaActualDos) {
		this.vidaActualDos = vidaActualDos;
	}

	public int getVidaActualTres() {
		return vidaActualTres;
	}

	public void setVidaActualTres(int vidaActualTres) {
		this.vidaActualTres = vidaActualTres;
	}

	public int getVidaActualCuatro() {
		return vidaActualCuatro;
	}

	public void setVidaActualCuatro(int vidaActualCuatro) {
		this.vidaActualCuatro = vidaActualCuatro;
	}

	public int getVidaActualCinco() {
		return vidaActualCinco;
	}

	public void setVidaActualCinco(int vidaActualCinco) {
		this.vidaActualCinco = vidaActualCinco;
	}

	public int getVidaActualSeis() {
		return vidaActualSeis;
	}

	public void setVidaActualSeis(int vidaActualSeis) {
		this.vidaActualSeis = vidaActualSeis;
	}

	public void primerJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		vidaActualUno = vidaActualUno - dmgJugador;
		AddBaseDeDatosUno(vidaActualUno, idJefeUno);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de vida");


		if (vidaActualUno < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

			combatePantano cerrarPantano = new combatePantano();
			cerrarPantano.dispose();
		}

	}

	public void segundoJefePantano() {

		// vidaActualDos = (Integer) meterRS.get(0).getVida();

		vidaActualDos = vidaActualDos - dmgJugador;
		AddBaseDeDatosUno(vidaActualDos, idJefeDos);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de vida");


		if (vidaActualDos < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

			combatePantano cerrarPantano = new combatePantano();
			cerrarPantano.dispose();

		}
	}

	public void tercerJefePantano() {
		// vidaActualTres = (Integer) meterRS.get(0).getVida();
		vidaActualTres = vidaActualTres - dmgJugador;
		AddBaseDeDatosUno(vidaActualTres, idJefeTres);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de vida");


		if (vidaActualTres < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			// new Interfaz();
			// Interfaz interfazVisible = new Interfaz();
			// interfazVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

			// new Interfaz();
			// Interfaz Interfaz = new Interfaz();
			// Interfaz.setVisible(true);
			dispose();

		}
	}
	public void cuartoJefeMontana() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		vidaActualCuatro = vidaActualCuatro - dmgJugador;
		AddBaseDeDatosDos(vidaActualCuatro, idJefeCuatro);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de vida");


		if (vidaActualCuatro < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

			combateMontana cerrarMontana = new combateMontana();
			cerrarMontana.dispose();
		}

	}
	public void quintoJefeMontana() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		vidaActualCinco = vidaActualCinco - dmgJugador;
		AddBaseDeDatosDos(vidaActualCinco, idJefeCinco);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de vida");


		if (vidaActualCinco < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

			combateMontana cerrarMontana = new combateMontana();
			cerrarMontana.dispose();
		}

	}
	public void sextoJefeMontana() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		vidaActualSeis = vidaActualSeis - dmgJugador;
		AddBaseDeDatosDos(vidaActualSeis, idJefeSeis);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de vida");


		if (vidaActualSeis < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

			combateMontana cerrarMontana = new combateMontana();
			cerrarMontana.dispose();
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

		Conexion.EjecutarUpdate("UPDATE jefespantano SET vida =" + vidaJugador + " WHERE id =" + idJefe + "");

	}
	public void AddBaseDeDatosDos(int vidaJugador, int idJefe) {

		Conexion.conectar();

		Conexion.EjecutarUpdate("UPDATE jefesmontana SET vida =" + vidaJugador + " WHERE id =" + idJefe + "");

	}

}
