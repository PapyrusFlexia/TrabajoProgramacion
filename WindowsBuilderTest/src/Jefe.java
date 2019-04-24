import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Jefe extends JFrame {

	private JFrame frame;
	static int tirada = Dado.tirarDado(3) + 1;
	int vidaActual;
	

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

	public Jefe() {
		final JFrame dado = new JFrame();
		
		int dmgJefe = tirarJefe();
		//this.combate = combate;

		// Dado Tirada = new Dado();//
		// Tirada.tirarDado(6);//
		JOptionPane.showMessageDialog(dado.getComponent(0),"El jefe ha sacado " + dmgJefe + " , pierdes " + dmgJefe + " de vida");

		try {

			ResultSet rs = Conexion.EjecutarSentencia("SELECT vida FROM jugadores WHERE nombre = \"manolo\"");
			
			// System.out.println(Conexion.EjecutarSentencia(query));
			while (rs.next()) {

				vidaActual = rs.getInt(1);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		

		vidaActual = vidaActual - dmgJefe;
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

	
	public int tirarJefe(){
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

	public static void AddBaseDeDatos(int vidaJugador) {
		Conexion.conectar();
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = \""+ vidaJugador +
		// "\"");
		Conexion.EjecutarUpdate("UPDATE jugadores SET vida = " + vidaJugador + " WHERE nombre = " + "\"manolo\""); //////////////// FALTA WHERE

	}
}