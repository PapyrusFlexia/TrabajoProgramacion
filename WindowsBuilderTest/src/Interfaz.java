import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	int vidaActualTres;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		 /////////////////////////////////////////////
		
		JButton buttonPantano = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cover1.png")));
		buttonPantano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Conexion.conectar();
				Pantano nwP = new Pantano();
				nwP.NewScreen();
				// contentPane.setVisible(false);
				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//close();

				new Pantano();
				Pantano pantanoVisible = new Pantano();
				pantanoVisible.setVisible(true);
			  
				buttonPantano.setEnabled(false);

			}
		});

		buttonPantano.setBounds(10, 93, 560, 155);
		contentPane.add(buttonPantano);
		

		JButton buttonBosque = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cover3.png")));

		buttonBosque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pantano nwP = new Pantano();
				nwP.NewScreen();
				// contentPane.setVisible(false);
				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//close();

				new Pantano();
				Pantano pantanoVisible = new Pantano();
				pantanoVisible.setVisible(true);
			  
				buttonPantano.setEnabled(false);
			}

		});

		buttonBosque.setBounds(10, 591, 560, 155);
		contentPane.add(buttonBosque);

		JButton buttonMontana = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cover2.png")));
		buttonMontana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantano nwP = new Pantano();
				nwP.NewScreen();
				// contentPane.setVisible(false);
				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//close();

				new Pantano();
				Pantano pantanoVisible = new Pantano();
				pantanoVisible.setVisible(true);
			  
				buttonPantano.setEnabled(false);

			}
		});
		buttonMontana.setBounds(10, 259, 560, 155);
		contentPane.add(buttonMontana);

		JButton buttonDesierto = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cover5.png")));
		buttonDesierto.setBounds(10, 425, 560, 155);
		contentPane.add(buttonDesierto);

		JLabel lblEligeElBioma = new JLabel("Elige el BIOMA en el que te encuentras");
		lblEligeElBioma.setBounds(178, 11, 236, 14);
		contentPane.add(lblEligeElBioma);

		JButton btnCrearNuevoPj = new JButton("CREAR NUEVO PJ");
		btnCrearNuevoPj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreacionPersonajes nwCreacionPersonajes = new CreacionPersonajes();
				nwCreacionPersonajes.NewScreen();

				// contentPane.setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new CreacionPersonajes();
				CreacionPersonajes creacionpersonajesVisible = new CreacionPersonajes();
				creacionpersonajesVisible.setVisible(true);

			}

		});
		btnCrearNuevoPj.setBounds(32, 7, 136, 23);
		contentPane.add(btnCrearNuevoPj);
		
		JButton btnCrearNuevoJefe = new JButton("CREAR NUEVO JEFE");
		btnCrearNuevoJefe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreacionJefes nwCreacionJefes = new CreacionJefes();
				nwCreacionJefes.NewScreen();

				// contentPane.setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new CreacionJefes();
				CreacionJefes creacionjefesVisible = new CreacionJefes();
				creacionjefesVisible.setVisible(true);

			}

		});
		btnCrearNuevoJefe.setBounds(403, 7, 152, 23);
		contentPane.add(btnCrearNuevoJefe );
		
	/*	JButton btnConectar = new JButton("CONECTAR");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion.conectar();
			}

		});	
		btnConectar.setBounds(222, 36, 121, 23);
		contentPane.add(btnConectar);*/
			
			

	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
