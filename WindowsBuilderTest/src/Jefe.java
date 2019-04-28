import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Jefe extends JFrame {

	private JFrame frame;
	static int tirada = Dado.tirarDado(3) + 1;
	int vidaActual;
	int id_jugador;
	int cogerId;
	Combate elTurno = new Combate();
	int turnoActual = elTurno.getTurno();
	
	String consulta = "SELECT * FROM jugadores ORDER BY RAND() LIMIT 1";
	
	//System.out.println("turno " + turnoActual);

	

	
	ResultSet rs = Conexion.EjecutarSentencia(consulta);
	
	
	//String[] meterRS = new String[3];
	ArrayList<JefeGetSet> meterRS = new ArrayList<JefeGetSet>();
	int sizeRSjefe = meterRS.size();
	JefeGetSet objetoJefe = new JefeGetSet(0, 0);
	//JefeGetSet k = new JefeGetSet(vidaActual, id_jugador);
	

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
		System.out.println("turno " + turnoActual);
		final JFrame dado = new JFrame();
		
		int dmgJefe = tirarJefe();
		//this.combate = combate;

		// Dado Tirada = new Dado();//
		// Tirada.tirarDado(6);//
		JOptionPane.showMessageDialog(dado.getComponent(0),"El jefe ha sacado " + dmgJefe + " , pierdes " + dmgJefe + " de vida");

		try {

			//ResultSet rs = Conexion.EjecutarSentencia("SELECT vida FROM jugadores WHERE nombre = \"manolo\"");
			//ResultSet rs = Conexion.EjecutarSentencia("SELECT * FROM jugadores ORDER BY RAND() LIMIT 1");
			//id_jugador= rs.getInt("id");
			
			// System.out.println(Conexion.EjecutarSentencia(query));
			while (rs.next()) {
				 
				//meterRS.add(rs.getString(1));
				vidaActual = rs.getInt("vida");
				id_jugador= rs.getInt("id");
				//cogerId = rs.getInt("id");
				
				JefeGetSet k = new JefeGetSet(vidaActual, id_jugador);
				
				meterRS.add(k);
			}
			System.out.println(meterRS);
			System.out.println(((JefeGetSet) meterRS.get(0)).getVida());
			//objetoJefe.setVida() = 
			
			vidaActual = (Integer) meterRS.get(0).getVida();
			vidaActual = vidaActual  - dmgJefe;
			
			System.out.println(vidaActual);
			
			/*System.out.println(k.getVida());
			System.out.println("1 la vida original es igual a " + vidaActual);
			vidaActual = k.getVida();
			System.out.println("2 la vida actual es igual a " + vidaActual);
			vidaActual = vidaActual - dmgJefe;
			System.out.println("3 la vida actual es igual a " + vidaActual+ " el daño del jefe es" + dmgJefe);
			
			System.out.println("la vida actual " + vidaActual);*/
			
			//objetoJefe.setVida(); = meterRS.get(0);
			//System.out.println(JefeGetSet.getVida());
			
			//for(int x=0;x<sizeRSjefe;x++) {
				//vidaActual = vidaActual - dmgJefe;
			//int vidaTemporal = meterRS.get(0);
			//meterRS.get(1) = meterRS.get(1) - dmgJefe;
			//System.out.println(meterRS.toString());
			AddBaseDeDatos(vidaActual);
		//	}
			
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
	
		//for(int x=0;x<sizeRSjefe;x++) {
			//vidaActual = vidaActual - dmgJefe;
		//System.out.println(meterRS.get(x));
		//meterRS.get(x) = meterRS.get(x) - dmgJefe;
		//AddBaseDeDatos(vidaActual);
		//}

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

	public  void AddBaseDeDatos(int vidaJugador) {
		Conexion.conectar();
		// Conexion.EjecutarUpdate("UPDATE jugadores SET vida = \""+ vidaJugador +
		// "\"");
		//Conexion.EjecutarUpdate("UPDATE jugadores SET vida = " + vidaJugador + " WHERE nombre = " + "\"manolo\""); 
		Conexion.EjecutarUpdate("UPDATE jugadores SET vida =" + vidaJugador + " WHERE id =" + id_jugador + "");

	}
}