import java.sql.*;
import java.util.ArrayList;
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

public class Combate extends JFrame {

	final JFrame dado = new JFrame();
	private JPanel log = new JPanel();
	turnoJefe accionJefe = new turnoJefe();
	turnoJugador accionJugador = new turnoJugador();
	CreacionPersonajes elegirPj = new CreacionPersonajes();

	int vidaActual;
	int counterTurnos = 0;
	int min = 1;
	int max = 10;
	int counterInicio = ThreadLocalRandom.current().nextInt(min, max + 1);
	static int tirada = Dado.tirarDado(3) + 1;
	private JScrollPane scroll;
	private JTextField textField;
	JTextArea textArea = new JTextArea();
	JLabel backgroundP;
	JLabel backgroundD;
	JLabel backgroundM;
	JLabel backgroundV;
	JLabel foreground;
	JLabel foregroundJefe;
	JLabel barraJugador;
	JLabel barraJefe;

	int podervidaMenor, podervidaMedia, podervidaMayor, oro;

	int vidaJugador;

	String consultavidaMenor = "SELECT * FROM inventario WHERE estado = \"equipado\" AND tipo = \"pocion\" AND nombre = \"vidamenor\"";
	String consultavidaMedia = "SELECT * FROM inventario WHERE estado = \"equipado\" AND tipo = \"pocion\" AND nombre = \"vidamedia\"";
	String consultavidaMayor = "SELECT * FROM inventario WHERE estado = \"equipado\" AND tipo = \"pocion\" AND nombre = \"vidamayor\"";
	String consultaVidaJugador = "SELECT * FROM jugadores WHERE id= 1";

	ArrayList<equipamientoGetSet> meterRSvida = new ArrayList<equipamientoGetSet>();
	ArrayList<vidaJugadorGetSet> meterRSvidaJugador = new ArrayList<vidaJugadorGetSet>();
	private JLabel lblNewLabel;
	private JLabel label;

	/**
	 * se recogen los valores de todos los jefes y de la vida del jugador en los
	 * resultset y se llaman dependiendo si ha muerto el anterior, a parte de
	 * botones para subir la vida dependiendo de la poción que se use
	 **/

	public Combate() {
		Toolkit marco = Toolkit.getDefaultToolkit();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1250, 143, 750, 795);
		getContentPane().setLayout(null);

		ResultSet rsvidaMenor = Conexion.EjecutarSentencia(consultavidaMenor);
		try {

			while (rsvidaMenor.next()) {

				podervidaMenor = rsvidaMenor.getInt("poder");

				equipamientoGetSet kEstadisticas = new equipamientoGetSet(podervidaMenor);

				meterRSvida.add(kEstadisticas);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsvidaMedia = Conexion.EjecutarSentencia(consultavidaMedia);
		try {

			while (rsvidaMedia.next()) {

				podervidaMedia = rsvidaMedia.getInt("poder");

				equipamientoGetSet kEstadisticas = new equipamientoGetSet(podervidaMedia);

				meterRSvida.add(kEstadisticas);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsvidaMayor = Conexion.EjecutarSentencia(consultavidaMayor);
		try {

			while (rsvidaMayor.next()) {

				podervidaMayor = rsvidaMayor.getInt("poder");

				equipamientoGetSet kEstadisticas = new equipamientoGetSet(podervidaMayor);

				meterRSvida.add(kEstadisticas);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rs = Conexion.EjecutarSentencia(consultaVidaJugador);
		try {

			while (rs.next()) {

				vidaJugador = rs.getInt("vida");

				vidaJugadorGetSet kvj = new vidaJugadorGetSet(vidaJugador);

				meterRSvidaJugador.add(kvj);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);
		setTitle("Cells&Chameleons");

		String codigo = new String(), path = "src\\Log.log";

		FileReader fr = null; // CREA LOS FICHEROS PARA ESCRIBIR EL REGISTRO DE COMBATE
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

		setLocationRelativeTo(null);
		setVisible(true);

		backgroundP = new JLabel(new ImageIcon("Pantano.gif"));
		backgroundP.setBounds(21, 52, 692, 240);
		getContentPane().add(backgroundP);

		backgroundD = new JLabel(new ImageIcon("Desierto.gif"));
		backgroundD.setBounds(21, 52, 692, 240);
		getContentPane().add(backgroundD);

		backgroundM = new JLabel(new ImageIcon("Montana.gif"));
		backgroundM.setBounds(21, 52, 692, 240);
		getContentPane().add(backgroundM);

		backgroundV = new JLabel(new ImageIcon("Volcan.gif"));
		backgroundV.setBounds(21, 52, 692, 240);
		getContentPane().add(backgroundV);

		elegirPj.cogerId();

		// DEPENDIENDO DEL PERSONAJE QUE ELIJAS SE VISUALIZARA UNO U OTRO
		int numPj = elegirPj.getCambiarPj();
		System.out.println(numPj);
		foreground = new JLabel("");
		if (numPj == 1) {
			
			foreground = new JLabel(new ImageIcon("src\\Humano.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundP.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Humano.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundD.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Humano.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundM.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Humano.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundV.add(foreground);

		} else if (numPj == 2) {
			
			foreground = new JLabel(new ImageIcon("src\\Lizardmen.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundP.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Lizardmen.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundD.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Lizardmen.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundM.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Lizardmen.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundV.add(foreground);

		} else if (numPj == 3) {
			
			foreground = new JLabel(new ImageIcon("src\\Elfo.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundP.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Elfo.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundD.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Elfo.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundM.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Elfo.gif"));
			foreground.setBounds(100, 52, 108, 195);
			backgroundV.add(foreground);

		} else if (numPj == 4) {
			
			foreground = new JLabel(new ImageIcon("src\\Enano.gif"));
			foreground.setBounds(100, 32, 108, 195);
			backgroundP.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Enano.gif"));
			foreground.setBounds(100, 32, 108, 195);
			backgroundD.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Enano.gif"));
			foreground.setBounds(100, 32, 108, 195);
			backgroundM.add(foreground);

			foreground = new JLabel(new ImageIcon("src\\Enano.gif"));
			foreground.setBounds(100, 32, 108, 195);
			backgroundV.add(foreground);

		}

		barraJugador = new JLabel(new ImageIcon("jugadorVida.gif"));
		barraJugador.setBounds(-76, 289, 467, 64);
		getContentPane().add(barraJugador);

		barraJefe = new JLabel(new ImageIcon("jefeVida.gif"));
		barraJefe.setBounds(377, 289, 374, 64);
		getContentPane().add(barraJefe);

		backgroundP.setVisible(false);
		backgroundD.setVisible(false);
		backgroundM.setVisible(false);
		backgroundV.setVisible(false);

		JButton btnpasarTurno = new JButton("PASAR TURNO");
		getContentPane().add(btnpasarTurno);
		btnpasarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
				lblNewLabel.setBounds(215, 333, 132, 14);
				getContentPane().add(lblNewLabel);

				if (accionJugador.getVidaActualUno() >= 1) {

					backgroundP.setVisible(true);
					backgroundD.setVisible(false);
					backgroundM.setVisible(false);
					backgroundV.setVisible(false);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Frikon.gif"));
					foregroundJefe.setBounds(450, 52, 108, 195);
					backgroundP.add(foregroundJefe);

					accionJefe.ataqueJefe();
					accionJugador.primerJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

					if (accionJugador.getVidaActualUno() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualDos() >= 1) {

					backgroundP.setVisible(true);
					backgroundD.setVisible(false);
					backgroundM.setVisible(false);
					backgroundV.setVisible(false);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Stefan.gif"));
					foregroundJefe.setBounds(450, 52, 108, 195);
					backgroundP.add(foregroundJefe);

					accionJugador.segundoJefePantano();

					accionJugador.logJugador();

					if (accionJugador.getVidaActualDos() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualTres() >= 1) {

					backgroundP.setVisible(true);
					backgroundD.setVisible(false);
					backgroundM.setVisible(false);
					backgroundV.setVisible(false);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Tgei.gif"));
					foregroundJefe.setBounds(450, 52, 108, 195);
					backgroundP.add(foregroundJefe);
					accionJefe.ataqueJefe();
					accionJugador.tercerJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();
					JOptionPane.showMessageDialog(dado.getComponent(0), "FELICIDADES has superado el PANTANO");

					if (accionJugador.getVidaActualTres() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualCuatro() >= 1) {

					backgroundP.setVisible(false);
					backgroundD.setVisible(true);
					backgroundM.setVisible(false);
					backgroundV.setVisible(false);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Camaleonidas.gif"));
					foregroundJefe.setBounds(300, 52, 320, 300);
					backgroundD.add(foregroundJefe);

					accionJefe.ataqueJefe();
					accionJugador.cuartoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

					if (accionJugador.getVidaActualCuatro() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualCinco() >= 1) {

					backgroundP.setVisible(false);
					backgroundD.setVisible(true);
					backgroundM.setVisible(false);
					backgroundV.setVisible(false);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Slackman.gif"));
					foregroundJefe.setBounds(450, 52, 108, 195);
					backgroundD.add(foregroundJefe);

					accionJefe.ataqueJefe();
					accionJugador.quintoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

					if (accionJugador.getVidaActualCinco() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualSeis() >= 1) {

					backgroundP.setVisible(false);
					backgroundD.setVisible(true);
					backgroundM.setVisible(false);
					backgroundV.setVisible(false);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);
					foregroundJefe = new JLabel(new ImageIcon("src\\its.gif"));
					foregroundJefe.setBounds(450, 52, 108, 195);
					backgroundD.add(foregroundJefe);

					accionJefe.ataqueJefe();
					accionJugador.sextoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();
					JOptionPane.showMessageDialog(dado.getComponent(0), "FELICIDADES has superado el DESIERTO");

					if (accionJugador.getVidaActualSeis() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualSiete() >= 1) {

					backgroundP.setVisible(false);
					backgroundD.setVisible(false);
					backgroundM.setVisible(true);
					backgroundV.setVisible(false);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Uganda.gif"));
					foregroundJefe.setBounds(450, 52, 108, 250);
					backgroundM.add(foregroundJefe);
					accionJefe.ataqueJefe();
					accionJugador.septimoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

					if (accionJugador.getVidaActualSiete() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualOcho() >= 1) {

					backgroundP.setVisible(false);
					backgroundD.setVisible(false);
					backgroundM.setVisible(true);
					backgroundV.setVisible(false);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Somebody.gif"));
					foregroundJefe.setBounds(400, 52, 150, 195);
					backgroundM.add(foregroundJefe);

					accionJefe.ataqueJefe();
					accionJugador.octavoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

					if (accionJugador.getVidaActualOcho() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualNueve() >= 1) {

					backgroundP.setVisible(false);
					backgroundD.setVisible(false);
					backgroundM.setVisible(true);
					backgroundV.setVisible(false);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Shrek.gif"));
					foregroundJefe.setBounds(450, 52, 108, 195);
					backgroundM.add(foregroundJefe);
					accionJefe.ataqueJefe();
					accionJugador.novenoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();
					JOptionPane.showMessageDialog(dado.getComponent(0), "FELICIDADES has superado la MONTAÑA");

					if (accionJugador.getVidaActualNueve() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualDiez() >= 1) {

					backgroundP.setVisible(false);
					backgroundD.setVisible(false);
					backgroundM.setVisible(false);
					backgroundV.setVisible(true);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Shaggy.gif"));
					foregroundJefe.setBounds(450, 52, 108, 195);
					backgroundV.add(foregroundJefe);
					accionJefe.ataqueJefe();
					accionJugador.decimoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

					if (accionJugador.getVidaActualDiez() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualOnce() >= 1) {

					backgroundP.setVisible(false);
					backgroundD.setVisible(false);
					backgroundM.setVisible(false);
					backgroundV.setVisible(true);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\Ricardo.gif"));
					foregroundJefe.setBounds(450, 52, 108, 195);
					backgroundV.add(foregroundJefe);
					accionJefe.ataqueJefe();
					accionJugador.undecimoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();

					if (accionJugador.getVidaActualOnce() <= 0) {
						dispose();
					}

				} else if (accionJugador.getVidaActualDoce() >= 1) {

					backgroundP.setVisible(false);
					backgroundD.setVisible(false);
					backgroundM.setVisible(false);
					backgroundV.setVisible(true);

					label = new JLabel("VIDA JEFE: " + accionJugador.getVidaActualUno());
					label.setBounds(474, 333, 132, 14);
					getContentPane().add(label);

					lblNewLabel = new JLabel("VIDA JUGADOR: " + vidaJugador);
					lblNewLabel.setBounds(215, 333, 132, 14);
					getContentPane().add(lblNewLabel);

					foregroundJefe = new JLabel(new ImageIcon("src\\DIO.gif"));
					foregroundJefe.setBounds(450, 52, 108, 195);
					backgroundV.add(foregroundJefe);
					accionJefe.ataqueJefe();
					accionJugador.duodecimoJefePantano();

					accionJefe.logJefe();
					accionJugador.logJugador();
					JOptionPane.showMessageDialog(dado.getComponent(0), "FELICIDADES has superado el VOLCÁN");

					if (accionJugador.getVidaActualDoce() <= 0) {
						dispose();
					}
				}

			}

		});

		btnpasarTurno.setBounds(285, 593, 178, 23);
		getContentPane().add(btnpasarTurno);

		JButton btnVolver = new JButton("HUIR");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int huir = tirarJugador();

				if (huir >= 3) {
					new Bioma();
					Bioma biomaVisible = new Bioma();
					biomaVisible.setVisible(true);

					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					close();

					dispose();
				} else {
					JOptionPane.showMessageDialog(dado.getComponent(0),
							"No has conseguido HUIR, tu tirada ha sido : " + huir);
					accionJefe.ataqueJefe();
				}

			}

		});
		btnVolver.setBounds(329, 649, 89, 23);
		getContentPane().add(btnVolver);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(70, 400, 452, 150);
		getContentPane().add(textArea_1);

		textArea_1.setText(codigo);
		scroll = new JScrollPane(textArea_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(149, 401, 452, 150);
		scroll.setVisible(true);
		scroll.setViewportView(textArea_1);
		getContentPane().add(scroll);
		textArea_1.setEditable(false);

		JButton btnTomarsePocinPequea = new JButton("TOMARSE POCI\u00D3N MENOR");
		btnTomarsePocinPequea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				vidaJugador = vidaJugador + podervidaMenor;
				System.out.println(vidaJugador);
				System.out.println(podervidaMenor);
				QuitarPocionMenor();

			}
		});
		btnTomarsePocinPequea.setBounds(21, 356, 207, 23);
		getContentPane().add(btnTomarsePocinPequea);

		JButton button = new JButton("TOMARSE POCI\u00D3N MEDIANA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				vidaJugador = vidaJugador + podervidaMedia;
				System.out.println(vidaJugador);
				QuitarPocionMedia();

			}
		});
		button.setBounds(267, 356, 207, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("TOMARSE POCI\u00D3N GRANDE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				vidaJugador = vidaJugador + podervidaMayor;
				System.out.println(vidaJugador);
				QuitarPocionMayor();

			}
		});
		button_1.setBounds(506, 356, 207, 23);
		getContentPane().add(button_1);

		

	}

	/** para hacer una tirada **/

	public int tirarJugador() {
		return tirada = Dado.tirarDado(3) + 1;
	}

	/** para cerrar la pestaña **/

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	}

	/** para borrar las pociones una vez usadas **/

	public static void QuitarPocionMenor() {
		Conexion.conectar();
		Conexion.EjecutarUpdate(
				"DELETE FROM inventario WHERE estado = \"equipado\" AND tipo = \"pocion\" AND nombre = \"vidamenor\"");
	}

	/** para borrar las pociones una vez usadas **/

	public static void QuitarPocionMedia() {
		Conexion.conectar();
		Conexion.EjecutarUpdate(
				"DELETE FROM inventario WHERE estado = \"equipado\" AND tipo = \"pocion\" AND nombre = \"vidamedia\"");
	}

	/** para borrar las pociones una vez usadas **/

	public static void QuitarPocionMayor() {
		Conexion.conectar();
		Conexion.EjecutarUpdate(
				"DELETE FROM inventario WHERE estado = \"equipado\" AND tipo = \"pocion\" AND nombre = \"vidamayor\"");
	}
}