package src;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Muerte extends JFrame {

	private JFrame frame;
	private JTextField crearNuevoPj;
	JLabel background;

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Muerte windowM = new Muerte();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	/** si tu vida baja a 0, te permite crear otro personaje (abirendo la clase de creacion de personajes, o salirte del juego **/

	public Muerte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 367, 459, 430);
		getContentPane().setLayout(null);

		Toolkit marco = Toolkit.getDefaultToolkit();
		
		background = new JLabel(new ImageIcon("muerte.gif"));
		background.setBounds(10, 112, 412, 268);
		getContentPane().add(background);

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);
		setTitle("Cells&Chameleons");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 430);
		getContentPane().setLayout(null);

		crearNuevoPj = new JTextField();
		crearNuevoPj.setText("HAS MUERTO :( , ¿QUIERES CREAR UN NUEVO PERSONAJE?");
		crearNuevoPj.setBounds(10, 0, 412, 68);
		getContentPane().add(crearNuevoPj);
		crearNuevoPj.setColumns(10);
		crearNuevoPj.setEditable(false);

		JButton btnLeeroyJenkinsContinuar = new JButton("LOK'TAR OGAR! (CONTINUAR)");
		btnLeeroyJenkinsContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CreacionPersonajes();
				CreacionPersonajes CreacionPersonajesVisible = new CreacionPersonajes();
				CreacionPersonajesVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();
				
				dispose();

			}

		});
		btnLeeroyJenkinsContinuar.setBounds(10, 79, 195, 23);
		getContentPane().add(btnLeeroyJenkinsContinuar);

		JButton btnQuedarseEnLa = new JButton("ME RETIRO POR HOY ");
		btnQuedarseEnLa.setBounds(215, 79, 207, 23);
		getContentPane().add(btnQuedarseEnLa);
		btnQuedarseEnLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}

		});

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	}
}