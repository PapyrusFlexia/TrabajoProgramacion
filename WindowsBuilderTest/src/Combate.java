import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Combate extends JFrame {

	private JFrame frame;
	private Jefe accionJefe;
	
	   

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combate windowC = new Combate();
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
	public Combate() {
		
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);
		
		JButton btnPruebaJugador = new JButton("IR A JUGADOR (PRUEBA)");
		btnPruebaJugador.setBounds(168, 301, 222, 23);
		getContentPane().add(btnPruebaJugador);
		btnPruebaJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Jugador();
				Jugador jugadorVisible = new Jugador(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				jugadorVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});

		JButton pasarTurno = new JButton("PASAR TURNO");
		getContentPane().add(pasarTurno);
		pasarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accionJefe = new Jefe();
				//combateJefe.Jefe();
				//accionJefe.Jefe();
				 
				
			}

		});

		pasarTurno.setBounds(197, 133, 145, 23);
		getContentPane().add(pasarTurno);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 11, 89, 23);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Pantano();
				Pantano pantanoVisible = new Pantano(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				pantanoVisible.setVisible(true);

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
}