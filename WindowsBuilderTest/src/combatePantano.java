import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;

import javax.print.DocFlavor.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

import javax.swing.*;



public class combatePantano extends JFrame {

	private JFrame frame;
	private Jefe accionJefe;
	private turnoJugador accionJugador;
	int vidaActual;
	int counterTurnos = 0;
	int min = 1;
	int max = 10;
	int counterInicio = ThreadLocalRandom.current().nextInt(min, max + 1);
	
	
	// int counterInicio = (int)Math.random();

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					combatePantano windowCp = new combatePantano();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	
	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Lizardmen.png")));
		
	}

	public combatePantano() {

		JFrame jframe = new JFrame("combatePantano");
		jframe.setTitle("combatePantano");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);
		
       /* JLabel background = new JLabel(new ImageIcon("Pantano.png"));
        background.setBounds(10, 32, 560, 394);
		
        JLabel foreground = new JLabel(new ImageIcon("Lizardmen.png"));
        foreground.setBounds(20, 384, 214, 193);


        background.setLayout(new GridBagLayout());
        background.add(foreground);
        add(background);

        pack();

        setLocationByPlatform(true);
        setVisible(true); */
		 /* Icon backgroundIcon = new ImageIcon(new URL("http://s5.favim.com/orig/51/animated-gif-gif-hands-sign-language-Favim.com-542945.gif"));
	      Icon foregroundIcon = new ImageIcon(new URL("http://i.imgur.com/89HANHg.gif"));

	        JLabel background = new JLabel(backgroundIcon);
	        JLabel foreground = new JLabel(foregroundIcon);

	     
	        background.setSize(backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());
	        foreground.setSize(foregroundIcon.getIconWidth(), foregroundIcon.getIconHeight());
	        background.setLocation(0, 0);
	        foreground.setLocation(30, 30);
	        background.setLayout(null);
	        background.add(foreground);
	        setLayout(null);
	        add(background);

	        // set size of frame to size of content
	        setResizable(false);
	        getContentPane().setPreferredSize(new Dimension(backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight()));
	        pack();

	        setLocationRelativeTo(null);
	        setVisible(true);*/

		

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

		JButton btnpasarTurno = new JButton("PASAR TURNO");
		getContentPane().add(btnpasarTurno);
		btnpasarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				turnoJugador vidas = new turnoJugador();
				// accionJefe = new Jefe();
				// accionJugador = new turnoJugador(); ////////////////////////////////
				// if (counterInicio % 2 == 0) {
				accionJugador = new turnoJugador();
				if (vidas.getVidaActualUno() >= 1) {
					

					
					
					accionJefe = new Jefe();
					accionJugador.primerJefePantano();
					// if (vidas.getVidaActualUno() < 1){
					// frame.setVisible(false);
					// }
				} else if (vidas.getVidaActualDos() >= 1) {
					accionJefe = new Jefe();
					accionJugador.segundoJefePantano();

				} else if (vidas.getVidaActualTres() >= 1) {
					accionJefe = new Jefe();
					accionJugador.tercerJefePantano();
					System.out.println("FELICIDADES has superado el PANTANO");

				} else if (vidas.getVidaActualCuatro() >= 1) {
					accionJefe = new Jefe();
					accionJugador.cuartoJefePantano();

				} else if (vidas.getVidaActualCinco() >= 1) {
					accionJefe = new Jefe();
					accionJugador.quintoJefePantano();

				} else if (vidas.getVidaActualSeis() >= 1) {
					accionJefe = new Jefe();
					accionJugador.sextoJefePantano();
					System.out.println("FELICIDADES has superado el DESIERTO");

				} else if (vidas.getVidaActualSiete() >= 1) {
					accionJefe = new Jefe();
					accionJugador.septimoJefePantano();

				} else if (vidas.getVidaActualOcho() >= 1) {
					accionJefe = new Jefe();
					accionJugador.octavoJefePantano();

				} else if (vidas.getVidaActualNueve() >= 1) {
					accionJefe = new Jefe();
					accionJugador.novenoJefePantano();
					System.out.println("FELICIDADES has superado la MONTAÑA");

				} else if (vidas.getVidaActualDiez() >= 1) {
					accionJefe = new Jefe();
					accionJugador.decimoJefePantano();

				} else if (vidas.getVidaActualOnce() >= 1) {
					accionJefe = new Jefe();
					accionJugador.undecimoJefePantano();

				} else if (vidas.getVidaActualDoce() >= 1) {
					accionJefe = new Jefe();
					accionJugador.duodecimoJefePantano();
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

		btnpasarTurno.setBounds(200, 574, 178, 23);
		getContentPane().add(btnpasarTurno);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 11, 89, 23);
		getContentPane().add(btnVolver);
		
	/*	JLabel lblGif = new JLabel("");
		lblGif.setIcon(new ImageIcon("C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\Pantano.gif"));
		lblGif.setBounds(10, 32, 560, 394);
		getContentPane().add(lblGif);
		
		JLabel lblGifJugador = new JLabel("");
		lblGifJugador.setIcon(new ImageIcon("C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\Lizardmen.gif"));
		lblGifJugador.setBounds(20, 384, 214, 193);
		getContentPane().add(lblGifJugador);*/
		
		 
		
		
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