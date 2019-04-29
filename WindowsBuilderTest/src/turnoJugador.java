import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class turnoJugador extends JFrame {

	private JFrame frame;
	static int tirada = Dado.tirarDado(3) + 1;
	int vidaActualFacil;
	int vidaActualMedio;
	int vidaActualDificil;
	int idActual;
	int id_jefe;
	int cogerId;

	Combate elTurno = new Combate();
	int turnoActual = elTurno.getTurno();

	String consulta = "SELECT * FROM jefes ORDER BY RAND() LIMIT 1";

	// System.out.println("turno " + turnoActual);

	ResultSet rs = Conexion.EjecutarSentencia(consulta);

	// String[] meterRS = new String[3];
	ArrayList<turnoJugadorGetSet> meterRSjugador = new ArrayList<turnoJugadorGetSet>();
	int sizeRSjugador = meterRSjugador.size();
	turnoJugadorGetSet objetoturnoJefe = new turnoJugadorGetSet(0, 0);
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
		System.out.println("turno " + turnoActual);
		final JFrame dado = new JFrame();

		int dmgJugador = tirarJugador();
		// this.combate = combate;

		// Dado Tirada = new Dado();//
		// Tirada.tirarDado(6);//
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " , el JEFE pierde " + dmgJugador + " de vida");

		try {

			// ResultSet rs = Conexion.EjecutarSentencia("SELECT vida FROM jugadores WHERE
			// nombre = \"manolo\"");
			// ResultSet rs = Conexion.EjecutarSentencia("SELECT * FROM jugadores ORDER BY
			// RAND() LIMIT 1");
			// id_jugador= rs.getInt("id");

			// System.out.println(Conexion.EjecutarSentencia(query));
			while (rs.next()) {

				// meterRS.add(rs.getString(1));
				vidaActualFacil = rs.getInt("vida");
				vidaActualMedio = rs.getInt("vida");
				vidaActualDificil = rs.getInt("vida");
				id_jefe = rs.getInt("id");
				// cogerId = rs.getInt("id");

				turnoJugadorGetSet kFacil = new turnoJugadorGetSet(vidaActualFacil, id_jefe);
				turnoJugadorGetSet kMedio = new turnoJugadorGetSet(vidaActualMedio, id_jefe);
				turnoJugadorGetSet kDificil = new turnoJugadorGetSet(vidaActualDificil, id_jefe);

				meterRSjugador.add(kFacil);
				meterRSjugador.add(kMedio);
				meterRSjugador.add(kDificil);

			}
			System.out.println(meterRSjugador);
			//System.out.println(((JefeGetSet) meterRS.get(0)).getVida());
			// System.out.println("id " +((JefeGetSet) meterRS.get(0)).getId());
			// objetoJefe.setVida() =

			// idActual = (Integer) meterRS.get(1).getId();
			if (vidaActualFacil > 0) {
				if (id_jefe == 1) {

					System.out.println("id " + id_jefe);
					vidaActualFacil = (Integer) meterRSjugador.get(0).getVida();

					vidaActualFacil = vidaActualFacil - dmgJugador;
					if (vidaActualFacil < 1) {
						JOptionPane.showMessageDialog(dado.getComponent(0),
								"Has matado al JEFE, encuentras una TIENDA cercana");
						new Tienda();
						Tienda tiendaVisible = new Tienda(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
						tiendaVisible.setVisible(true);

						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						close();
					}

				} else {
					System.out.println("Has fallado");
				}
			} else if (vidaActualMedio > 0) {
				if (id_jefe == 2) {

					System.out.println("id " + id_jefe);
					vidaActualMedio = (Integer) meterRSjugador.get(0).getVida();

					vidaActualMedio = vidaActualMedio - dmgJugador;
					if (vidaActualMedio < 1) {
						JOptionPane.showMessageDialog(dado.getComponent(0),
								"Has matado al JEFE, encuentras una TIENDA cercana");
						new Tienda();
						Tienda tiendaVisible = new Tienda(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
						tiendaVisible.setVisible(true);

						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						close();
					}

				} else {
					System.out.println("Has fallado");
				}

			} else if (vidaActualDificil > 0) {
				if (id_jefe == 3) {

					System.out.println("id " + id_jefe);
					vidaActualDificil = (Integer) meterRSjugador.get(0).getVida();

					vidaActualDificil = vidaActualDificil - dmgJugador;
					if (vidaActualMedio < 1) {
						JOptionPane.showMessageDialog(dado.getComponent(0),
								"Has matado al JEFE, encuentras una TIENDA cercana");
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
				JOptionPane.showMessageDialog(dado.getComponent(0), "Has superado el PANTANO, felicidades AVENTURERO");
			}

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
			AddBaseDeDatos(vidaActualFacil);
			AddBaseDeDatos(vidaActualMedio);
			AddBaseDeDatos(vidaActualDificil);
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

	public void AddBaseDeDatos(int vidaJefe) {
		Conexion.conectar();
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = \""+ vidaJugador +
		// "\"");
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = " + vidaJugador + "
		// WHERE nombre = " + "\"manolo\"");
		Conexion.EjecutarUpdate("UPDATE jefes SET vida =" + vidaJefe + " WHERE id =" + id_jefe + "");

	}
}