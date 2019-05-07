import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.awt.*;

import javax.print.DocFlavor.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

import javax.swing.*;
import java.io.*;

public class combatePantano extends JFrame {

	private JFrame frame;
	private Jefe accionJefe;
	turnoJugador accionJugador = new turnoJugador();

	int vidaActual;
	int counterTurnos = 0;
	int min = 1;
	int max = 10;
	int counterInicio = ThreadLocalRandom.current().nextInt(min, max + 1);
	private JScrollPane scroll;
	private JTextField textField;

	// int counterInicio = (int)Math.random();

	/**
	 * Launch the application.
	 */
	/*
	 * public static void NewScreen() { EventQueue.invokeLater(new Runnable() {
	 * public void run() { try { combatePantano windowCp = new combatePantano(); //
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * }
	 * 
	 * }); }
	 */

	public combatePantano() {

//	scroll.setBounds(517, 347, 17, 194);
		// getContentPane().add(scroll);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);

		frame = new JFrame("Log");
		frame.setTitle("Registro de Combate");
		frame.setBounds(10, 52, 524, 240);
		frame.setLocationRelativeTo(null);

		JTextArea textArea = new JTextArea();

		// scroll = new JScrollPane(textArea);
		scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		frame.getContentPane().add(scroll);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textArea.setBounds(76, 317, 442, 240);

		String codigo = new String(), path = "C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\src\\Log.log";

		FileReader fr = null;
		BufferedReader entrada = null;
		try {
			fr = new FileReader(path);
			entrada = new BufferedReader(fr);

			while (entrada.ready()) {
				codigo += entrada.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		textArea.setText(codigo);

		/*
		 * JLabel background = new JLabel(new ImageIcon("Pantano.gif"));
		 * background.setBounds(10, 52, 524, 240);
		 * 
		 * JLabel foreground = new JLabel(new ImageIcon("Lizardmen.gif"));
		 * foreground.setBounds(50, 52, 108, 195);
		 * 
		 * 
		 * background.setLayout(new GridBagLayout()); background.add(foreground);
		 * add(background);
		 * 
		 * // pack();
		 * 
		 * setLocationByPlatform(true); setVisible(true);
		 */
		Icon backgroundIcon = new ImageIcon("Pantano.gif");
		Icon foregroundIcon = new ImageIcon("Lizardmen.gif");

		JLabel background = new JLabel(
				new ImageIcon("C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\Pantano.gif"));
		JLabel foreground = new JLabel(
				new ImageIcon("C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\Lizardmen.gif"));

		background.setSize(backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());
		foreground.setSize(foregroundIcon.getIconWidth(), foregroundIcon.getIconHeight());
		// background.setLocation(0, 0);
		// foreground.setLocation(30, 30);
		background.setBounds(10, 52, 524, 240);
		foreground.setBounds(50, 52, 108, 195);
		// background.setLayout(null);
		background.add(foreground);
		getContentPane().setLayout(null);
		getContentPane().add(background);

		getContentPane().setPreferredSize(new Dimension(backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight()));
		// pack();

		setLocationRelativeTo(null);
		setVisible(true);

		/*
		 * JButton comenzarCombate = new JButton("COMENZAR COMBATE");
		 * getContentPane().add(comenzarCombate); comenzarCombate.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent arg0) { //
		 * accionJefe = new Jefe(); // accionJugador = new turnoJugador();
		 * 
		 * do { if (counterInicio % 2 == 0) { if (counterTurnos % 2 == 0) {
		 * ///////////////////////////////////////////////////////////////
		 * counterTurnos++; accionJefe = new Jefe(); } else if (counterTurnos % 2 == 1)
		 * { counterTurnos--; accionJugador = new turnoJugador();
		 * accionJugador.primerJefePantano();
		 * 
		 * } } else if (counterInicio % 2 != 0) { if (counterTurnos % 2 == 0) {
		 * counterTurnos++; accionJugador = new turnoJugador();
		 * 
		 * accionJugador.primerJefePantano(); } else if (counterTurnos % 2 == 1) {
		 * counterTurnos--; accionJefe = new Jefe(); }
		 * 
		 * }
		 * 
		 * } while (vidaActual > 0);
		 * 
		 * comenzarCombate.setVisible(false);
		 * 
		 * }
		 * 
		 * });
		 * 
		 * comenzarCombate.setBounds(185, 133, 178, 23);
		 * getContentPane().add(comenzarCombate);
		 */
		// JTextArea log = new JTextArea();
		// log.setBounds(71, 424, 442, 142);
		// getContentPane().add(log);
		// log.append( "Hello World" );

		// frame.getContentPane().add(log);

		JButton btnpasarTurno = new JButton("PASAR TURNO");
		getContentPane().add(btnpasarTurno);
		btnpasarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// turnoJugador vidas = new turnoJugador();
				// accionJefe = new Jefe();
				// accionJugador = new turnoJugador(); ////////////////////////////////
				// if (counterInicio % 2 == 0) {

				if (accionJugador.getVidaActualUno() >= 1) {

					accionJefe = new Jefe();
					accionJugador.primerJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

					// if (vidas.getVidaActualUno() < 1){
					// frame.setVisible(false);
					// }
				} else if (accionJugador.getVidaActualDos() >= 1) {
					accionJefe = new Jefe();
					accionJugador.segundoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

				} else if (accionJugador.getVidaActualTres() >= 1) {
					accionJefe = new Jefe();
					accionJugador.tercerJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();
					System.out.println("FELICIDADES has superado el PANTANO");

				} else if (accionJugador.getVidaActualCuatro() >= 1) {
					accionJefe = new Jefe();
					accionJugador.cuartoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

				} else if (accionJugador.getVidaActualCinco() >= 1) {
					accionJefe = new Jefe();
					accionJugador.quintoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

				} else if (accionJugador.getVidaActualSeis() >= 1) {
					accionJefe = new Jefe();
					accionJugador.sextoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();
					System.out.println("FELICIDADES has superado el DESIERTO");

				} else if (accionJugador.getVidaActualSiete() >= 1) {
					accionJefe = new Jefe();
					accionJugador.septimoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

				} else if (accionJugador.getVidaActualOcho() >= 1) {
					accionJefe = new Jefe();
					accionJugador.octavoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

				} else if (accionJugador.getVidaActualNueve() >= 1) {
					accionJefe = new Jefe();
					accionJugador.novenoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();
					System.out.println("FELICIDADES has superado la MONTAÑA");

				} else if (accionJugador.getVidaActualDiez() >= 1) {
					accionJefe = new Jefe();
					accionJugador.decimoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

				} else if (accionJugador.getVidaActualOnce() >= 1) {
					accionJefe = new Jefe();
					accionJugador.undecimoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

				} else if (accionJugador.getVidaActualDoce() >= 1) {
					accionJefe = new Jefe();
					accionJugador.duodecimoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();
					System.out.println("FELICIDADES has superado el VOLCÁN");
				}

				/*
				 * } else if (counterInicio % 2 != 0) { accionJefe = new Jefe(); //accionJugador
				 * = new turnoJugador(); &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& if
				 * (vidas.getVidaActualUno() > 1) { accionJugador.primerJefePantano(); } else if
				 * (vidas.getVidaActualDos() > 1) { accionJugador.segundoJefePantano(); } else
				 * if (vidas.getVidaActualTres() > 1) { accionJugador.tercerJefePantano();
				 * System.out.println("FELICIDADES has superado el PANTANO"); }
				 * 
				 * }
				 */

				// esto no funciona

				// pasarTurno();

				/*
				 * if (counterInicio % 2 == 0) { accionJugador = new turnoJugador(); accionJefe
				 * = new Jefe(); } else if (counterInicio % 2 != 0) { accionJefe = new Jefe();
				 * accionJugador = new turnoJugador(); }
				 */

			}

		});

		btnpasarTurno.setBounds(203, 669, 178, 23);
		getContentPane().add(btnpasarTurno);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 11, 89, 23);
		getContentPane().add(btnVolver);

		/*
		 * JLabel lblGif = new JLabel(""); lblGif.setIcon(new ImageIcon(
		 * "C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\Pantano.gif"));
		 * lblGif.setBounds(10, 32, 560, 394); getContentPane().add(lblGif);
		 * 
		 * JLabel lblGifJugador = new JLabel(""); lblGifJugador.setIcon(new ImageIcon(
		 * "C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\Lizardmen.gif"));
		 * lblGifJugador.setBounds(20, 384, 214, 193);
		 * getContentPane().add(lblGifJugador);
		 */

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

	public JFrame getFrame() {
		return frame;
	}

	/*
	 * public void log() { try {
	 * 
	 * // This block configure the logger with handler and formatter fh = new
	 * FileHandler(
	 * "C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\src\\Log.log");
	 * logger.addHandler(fh); SimpleFormatter formatter = new SimpleFormatter();
	 * fh.setFormatter(formatter);
	 * 
	 * // the following statement is used to log any messages
	 * logger.info("My first log");
	 * 
	 * } catch (SecurityException e) { e.printStackTrace(); } catch (IOException e)
	 * { e.printStackTrace(); }
	 * 
	 * logger.info("Hi How r u?"); }
	 */

	/*
	 * public void pasarTurno() { ======= public void pasarTurno() { >>>>>>> branch
	 * 'master' of https://github.com/PapyrusFlexia/TrabajoProgramacion.git if
	 * (counterInicio % 2 == 0) { accionJugador = new turnoJugador(); <<<<<<< HEAD
	 * accionJugador.segundoJefePantano(); ======= accionJugador.turno(); >>>>>>>
	 * branch 'master' of https://github.com/PapyrusFlexia/TrabajoProgramacion.git
	 * accionJefe = new Jefe();
	 * 
	 * 
	 * } else if (counterInicio % 2 != 0) { accionJefe = new Jefe(); accionJugador =
	 * new turnoJugador(); <<<<<<< HEAD accionJugador.segundoJefePantano(); =======
	 * accionJugador.turno(); >>>>>>> branch 'master' of
	 * https://github.com/PapyrusFlexia/TrabajoProgramacion.git
	 * 
	 * } }
	 */

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