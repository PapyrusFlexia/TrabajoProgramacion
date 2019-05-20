import java.sql.*;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;
import java.io.IOException;

public class turnoJugador extends JFrame {

	final JFrame dado = new JFrame();
	static int tirada = Dado.tirarDado(3) + 1;
	static int tiradaDio = Dado.tirarDado(6) + 1;

	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;

	int vidaActualUno;
	int vidaActualDos;
	int vidaActualTres;
	int vidaActualCuatro;
	int vidaActualCinco;
	int vidaActualSeis;
	int vidaActualSiete;
	int vidaActualOcho;
	int vidaActualNueve;
	int vidaActualDiez;
	int vidaActualOnce;
	int vidaActualDoce;
	int vidaJugador;
	int vidaTotalJugador;
	int tiradaSlack = tirada - 2;

	String nombreJefeUno, nombreJefeDos, nombreJefeTres, nombreJefeCuatro, nombreJefeCinco, nombreJefeSeis,
			nombreJefeSiete, nombreJefeOcho, nombreJefeNueve, nombreJefeDiez, nombreJefeOnce, nombreJefeDoce;

	int idJefeUno, idJefeDos, idJefeTres, idJefeCuatro, idJefeCinco, idJefeSeis, idJefeSiete, idJefeOcho, idJefeNueve,
			idJefeDiez, idJefeOnce, idJefeDoce;

	int poderEquipamiento, oro;

	int dmgTotalJugador;

	int cogerIdMontana;

	String consultaJefeUno = "SELECT * FROM jefes WHERE id= 1";
	String consultaJefeDos = "SELECT * FROM jefes WHERE id= 2";
	String consultaJefeTres = "SELECT * FROM jefes WHERE id= 3";
	String consultaJefeCuatro = "SELECT * FROM jefes WHERE id= 4";
	String consultaJefeCinco = "SELECT * FROM jefes WHERE id= 5";
	String consultaJefeSeis = "SELECT * FROM jefes WHERE id= 6";
	String consultaJefeSiete = "SELECT * FROM jefes WHERE id= 7";
	String consultaJefeOcho = "SELECT * FROM jefes WHERE id= 8";
	String consultaJefeNueve = "SELECT * FROM jefes WHERE id= 9";
	String consultaJefeDiez = "SELECT * FROM jefes WHERE id= 10";
	String consultaJefeOnce = "SELECT * FROM jefes WHERE id= 11";
	String consultaJefeDoce = "SELECT * FROM jefes WHERE id= 12";
	String consultaEstadisticas = "SELECT * FROM inventario WHERE estado = \"equipado\" AND tipo = \"arma\"";
	String consultaOro = "SELECT oro FROM jugadores WHERE id = \"1\"";
	String consultaVidaJugador = "SELECT * FROM jugadores WHERE id= 1";

	ArrayList<turnoJugadorGetSet> meterRS = new ArrayList<turnoJugadorGetSet>();
	ArrayList<vidaJugadorGetSet> meterRSvidaJugador = new ArrayList<vidaJugadorGetSet>();
	int sizeRSjefe = meterRS.size();

	ArrayList<equipamientoGetSet> meterRSEquipamiento = new ArrayList<equipamientoGetSet>();

	ArrayList<jugadorGetSet> meterRSoro = new ArrayList<jugadorGetSet>();
	
	/** turno en el que se quita vida a los jefes, con bonificaciones por armas equipadas, dependiendo del jefe tendrá unas mecánicas u otras **/

	public turnoJugador() {

		ResultSet rsUno = Conexion.EjecutarSentencia(consultaJefeUno);
		try {

			while (rsUno.next()) {

				vidaActualUno = rsUno.getInt("vida");

				nombreJefeUno = rsUno.getString("nombre");

				if (rsUno.getInt("id") == 1) {
					idJefeUno = rsUno.getInt("id");

				}
				turnoJugadorGetSet kUno = new turnoJugadorGetSet(vidaActualUno, idJefeUno, nombreJefeUno);

				meterRS.add(kUno);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsDos = Conexion.EjecutarSentencia(consultaJefeDos);
		try {
			while (rsDos.next()) {

				vidaActualDos = rsDos.getInt("vida");

				nombreJefeDos = rsDos.getString("nombre");

				if (rsDos.getInt("id") == 2) {
					idJefeDos = rsDos.getInt("id");

				}
				turnoJugadorGetSet kDos = new turnoJugadorGetSet(vidaActualDos, idJefeDos, nombreJefeDos);

				meterRS.add(kDos);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsTres = Conexion.EjecutarSentencia(consultaJefeTres);
		try {
			while (rsTres.next()) {

				vidaActualTres = rsTres.getInt("vida");

				nombreJefeTres = rsTres.getString("nombre");

				if (rsTres.getInt("id") == 3) {
					idJefeTres = rsTres.getInt("id");
				}
				turnoJugadorGetSet kTres = new turnoJugadorGetSet(vidaActualTres, idJefeTres, nombreJefeTres);

				meterRS.add(kTres);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		ResultSet rsCuatro = Conexion.EjecutarSentencia(consultaJefeCuatro);
		try {
			while (rsCuatro.next()) {

				vidaActualCuatro = rsCuatro.getInt("vida");

				nombreJefeCuatro = rsCuatro.getString("nombre");

				if (rsCuatro.getInt("id") == 4) {
					idJefeCuatro = rsCuatro.getInt("id");
				}
				turnoJugadorGetSet kCuatro = new turnoJugadorGetSet(vidaActualCuatro, idJefeCuatro, nombreJefeCuatro);

				meterRS.add(kCuatro);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		ResultSet rsCinco = Conexion.EjecutarSentencia(consultaJefeCinco);
		try {
			while (rsCinco.next()) {

				vidaActualCinco = rsCinco.getInt("vida");

				nombreJefeCinco = rsCinco.getString("nombre");

				if (rsCinco.getInt("id") == 5) {
					idJefeCinco = rsCinco.getInt("id");
				}
				turnoJugadorGetSet kCinco = new turnoJugadorGetSet(vidaActualCinco, idJefeCinco, nombreJefeCinco);

				meterRS.add(kCinco);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		ResultSet rsSeis = Conexion.EjecutarSentencia(consultaJefeSeis);
		try {
			while (rsSeis.next()) {

				vidaActualSeis = rsSeis.getInt("vida");

				nombreJefeSeis = rsSeis.getString("nombre");

				if (rsSeis.getInt("id") == 6) {
					idJefeSeis = rsSeis.getInt("id");
				}
				turnoJugadorGetSet kSeis = new turnoJugadorGetSet(vidaActualSeis, idJefeSeis, nombreJefeSeis);

				meterRS.add(kSeis);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		ResultSet rsSiete = Conexion.EjecutarSentencia(consultaJefeSiete);
		try {

			while (rsSiete.next()) {

				vidaActualSiete = rsSiete.getInt("vida");

				nombreJefeSiete = rsSiete.getString("nombre");

				if (rsSiete.getInt("id") == 7) {
					idJefeSiete = rsSiete.getInt("id");

				}
				turnoJugadorGetSet kSiete = new turnoJugadorGetSet(vidaActualSiete, idJefeSiete, nombreJefeSiete);

				meterRS.add(kSiete);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsOcho = Conexion.EjecutarSentencia(consultaJefeOcho);
		try {
			while (rsOcho.next()) {

				vidaActualOcho = rsOcho.getInt("vida");

				nombreJefeOcho = rsOcho.getString("nombre");

				if (rsOcho.getInt("id") == 8) {
					idJefeOcho = rsOcho.getInt("id");

				}
				turnoJugadorGetSet kOcho = new turnoJugadorGetSet(vidaActualOcho, idJefeOcho, nombreJefeOcho);

				meterRS.add(kOcho);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsNueve = Conexion.EjecutarSentencia(consultaJefeNueve);
		try {
			while (rsNueve.next()) {

				vidaActualNueve = rsNueve.getInt("vida");

				nombreJefeNueve = rsNueve.getString("nombre");

				if (rsNueve.getInt("id") == 9) {
					idJefeNueve = rsNueve.getInt("id");
				}
				turnoJugadorGetSet kNueve = new turnoJugadorGetSet(vidaActualNueve, idJefeNueve, nombreJefeNueve);

				meterRS.add(kNueve);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		ResultSet rsDiez = Conexion.EjecutarSentencia(consultaJefeDiez);
		try {
			while (rsDiez.next()) {

				vidaActualDiez = rsDiez.getInt("vida");

				nombreJefeDiez = rsDiez.getString("nombre");

				if (rsDiez.getInt("id") == 10) {
					idJefeDiez = rsDiez.getInt("id");
				}
				turnoJugadorGetSet kDiez = new turnoJugadorGetSet(vidaActualDiez, idJefeDiez, nombreJefeDiez);

				meterRS.add(kDiez);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		ResultSet rsOnce = Conexion.EjecutarSentencia(consultaJefeOnce);
		try {
			while (rsOnce.next()) {

				vidaActualOnce = rsOnce.getInt("vida");

				nombreJefeOnce = rsOnce.getString("nombre");

				if (rsOnce.getInt("id") == 11) {
					idJefeOnce = rsOnce.getInt("id");
				}
				turnoJugadorGetSet kOnce = new turnoJugadorGetSet(vidaActualOnce, idJefeOnce, nombreJefeOnce);

				meterRS.add(kOnce);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		ResultSet rsDoce = Conexion.EjecutarSentencia(consultaJefeDoce);
		try {
			while (rsDoce.next()) {

				vidaActualDoce = rsDoce.getInt("vida");

				nombreJefeDoce = rsDoce.getString("nombre");

				if (rsDoce.getInt("id") == 12) {
					idJefeDoce = rsDoce.getInt("id");
				}
				turnoJugadorGetSet kDoce = new turnoJugadorGetSet(vidaActualDoce, idJefeDoce, nombreJefeDoce);

				meterRS.add(kDoce);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		ResultSet rsEstadisticas = Conexion.EjecutarSentencia(consultaEstadisticas);
		try {

			while (rsEstadisticas.next()) {

				poderEquipamiento = rsEstadisticas.getInt("poder");

				equipamientoGetSet kEstadisticas = new equipamientoGetSet(poderEquipamiento);

				meterRSEquipamiento.add(kEstadisticas);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsOro = Conexion.EjecutarSentencia(consultaOro);
		try {

			while (rsOro.next()) {

				oro = rsOro.getInt("oro");

				jugadorGetSet kOro = new jugadorGetSet(oro);

				meterRSoro.add(kOro);

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

	}

	public int getVidaActualUno() {
		return vidaActualUno;
	}

	public void setVidaActualUno(int vidaActualUno) {
		this.vidaActualUno = vidaActualUno;
	}

	public int getVidaActualDos() {
		return vidaActualDos;
	}

	public void setVidaActualDos(int vidaActualDos) {
		this.vidaActualDos = vidaActualDos;
	}

	public int getVidaActualTres() {
		return vidaActualTres;
	}

	public void setVidaActualTres(int vidaActualTres) {
		this.vidaActualTres = vidaActualTres;
	}

	public int getVidaActualCuatro() {
		return vidaActualCuatro;
	}

	public void setVidaActualCuatro(int vidaActualCuatro) {
		this.vidaActualCuatro = vidaActualCuatro;
	}

	public int getVidaActualCinco() {
		return vidaActualCinco;
	}

	public void setVidaActualCinco(int vidaActualCinco) {
		this.vidaActualCinco = vidaActualCinco;
	}

	public int getVidaActualSeis() {
		return vidaActualSeis;
	}

	public void setVidaActualSeis(int vidaActualSeis) {
		this.vidaActualSeis = vidaActualSeis;
	}

	public int getVidaActualSiete() {
		return vidaActualSiete;
	}

	public void setVidaActualSiete(int vidaActualSiete) {
		this.vidaActualSiete = vidaActualSiete;
	}

	public int getVidaActualOcho() {
		return vidaActualOcho;
	}

	public void setVidaActualOcho(int vidaActualOcho) {
		this.vidaActualOcho = vidaActualOcho;
	}

	public int getVidaActualNueve() {
		return vidaActualNueve;
	}

	public void setVidaActualNueve(int vidaActualNueve) {
		this.vidaActualNueve = vidaActualNueve;
	}

	public int getVidaActualDiez() {
		return vidaActualDiez;
	}

	public void setVidaActualDiez(int vidaActualDiez) {
		this.vidaActualDiez = vidaActualDiez;
	}

	public int getVidaActualOnce() {
		return vidaActualOnce;
	}

	public void setVidaActualOnce(int vidaActualOnce) {
		this.vidaActualOnce = vidaActualOnce;
	}

	public int getVidaActualDoce() {
		return vidaActualDoce;
	}

	public void setVidaActualDoce(int vidaActualDoce) {
		this.vidaActualDoce = vidaActualDoce;
	}

	public int getPoderEquipamiento() {
		return poderEquipamiento;
	}

	public void setPoderEquipamiento(int poderEquipamiento) {
		this.poderEquipamiento = poderEquipamiento;
	}

	public int getVidaJugador() {
		return vidaJugador;
	}

	public void setVidaJugador(int vidaJugador) {
		this.vidaJugador = vidaJugador;
	}

	public void primerJefePantano() {

		int dmgJugador = tirarJugador();

		dmgTotalJugador = dmgJugador + poderEquipamiento;

		vidaActualUno = vidaActualUno + 1;
		System.out.println(vidaActualUno);
		vidaActualUno = vidaActualUno - dmgTotalJugador;

		AddBaseDeDatos(vidaActualUno, idJefeUno, nombreJefeUno);

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"El FRIKÓN ULULANTE se mete un vicio jugando al WoW, ignorando lo exámenes y ese bulto extraño, curandose 1 de VIDA");

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
		oro = oro + 25;
		AddBaseDeDatosOro(oro);

		if (vidaActualUno < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"El FRIKÓN ULULANTE a muerto, has ganado 25 de oro, tienes " + oro + " monedas de oro");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void segundoJefePantano() {

		int dmgJugador = tirarJugador();

		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualDos = vidaActualDos - dmgTotalJugador;
		AddBaseDeDatos(vidaActualDos, idJefeDos, nombreJefeDos);

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Stefán Karl Stefánsson es demasiado buena gente como para intentar matarte, pulsa F para mostrar tus respetos");

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has mostrado al JEFE " + dmgTotalJugador + " puntos de respeto");
		oro = oro + 75;
		AddBaseDeDatosOro(oro);

		if (vidaActualDos < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"Stefán Karl Stefánsson te regala su botín y te desea buenos días, has ganado 75 de oro, tienes "
							+ oro + " monedas de oro");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}
	}

	public void tercerJefePantano() {

		int dmgJugador = tirarJugador();

		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualTres = vidaActualTres - dmgTotalJugador;
		vidaActualTres = vidaActualTres * 2;
		AddBaseDeDatos(vidaActualTres, idJefeTres, nombreJefeTres);

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"La Compañia Robotizada Hindú usa sub-bots para multplicarse! Ahora tiene: " + vidaActualTres
						+ " de vida");

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		oro = oro + 125;
		AddBaseDeDatosOro(oro);

		if (vidaActualTres < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"TGEI a muerto, has ganado 125 de oro, tienes " + oro + " monedas de oro y un BROFIST");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void cuartoJefePantano() {

		int dmgJugador = tirarJugador();

		dmgTotalJugador = dmgJugador + poderEquipamiento;

		if (tirarJugador() < 3) {

			JOptionPane.showMessageDialog(dado.getComponent(0),
					"Camaleónidas se fusiona con su entorno, y esquiva tu ataque, ¡Concentrate!");
		} else {
			vidaActualCuatro = vidaActualCuatro - dmgTotalJugador;
			AddBaseDeDatos(vidaActualCuatro, idJefeCuatro, nombreJefeCuatro);
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
							+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
			oro = oro + 50;
			AddBaseDeDatosOro(oro);

			if (vidaActualCuatro < 1) {
				JOptionPane.showMessageDialog(dado.getComponent(0),
						"CAMALEÓNIDAS a muerto, has ganado 50 de oro, tienes " + oro + " monedas de oro");
				new Tienda();
				Tienda tiendaVisible = new Tienda();
				tiendaVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();
			}

		}

	}

	public void quintoJefePantano() {

		int dmgJugador = tirarJugador();

		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualCinco = vidaActualCinco - dmgTotalJugador;
		vidaJugador = vidaJugador - tiradaSlack;
		System.out.println("vida: " + vidaJugador);
		AddBaseDeDatos(vidaActualCinco, idJefeCinco, nombreJefeCinco);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"¡Slackman te mandó trabajo extra y no te diste cuenta! Slackman te baja la nota y sufres: "
						+ tiradaSlack + " de dmg extra");
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
		oro = oro + 90;
		AddBaseDeDatosOro(oro);

		if (vidaActualCinco < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"SLACKMAN a muerto, has ganado 90 de oro, tienes " + oro + " monedas de oro");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void sextoJefePantano() {

		int dmgJugador = tirarJugador();

		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualSeis = vidaActualSeis - dmgTotalJugador + tiradaSlack;
		AddBaseDeDatos(vidaActualSeis, idJefeSeis, nombreJefeSeis);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"El Hada ITS te envenena tu mente con su aburrimiento, sufres: " + tiradaSlack
						+ " de dmg, y ella se recupera: " + tiradaSlack + " de vida");
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
		oro = oro + 150;
		AddBaseDeDatosOro(oro);

		if (vidaActualSeis < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"El HADA ITS a muerto, has ganado 150 de oro, tienes " + oro + " monedas de oro");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void septimoJefePantano() {

		int dmgJugador = tirarJugador();

		int tiradaUganda = tiradaSlack - 1;
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualSiete = vidaActualSiete - dmgTotalJugador;
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Múltiples Ugandan Knuckles salen de la tumba para atacarte! El JEFE gana 1 de dmg por cada Ugandan Knuckles, el cual gana "
						+ tiradaUganda + " de dmg");

		vidaJugador = vidaJugador - tiradaUganda;

		AddBaseDeDatos(vidaActualSiete, idJefeSiete, nombreJefeSiete);

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
		oro = oro + 75;
		AddBaseDeDatosOro(oro);

		if (vidaActualSiete < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"UGANDAN KNUCKLES a muerto ,otra vez, has ganado 75 de oro, tienes " + oro + " monedas de oro");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void octavoJefePantano() {

		int dmgJugador = tirarJugador();

		int defensa = Dado.tirarDado(2) + 1;

		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualOcho = vidaActualOcho + defensa - dmgTotalJugador;

		AddBaseDeDatos(vidaActualOcho, idJefeOcho, nombreJefeOcho);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"No me toques los spaghettis, el Padre Oso dijo, subiendo su defensa " + defensa
						+ " puntos para que no le robes sus spaghettis");
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
		oro = oro + 125;
		AddBaseDeDatosOro(oro);

		if (vidaActualOcho < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"El PADRE OSO ha muerto, has ganado 125 de oro, tienes " + oro + " monedas de oro");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void novenoJefePantano() {

		int dmgJugador = tirarJugador();

		dmgTotalJugador = poderEquipamiento;
		vidaActualNueve = vidaActualNueve - dmgTotalJugador;
		AddBaseDeDatos(vidaActualNueve, idJefeNueve, nombreJefeNueve);

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Shrek is love, Shrek is life dijo Shrek, lo que hace que bajen tus ganas de matarle, haciendo que solo tu arma afecte al dmg");

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
		oro = oro + 190;
		AddBaseDeDatosOro(oro);

		if (vidaActualNueve < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"SHREK ha muerto, has ganado 190 de oro, tienes " + oro + " monedas de oro");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}
	}

	public void decimoJefePantano() {

		int dmgJugador = tirarJugador();

		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualDiez = vidaActualDiez + vidaActualDiez / 2 - dmgTotalJugador;
		AddBaseDeDatos(vidaActualDiez, idJefeDiez, nombreJefeDiez);

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Shaggy , sorprendido de verte llegar tan lejos dice: Zoinks! Ahora tendré que usar un 1% de mi poder, duplicando su vida");
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
		oro = oro + 125;
		AddBaseDeDatosOro(oro);

		if (vidaActualDiez < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"SHAGGY a huido, has ganado 125 de oro, tienes " + oro + " monedas de oro");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void undecimoJefePantano() {

		int dmgJugador = tirarJugador();

		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualOnce = vidaActualOnce - dmgTotalJugador;
		vidaActualOnce = vidaActualOnce + 2;
		AddBaseDeDatos(vidaActualOnce, idJefeOnce, nombreJefeOnce);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"gachiBASS oh si señor, creo que te has equivocado el club de cuero esta 2 pisos abajo gachiBASS, dijo ricardo, recuperando 2 de vida cada turno");
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
		oro = oro + 200;
		AddBaseDeDatosOro(oro);

		if (vidaActualOnce < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"RICARDO a muerto, has ganado 200 de oro, tienes " + oro + " monedas de oro");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void duodecimoJefePantano() {

		int dmgJugador = tirarJugador();

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Oh, te acercas a mi? Depués de comprobar mi poder? KONO DIO DA!");

		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualDoce = vidaActualDoce - dmgTotalJugador;

		JOptionPane.showMessageDialog(dado.getComponent(0), "ZA WARUDO (THE WORLD) !!!!!!");
		vidaJugador = vidaJugador - tiradaDio;
		JOptionPane.showMessageDialog(dado.getComponent(0), "DIO te ha causado " + tiradaDio
				+ " puntos de daño , DIO ignora tu armadura, el JEFE te ha quitado: " + tiradaDio + " de vida");

		AddBaseDeDatos(vidaActualDoce, idJefeDoce, nombreJefeDoce);

		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has hecho " + dmgJugador + " puntos de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");
		oro = oro + 1000;
		AddBaseDeDatosOro(oro);

		if (vidaActualDoce < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0),
					"DIO a muerto, has ganado 1000 de oro, el titulo de SEÑOR, y el territorio de ALTO JARDÍN, FELICIDADES héroe de AZEROTH");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public int tirarJugador() {
		return tirada = Dado.tirarDado(3) + 1;
	}

	/** escriba las acciones del jugador en el log **/
	public void logJugador() {

		int dmgJugador = tirada;
		int dmgTotalJugador = dmgJugador + poderEquipamiento;
		String dmgStringJugador = String.valueOf(dmgTotalJugador);

		try {

			
			fh = new FileHandler("src\\Log.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			

			logger.info("Daño causado por el JUGADOR: " + dmgStringJugador);

			if (vidaActualUno > 0) {
				logger.info(" El JEFE " + nombreJefeUno + " tiene: " + vidaActualUno + " de vida" + "\n");

			} else if (vidaActualDos > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + "\n");

				logger.info(" El siguiente JEFE: " + nombreJefeDos + " tiene: " + vidaActualDos + " de vida" + "\n");

			} else if (vidaActualTres > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos);

				logger.info("El siguiente JEFE: " + nombreJefeTres + " tiene: " + vidaActualTres + " de vida");
			} else if (vidaActualCuatro > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres);

				logger.info("El siguiente JEFE: " + nombreJefeCuatro + " tiene: " + vidaActualCuatro + " de vida");
			} else if (vidaActualCinco > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres + ", "
						+ nombreJefeCuatro);

				logger.info("El siguiente JEFE: " + nombreJefeCinco + " tiene: " + vidaActualCinco + " de vida");
			} else if (vidaActualSeis > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres + ", "
						+ nombreJefeCuatro + ", " + nombreJefeCinco);

				logger.info("El siguiente JEFE: " + nombreJefeSeis + " tiene: " + vidaActualSeis + " de vida");
			} else if (vidaActualSiete > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres + ", "
						+ nombreJefeCuatro + ", " + nombreJefeCinco + ", " + nombreJefeSeis);

				logger.info("El siguiente JEFE: " + nombreJefeSiete + " tiene: " + vidaActualSiete + " de vida");
			} else if (vidaActualOcho > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres + ", "
						+ nombreJefeCuatro + ", " + nombreJefeCinco + ", " + nombreJefeSeis + ", " + nombreJefeSiete);

				logger.info("El siguiente JEFE: " + nombreJefeOcho + " tiene: " + vidaActualOcho + " de vida");
			} else if (vidaActualNueve > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres + ", "
						+ nombreJefeCuatro + ", " + nombreJefeCinco + ", " + nombreJefeSeis + ", " + nombreJefeSiete
						+ ", " + nombreJefeOcho);
				logger.info("El siguiente JEFE: " + nombreJefeNueve + " tiene: " + vidaActualNueve + " de vida");
			} else if (vidaActualDiez > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres + ", "
						+ nombreJefeCuatro + ", " + nombreJefeCinco + ", " + nombreJefeSeis + ", " + nombreJefeSiete
						+ ", " + nombreJefeOcho + ", " + nombreJefeNueve);
				logger.info("El siguiente JEFE: " + nombreJefeDiez + " tiene: " + vidaActualDiez + " de vida");
			} else if (vidaActualOnce > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres + ", "
						+ nombreJefeCuatro + ", " + nombreJefeCinco + ", " + nombreJefeSeis + ", " + nombreJefeSiete
						+ ", " + nombreJefeOcho + ", " + nombreJefeNueve + ", " + nombreJefeDiez);
				logger.info("El siguiente  JEFE: " + nombreJefeOnce + " tiene: " + vidaActualOnce + " de vida");
			} else if (vidaActualDoce > 0) {
				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres + ", "
						+ nombreJefeCuatro + ", " + nombreJefeCinco + ", " + nombreJefeSeis + ", " + nombreJefeSiete
						+ ", " + nombreJefeOcho + ", " + nombreJefeNueve + ", " + nombreJefeDiez + ", "
						+ nombreJefeOnce);
				logger.info("El siguiente JEFE " + nombreJefeDoce + " tiene: " + vidaActualDoce + " de vida");

				logger.info(" JEFES muertos: " + nombreJefeUno + ", " + nombreJefeDos + ", " + nombreJefeTres + ", "
						+ nombreJefeCuatro + ", " + nombreJefeCinco + ", " + nombreJefeSeis + ", " + nombreJefeSiete
						+ ", " + nombreJefeOcho + ", " + nombreJefeNueve + ", " + nombreJefeDiez + ", " + nombreJefeOnce
						+ ", " + nombreJefeDoce);
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public void AddBaseDeDatos(int vidaJugador, int idJefe, String nombreJefe) {

		Conexion.conectar();

		Conexion.EjecutarUpdate("UPDATE jefes SET vida =" + vidaJugador + " WHERE id =" + idJefe + "");

	}

	/**
	 * PARA ACTUALIZAR EL ORO
	 * @param oro
	 */
	public void AddBaseDeDatosOro(int oro) {

		Conexion.EjecutarUpdate("UPDATE jugadores SET oro =" + oro + "");

	}
	
	/**
	 * PARA ACTUALIZAR LA VIDA
	 * @param vidaJugador
	 */

	public void AddBaseDeDatosVidaJugador(int vidaJugador) {

		Conexion.EjecutarUpdate("UPDATE jugadores SET vida =" + vidaJugador + " WHERE id = \"1\"");

	}

}
