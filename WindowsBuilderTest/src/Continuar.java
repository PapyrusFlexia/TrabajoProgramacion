import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Continuar extends JFrame {

	private JFrame frame;
	private JTextField txtAtencinSiContinuas;
	int VidaTotal = Dado.tirarDado(4);
	String id = "001";
	String nombre = "Frikón Ululante";
	String atkInicial = "1d4";

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

		JButton btnLeeroyJenkinsContinuar = new JButton("LEEROY JENKINS! CONTINUAR");
		btnLeeroyJenkinsContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteBaseDeDatos();
				AddBaseDeDatos(id, nombre, VidaTotal, atkInicial, VidaTotal);
				new Combate();
				
				Combate combateVisible = new Combate(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				combateVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});
		btnLeeroyJenkinsContinuar.setBounds(10, 79, 181, 23);
		getContentPane().add(btnLeeroyJenkinsContinuar);

		JButton btnQuedarseEnLa = new JButton("QUEDARSE EN LA TIENDA");
		btnQuedarseEnLa.setBounds(241, 79, 181, 23);
		getContentPane().add(btnQuedarseEnLa);
		btnQuedarseEnLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tienda();
				Tienda tiendaVisible = new Tienda(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				tiendaVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});

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