import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Continuar extends JFrame {

	public JFrame frame;
	private JTextField txtAtencinSiContinuas;
	int VidaTotalFacil = Dado.tirarDado(4);
	int VidaTotalMedio = Dado.tirarDado(6);
	int VidaTotalDificil = Dado.tirarDado(8);
	String idFacil = "001";
	String idMedio = "002";
	String idDificil = "003";
	String nombreFacil = "Frikón Ululante";
	String nombreMedio = "prueba";
	String nombreDificil = "Compañia robotizada hindu";
	String atkInicialFacil = "1d4";
	String atkInicialMedio = "1d6";
	String atkInicialDificil = "1d8";
	private boolean isFirstTime = true;
	private boolean isSecondTime = true;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Continuar windowCont = new Continuar();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public Continuar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 173);
		getContentPane().setLayout(null);

		txtAtencinSiContinuas = new JTextField();
		txtAtencinSiContinuas.setText("ATENCI\u00D3N, si continuas te enfrentaras a un JEFE \u00BFDeseas continuar?");
		txtAtencinSiContinuas.setBounds(43, 0, 361, 68);
		getContentPane().add(txtAtencinSiContinuas);
		txtAtencinSiContinuas.setColumns(10);

		JButton btnLeeroyJenkinsContinuarFacil = new JButton("LEEROY JENKINS! CONTINUAR.");
		btnLeeroyJenkinsContinuarFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteBaseDeDatos();
				AddBaseDeDatos(idFacil, nombreFacil, VidaTotalFacil, atkInicialFacil, VidaTotalFacil);
				new Combate();
				
				Combate nwCombate = new Combate();
				nwCombate.NewScreen();

				// contentPane.setVisible(false);
				
				Continuar esconderContinuar = new Continuar();
				//esconderContinuar.setVisible(false);
				
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); ///////////////////////////////
				frame.setVisible(false);
			//	close();

				new Combate();
				Combate combateVisible = new Combate();
				combateVisible.setVisible(true);
				
				//btnLeeroyJenkinsContinuarFacil.setVisible(false);
				

			}

		});
		btnLeeroyJenkinsContinuarFacil.setBounds(10, 79, 181, 23);
		getContentPane().add(btnLeeroyJenkinsContinuarFacil);
		
		

		

		JButton btnQuedarseEnLa = new JButton("QUEDARSE EN LA TIENDA");
		btnQuedarseEnLa.setBounds(241, 79, 181, 23);
		getContentPane().add(btnQuedarseEnLa);
		btnQuedarseEnLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				continuar();
				/*new Tienda();
				Tienda tiendaVisible = new Tienda(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				tiendaVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();*/

			}

		});

	}
	public void continuar() {
		
		    
		        if (isFirstTime) {
		        	DeleteBaseDeDatos();
					AddBaseDeDatos(idFacil, nombreFacil, VidaTotalFacil, atkInicialFacil, VidaTotalFacil);
					new Combate();
					
					Combate combateVisible = new Combate(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
					combateVisible.setVisible(true);

					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					close();
		            isFirstTime = false;
		        } else if (isSecondTime) {
		        	DeleteBaseDeDatos();
		    		AddBaseDeDatos(idMedio, nombreMedio, VidaTotalMedio, atkInicialMedio, VidaTotalMedio);
		    		new Combate();
		    		
		    		Combate combateVisible = new Combate(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
		    		combateVisible.setVisible(true);

		    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    		close();
		        } else {
		        	DeleteBaseDeDatos();
		    		AddBaseDeDatos(idDificil, nombreDificil, VidaTotalDificil, atkInicialDificil, VidaTotalDificil);
		    		new Combate();
		    		
		    		Combate combateVisible = new Combate(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
		    		combateVisible.setVisible(true);

		    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    		close();
		        	
		        }
		    }
		
		
		
		
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	}
	
	public static void AddBaseDeDatos(String id, String nombre, int vida, String ataque, int vida_total) {
		Conexion.conectar();
		Conexion.EjecutarUpdate("INSERT INTO jefespantano VALUES (\"" + id + "\",\"" + nombre + "\",\"" + vida + "\",\"" + ataque
				+ "\",\"" + vida_total + "\")");

	}
	public static void DeleteBaseDeDatos() {
		Conexion.conectar();
		Conexion.EjecutarUpdate("DELETE FROM jefespantano LIMIT 1");
	}
}