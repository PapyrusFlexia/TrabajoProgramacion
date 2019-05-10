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

	String nombreJefeUno, nombreJefeDos, nombreJefeTres, nombreJefeCuatro, nombreJefeCinco, nombreJefeSeis,
			nombreJefeSiete, nombreJefeOcho, nombreJefeNueve, nombreJefeDiez, nombreJefeOnce, nombreJefeDoce;

	int idJefeUno, idJefeDos, idJefeTres, idJefeCuatro, idJefeCinco, idJefeSeis, idJefeSiete, idJefeOcho, idJefeNueve,
			idJefeDiez, idJefeOnce, idJefeDoce;

	int poderEquipamiento;

	int dmgJugador = tirarJugador();

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
	String consultaEstadisticas = "SELECT * FROM inventario WHERE categoria = \"enfundado\" AND tipo = \"arma\"";

	// ResultSet rsUno = Conexion.EjecutarSentencia(consultaJefeUno);
	// ResultSet rsDos = Conexion.EjecutarSentencia(consultaJefeDos);
	// ResultSet rsTres = Conexion.EjecutarSentencia(consultaJefeTres);

	ArrayList<turnoJugadorGetSet> meterRS = new ArrayList<turnoJugadorGetSet>();
	int sizeRSjefe = meterRS.size();

	ArrayList<equipamientoGetSet> meterRSEquipamiento = new ArrayList<equipamientoGetSet>();
	// turnoJugadorGetSet objetoJefe = new turnoJugadorGetSet(0, 0);

	public turnoJugador() {

		// JOptionPane.showMessageDialog(dado.getComponent(0),
		// "Has sacado " + dmgJugador + " , has quitado al JEFE " + dmgJugador + " de
		// vida");

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
				// rsUno.close();
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
				// rsDos.close();
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
				// rsTres.close();
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
				// rsTres.close();
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
				// rsTres.close();
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
				// rsTres.close();
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
				// rsUno.close();
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
				// rsDos.close();
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
				// rsTres.close();
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
				// rsTres.close();
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
				// rsTres.close();
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
				// rsTres.close();
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
				// rsUno.close();
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

	public void primerJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualUno = vidaActualUno - dmgTotalJugador;
		System.out.println(poderEquipamiento);
		AddBaseDeDatos(vidaActualUno, idJefeUno, nombreJefeUno);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualUno < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void segundoJefePantano() {

		// vidaActualDos = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualDos = vidaActualDos - dmgTotalJugador;
		AddBaseDeDatos(vidaActualDos, idJefeDos, nombreJefeDos);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualDos < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}
	}

	public void tercerJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualTres = vidaActualTres - dmgTotalJugador;
		AddBaseDeDatos(vidaActualTres, idJefeTres, nombreJefeTres);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualTres < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void cuartoJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualCuatro = vidaActualCuatro - dmgTotalJugador;
		AddBaseDeDatos(vidaActualCuatro, idJefeCuatro, nombreJefeCuatro);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualCuatro < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void quintoJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualCinco = vidaActualCinco - dmgTotalJugador;
		AddBaseDeDatos(vidaActualCinco, idJefeCinco, nombreJefeCinco);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualCinco < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void sextoJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualSeis = vidaActualSeis - dmgTotalJugador;
		AddBaseDeDatos(vidaActualSeis, idJefeSeis, nombreJefeSeis);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualSeis < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void septimoJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualSiete = vidaActualSiete - dmgTotalJugador;
		AddBaseDeDatos(vidaActualSiete, idJefeSiete, nombreJefeSiete);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualSiete < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void octavoJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualOcho = vidaActualOcho - dmgTotalJugador;
		AddBaseDeDatos(vidaActualOcho, idJefeOcho, nombreJefeOcho);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualOcho < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void novenoJefePantano() {

		// vidaActualDos = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualNueve = vidaActualNueve - dmgTotalJugador;
		AddBaseDeDatos(vidaActualNueve, idJefeNueve, nombreJefeNueve);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualNueve < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}
	}

	public void decimoJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualDiez = vidaActualDiez - dmgTotalJugador;
		AddBaseDeDatos(vidaActualDiez, idJefeDiez, nombreJefeDiez);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualDiez < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void undecimoJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualOnce = vidaActualOnce - dmgTotalJugador;
		AddBaseDeDatos(vidaActualOnce, idJefeOnce, nombreJefeOnce);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualOnce < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
			new Tienda();
			Tienda tiendaVisible = new Tienda();
			tiendaVisible.setVisible(true);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			close();

		}

	}

	public void duodecimoJefePantano() {
		// vidaActualUno = (Integer) meterRS.get(0).getVida();
		dmgTotalJugador = dmgJugador + poderEquipamiento;
		vidaActualDoce = vidaActualDoce - dmgTotalJugador;
		AddBaseDeDatos(vidaActualDoce, idJefeDoce, nombreJefeDoce);
		JOptionPane.showMessageDialog(dado.getComponent(0),
				"Has sacado " + dmgJugador + " de daño ,bonificación por arma: " + poderEquipamiento
						+ " , has quitado al JEFE " + dmgTotalJugador + " de vida");

		if (vidaActualDoce < 1) {
			JOptionPane.showMessageDialog(dado.getComponent(0), "El JEFE a muerto");
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

	public void logJugador() {
		// Jefe tiradaJefe = new Jefe();
		// int dmgJefe = tiradaJefe.tirarJefe();
		// String dmgStringJefe = String.valueOf(dmgJefe);
		int dmgJugador = tirada;
		int dmgTotalJugador = dmgJugador + poderEquipamiento;
		String dmgStringJugador = String.valueOf(dmgTotalJugador);

		try {

			// This block configure the logger with handler and formatter
			fh = new FileHandler("C:\\Users\\pablo\\eclipse-workspace\\WindowsBuilderTest\\src\\Log.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// the following statement is used to log any messages

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

}
