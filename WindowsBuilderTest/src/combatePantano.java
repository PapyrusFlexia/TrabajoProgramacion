import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

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

	/**
	 * Create the frame.
	 */
	public combatePantano() {
		
		 JFrame jframe = new JFrame("combatePantano");
		 jframe.setTitle("combatePantano");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);
		
		System.out.println("combate en el pantano");
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

		/*JButton comenzarCombate = new JButton("COMENZAR COMBATE");
		getContentPane().add(comenzarCombate);
		comenzarCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// accionJefe = new Jefe();
				// accionJugador = new turnoJugador();

				do {
					if (counterInicio % 2 == 0) {
						if (counterTurnos % 2 == 0) { ///////////////////////////////////////////////////////////////
							counterTurnos++;
							accionJefe = new Jefe();
						} else if (counterTurnos % 2 == 1) {
							counterTurnos--;
							accionJugador = new turnoJugador();
							accionJugador.primerJefePantano();

						}
					} else if (counterInicio % 2 != 0) {
						if (counterTurnos % 2 == 0) {
							counterTurnos++;
							accionJugador = new turnoJugador();

							accionJugador.primerJefePantano();
						} else if (counterTurnos % 2 == 1) {
							counterTurnos--;
							accionJefe = new Jefe();
						}

					}

				} while (vidaActual > 0);

				comenzarCombate.setVisible(false);

			}

		});

		comenzarCombate.setBounds(185, 133, 178, 23);
		getContentPane().add(comenzarCombate);*/

		JButton btnpasarTurno = new JButton("PASAR TURNO");
		getContentPane().add(btnpasarTurno);
		btnpasarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				turnoJugador vidas = new turnoJugador();
				// accionJefe = new Jefe();
				// accionJugador = new turnoJugador(); ////////////////////////////////
				//if (counterInicio % 2 == 0) {
				accionJugador = new turnoJugador();
					if (vidas.getVidaActualUno() >= 1) {
						accionJugador.primerJefePantano();
						//if (vidas.getVidaActualUno() < 1){
						//frame.setVisible(false);
						//}
					} else if (vidas.getVidaActualDos() >= 1) {
						accionJugador.segundoJefePantano();
						
					} else if (vidas.getVidaActualTres() >= 1) {
						accionJugador.tercerJefePantano();
						System.out.println("FELICIDADES has superado el PANTANO");
					
					}


				/*} else if (counterInicio % 2 != 0) {
					accionJefe = new Jefe();
					//accionJugador = new turnoJugador(); &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
					if (vidas.getVidaActualUno() > 1) {
						accionJugador.primerJefePantano();
					} else if (vidas.getVidaActualDos() > 1) {
						accionJugador.segundoJefePantano();
					} else if (vidas.getVidaActualTres() > 1) {
						accionJugador.tercerJefePantano();
						System.out.println("FELICIDADES has superado el PANTANO");
					}

				}*/

				// esto no funciona

				// pasarTurno();

				/*
				 * if (counterInicio % 2 == 0) { accionJugador = new turnoJugador(); accionJefe
				 * = new Jefe(); } else if (counterInicio % 2 != 0) { accionJefe = new Jefe();
				 * accionJugador = new turnoJugador(); }
				 */

			}

		});

		btnpasarTurno.setBounds(185, 133, 178, 23);
		getContentPane().add(btnpasarTurno);

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