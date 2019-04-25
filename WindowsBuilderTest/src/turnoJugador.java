import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class turnoJugador extends JFrame {

	private JFrame frame;
	static int tirada;
	int vidaActual;
	int id_jugador;
	int cogerId;
	ResultSet rs = Conexion.EjecutarSentencia("SELECT * FROM jefespantano LIMIT 1");

	/**
	 * Launch the application.
	 */
/*	public static void NewScreen() {
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
	}*/

	/**
	 * Create the frame.
	 */

	public turnoJugador() {
		final JFrame dado = new JFrame();
		//this.combate = combate;

		// Dado Tirada = new Dado();//
		// Tirada.tirarDado(6);//
		int dmgJugador = tirarJugador();
		JOptionPane.showMessageDialog(dado.getComponent(0),"Has sacado " + dmgJugador + " , el jefe pierde " + dmgJugador + " de vida");

		try {

			//ResultSet rs = Conexion.EjecutarSentencia("SELECT * FROM jefes ORDER BY RAND() LIMIT 1");
			//  id_jugador = rs.getInt("id");
			// System.out.println(Conexion.EjecutarSentencia(query));
			while (rs.next()) {
				vidaActual = rs.getInt("vida");
				
				id_jugador = rs.getInt("id");
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		

		vidaActual = vidaActual - dmgJugador;
		AddBaseDeDatos(vidaActual);

		if (vidaActual < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "Has matado al JEFE, encuentras una tienda cercana");
			Tienda nwTienda = new Tienda();
			nwTienda.NewScreen();

			// contentPane.setVisible(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);
		}
		
	
	    

	}

	public int tirarJugador(){
		 return tirada = Dado.tirarDado(3)+ 1;
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
		Conexion.EjecutarUpdate("UPDATE jefespantano SET vida =" + vidaJefe + " WHERE id =" + id_jugador + ""); //////////////// FALTA WHERE

	}
}