import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class combateMontana extends JFrame {

	private JFrame frame;
	private Jefe accionJefe;
	private turnoJugador accionJugador;
	int vidaActualMontana;
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
					combateMontana windowCm = new combateMontana();
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
	public combateMontana() {
		
		 JFrame jframe = new JFrame("combateMontaña"); /////////////////////////
		 jframe.setTitle("combateMontaña");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);
		

		System.out.println("combates en la montaña");
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
							accionJugador.cuartoJefeMontana();

						}
					} else if (counterInicio % 2 != 0) {
						if (counterTurnos % 2 == 0) {
							counterTurnos++;
							accionJugador = new turnoJugador();
							accionJugador.cuartoJefeMontana();
							
						} else if (counterTurnos % 2 == 1) {
							counterTurnos--;
							accionJefe = new Jefe();
						}

					}

				} while (vidaActualMontana > 0);

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
					if (vidas.getVidaActualCuatro() >= 1) {
						accionJugador.cuartoJefeMontana();
						//if (vidas.getVidaActualUno() < 1){
						//frame.setVisible(false);
						//}
					} else if (vidas.getVidaActualCinco() >= 1) {
						accionJugador.quintoJefeMontana();
						
					} else if (vidas.getVidaActualSeis() >= 1) {
						accionJugador.sextoJefeMontana();
						System.out.println("FELICIDADES has superado la MONTAÑA");
						
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
				new Montana();
				Montana montanaVisible = new Montana(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				montanaVisible.setVisible(true);

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