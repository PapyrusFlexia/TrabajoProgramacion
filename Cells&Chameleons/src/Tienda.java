import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Tienda extends JFrame {

	private JFrame frame;

	int idObjetoUno, idObjetoDos, idObjetoTres;
	String nombreObjetoUno, nombreObjetoDos, nombreObjetoTres;
	int poderObjetoUno, poderObjetoDos, poderObjetoTres;
	int valorObjetoUno, valorObjetoDos, valorObjetoTres;
	String estadoObjetoUno, estadoObjetoDos, estadoObjetoTres;
	String tipoObjetoUno, tipoObjetoDos, tipoObjetoTres;
	int oro;

	String consultaObjetoUno = "SELECT * FROM items ORDER BY RAND() LIMIT 1";
	String consultaObjetoDos = "SELECT * FROM items ORDER BY RAND() LIMIT 1";
	String consultaObjetoTres = "SELECT * FROM items ORDER BY RAND() LIMIT 1";
	String consultaOro = "SELECT oro FROM jugadores WHERE id = \"1\"";

	ArrayList<TiendaGetSet> meterRS = new ArrayList<TiendaGetSet>();
	ArrayList<jugadorGetSet> meterRSoro = new ArrayList<jugadorGetSet>();
	int sizeRStienda = meterRS.size();

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda windowT = new Tienda();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	/** te permite comprar de objetos aleatorios y añadirlos a la tabla inventario **/
	 

	public Tienda() {
		getContentPane().setLayout(null);
		setBounds(120, 143, 596, 795);

		Toolkit marco = Toolkit.getDefaultToolkit();
		
		JLabel tienda = new JLabel(new ImageIcon("Tienda.png"));
		tienda.setBounds(0, 7, 580, 85);
		getContentPane().add(tienda);

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);
		setTitle("Cells&Chameleons");

		final JFrame dado = new JFrame();

		ResultSet rsUno = Conexion.EjecutarSentencia(consultaObjetoUno);
		try {

			while (rsUno.next()) {

				idObjetoUno = rsUno.getInt("id");
				nombreObjetoUno = rsUno.getString("nombre");
				poderObjetoUno = rsUno.getInt("poder");
				valorObjetoUno = rsUno.getInt("valor");
				estadoObjetoUno = rsUno.getString("estado");
				tipoObjetoUno = rsUno.getString("tipo");

				TiendaGetSet kUno = new TiendaGetSet(idObjetoUno, nombreObjetoUno, poderObjetoUno, valorObjetoUno,
						estadoObjetoUno, tipoObjetoUno);

				meterRS.add(kUno);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsDos = Conexion.EjecutarSentencia(consultaObjetoDos);
		try {

			while (rsDos.next()) {

				idObjetoDos = rsDos.getInt("id");
				nombreObjetoDos = rsDos.getString("nombre");
				poderObjetoDos = rsDos.getInt("poder");
				valorObjetoDos = rsDos.getInt("valor");
				estadoObjetoDos = rsDos.getString("estado");
				tipoObjetoDos = rsDos.getString("tipo");

				TiendaGetSet kDos = new TiendaGetSet(idObjetoDos, nombreObjetoDos, poderObjetoDos, valorObjetoDos,
						estadoObjetoDos, tipoObjetoDos);

				meterRS.add(kDos);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsTres = Conexion.EjecutarSentencia(consultaObjetoTres);
		try {

			while (rsTres.next()) {

				idObjetoTres = rsTres.getInt("id");
				nombreObjetoTres = rsTres.getString("nombre");
				poderObjetoTres = rsTres.getInt("poder");
				valorObjetoTres = rsTres.getInt("valor");
				estadoObjetoTres = rsTres.getString("estado");
				tipoObjetoTres = rsTres.getString("tipo");

				TiendaGetSet kTres = new TiendaGetSet(idObjetoTres, nombreObjetoTres, poderObjetoTres, valorObjetoTres,
						estadoObjetoTres, tipoObjetoTres);

				meterRS.add(kTres);

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

		JLabel lblNewLabelTienda = new JLabel(new ImageIcon("Tienda.gif"));

		lblNewLabelTienda.setBounds(0, 86, 560, 330);
		getContentPane().add(lblNewLabelTienda);

		JLabel lblTuOro = new JLabel("TU ORO: " + oro);
		lblTuOro.setBounds(256, 424, 119, 14);
		getContentPane().add(lblTuOro);

		JButton btnNewButton = new JButton("COMPRAR OBJETO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (oro >= valorObjetoUno) {
					AddBaseDeDatos(idObjetoUno, nombreObjetoUno, poderObjetoUno, valorObjetoUno, estadoObjetoUno,
							tipoObjetoUno);

					oro = oro - valorObjetoUno;

					String oroStr = Integer.toString(oro);

					lblTuOro.setText("TU ORO: " + oroStr);

					AddBaseDeDatosOro(oro);

				} else {
					System.out.println("NO TIENES EL ORO PARA COMPRAR ESE OBJETO");
					System.out.println("Tu oro actual: " + oro);
				}
			}

		});
		btnNewButton.setBounds(23, 459, 147, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("COMPRAR OBJETO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (oro >= valorObjetoDos) {
					AddBaseDeDatos(idObjetoDos, nombreObjetoDos, poderObjetoDos, valorObjetoDos, estadoObjetoDos,
							tipoObjetoDos);

					oro = oro - valorObjetoDos;

					String oroStr = Integer.toString(oro);

					lblTuOro.setText("TU ORO: " + oroStr);

					AddBaseDeDatosOro(oro);

				} else {
					System.out.println("NO TIENES EL ORO PARA COMPRAR ESE OBJETO");
					System.out.println("Tu oro actual: " + oro);
				}
			}

		});
		btnNewButton_1.setBounds(23, 493, 147, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("COMPRAR OBJETO");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (oro >= valorObjetoTres) {
					AddBaseDeDatos(idObjetoTres, nombreObjetoTres, poderObjetoTres, valorObjetoTres,
							estadoObjetoTres, tipoObjetoTres);

					oro = oro - valorObjetoTres;

					String oroStr = Integer.toString(oro);

					lblTuOro.setText("TU ORO: " + oroStr);

					AddBaseDeDatosOro(oro);

				} else {
					System.out.println("NO TIENES EL ORO PARA COMPRAR ESE OBJETO");
					System.out.println("Tu oro actual: " + oro);
				}
			}

		});
		btnNewButton_2.setBounds(23, 527, 147, 23);
		getContentPane().add(btnNewButton_2);

		

		JButton btnNewButton_4 = new JButton("INVENTARIO");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inventario nwInventario = new Inventario();
				nwInventario.NewScreen();

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new Inventario();
				Inventario inventarioVisible = new Inventario();
				inventarioVisible.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(23, 420, 130, 23);
		getContentPane().add(btnNewButton_4);

		

		JButton btnAadirObjetos = new JButton("A\u00D1ADIR OBJETOS");

		btnAadirObjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddObjetos nwAddObjetos = new AddObjetos();
				nwAddObjetos.NewScreen();

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new AddObjetos();
				AddObjetos addobjetosVisible = new AddObjetos();
				addobjetosVisible.setVisible(true);

			}

		});

		btnAadirObjetos.setBounds(20, 681, 135, 23);
		getContentPane().add(btnAadirObjetos);

		JButton btnQuitarObjetos = new JButton("QUITAR OBJETOS");
		btnQuitarObjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteObjetos nwDeleteObjetos = new DeleteObjetos();
				nwDeleteObjetos.NewScreen();

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new DeleteObjetos();
				DeleteObjetos deleteobjetosVisible = new DeleteObjetos();
				deleteobjetosVisible.setVisible(true);
			}

		});
		btnQuitarObjetos.setBounds(423, 681, 135, 23);
		getContentPane().add(btnQuitarObjetos);

		JButton btnContinuar = new JButton("CONTINUAR");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Continuar nwContinuar = new Continuar();
				nwContinuar.NewScreen();

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new Continuar();
				Continuar continuar = new Continuar();
				continuar.setVisible(true);
			}

		});
		btnContinuar.setBounds(227, 681, 119, 23);
		getContentPane().add(btnContinuar);

		JPanel topPanel = new JPanel();

		int tirada = Dado.tirarDado(20);

		JLabel lblNewLabel = new JLabel("[ NOMBRE: " + nombreObjetoUno + " | PODER: " + poderObjetoUno + " | VALOR: "
				+ valorObjetoUno + " | TIPO: " + tipoObjetoUno + " ]");

		lblNewLabel.setBounds(180, 463, 494, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("[ NOMBRE: " + nombreObjetoDos + " | PODER: " + poderObjetoDos + " | VALOR: "
				+ valorObjetoDos + " | TIPO: " + tipoObjetoDos + " ]");
		lblNewLabel_1.setBounds(180, 497, 494, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("[ NOMBRE: " + nombreObjetoTres + " | PODER: " + poderObjetoTres + " | VALOR: "
				+ valorObjetoTres + " | TIPO: " + tipoObjetoTres + " ]");
		lblNewLabel_2.setBounds(180, 531, 494, 14);
		getContentPane().add(lblNewLabel_2);

	}

	public int getIdObjetoUno() {
		return idObjetoUno;
	}

	public void setIdObjetoUno(int idObjetoUno) {
		this.idObjetoUno = idObjetoUno;
	}

	public int getIdObjetoDos() {
		return idObjetoDos;
	}

	public void setIdObjetoDos(int idObjetoDos) {
		this.idObjetoDos = idObjetoDos;
	}

	public int getIdObjetoTres() {
		return idObjetoTres;
	}

	public void setIdObjetoTres(int idObjetoTres) {
		this.idObjetoTres = idObjetoTres;
	}

	public String getNombreObjetoUno() {
		return nombreObjetoUno;
	}

	public void setNombreObjetoUno(String nombreObjetoUno) {
		this.nombreObjetoUno = nombreObjetoUno;
	}

	public String getNombreObjetoDos() {
		return nombreObjetoDos;
	}

	public void setNombreObjetoDos(String nombreObjetoDos) {
		this.nombreObjetoDos = nombreObjetoDos;
	}

	public String getNombreObjetoTres() {
		return nombreObjetoTres;
	}

	public void setNombreObjetoTres(String nombreObjetoTres) {
		this.nombreObjetoTres = nombreObjetoTres;
	}

	public int getPoderObjetoUno() {
		return poderObjetoUno;
	}

	public void setPoderObjetoUno(int poderObjetoUno) {
		this.poderObjetoUno = poderObjetoUno;
	}

	public int getPoderObjetoDos() {
		return poderObjetoDos;
	}

	public void setPoderObjetoDos(int poderObjetoDos) {
		this.poderObjetoDos = poderObjetoDos;
	}

	public int getPoderObjetoTres() {
		return poderObjetoTres;
	}

	public void setPoderObjetoTres(int poderObjetoTres) {
		this.poderObjetoTres = poderObjetoTres;
	}

	public int getValorObjetoUno() {
		return valorObjetoUno;
	}

	public void setValorObjetoUno(int valorObjetoUno) {
		this.valorObjetoUno = valorObjetoUno;
	}

	public int getValorObjetoDos() {
		return valorObjetoDos;
	}

	public void setValorObjetoDos(int valorObjetoDos) {
		this.valorObjetoDos = valorObjetoDos;
	}

	public int getValorObjetoTres() {
		return valorObjetoTres;
	}

	public void setValorObjetoTres(int valorObjetoTres) {
		this.valorObjetoTres = valorObjetoTres;
	}

	public String getCategoriaObjetoUno() {
		return estadoObjetoUno;
	}

	public void setCategoriaObjetoUno(String categoriaObjetoUno) {
		this.estadoObjetoUno = categoriaObjetoUno;
	}

	public String getCategoriaObjetoDos() {
		return estadoObjetoDos;
	}

	public void setCategoriaObjetoDos(String categoriaObjetoDos) {
		this.estadoObjetoDos = categoriaObjetoDos;
	}

	public String getCategoriaObjetoTres() {
		return estadoObjetoTres;
	}

	public void setCategoriaObjetoTres(String categoriaObjetoTres) {
		this.estadoObjetoTres = categoriaObjetoTres;
	}

	public String getTipoObjetoUno() {
		return tipoObjetoUno;
	}

	public void setTipoObjetoUno(String tipoObjetoUno) {
		this.tipoObjetoUno = tipoObjetoUno;
	}

	public String getTipoObjetoDos() {
		return tipoObjetoDos;
	}

	public void setTipoObjetoDos(String tipoObjetoDos) {
		this.tipoObjetoDos = tipoObjetoDos;
	}

	public String getTipoObjetoTres() {
		return tipoObjetoTres;
	}

	public void setTipoObjetoTres(String tipoObjetoTres) {
		this.tipoObjetoTres = tipoObjetoTres;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * se inserta en el inventario los objetos comprados
	 * @param id
	 * @param nombre
	 * @param poder
	 * @param valor
	 * @param categoria
	 * @param tipo
	 */
	public void AddBaseDeDatos(int id, String nombre, int poder, int valor, String estado, String tipo) {

		Conexion.conectar();

		Conexion.EjecutarUpdate("INSERT INTO inventario VALUES (\"" + id + "\",\"" + nombre + "\",\"" + poder + "\",\""
				+ valor + "\",\"" + estado + "\",\"" + tipo + "\")");

	}
	
	/**
	 * se actualiza el oro
	 * @param oro
	 */

	public void AddBaseDeDatosOro(int oro) {

		Conexion.EjecutarUpdate("UPDATE jugadores SET oro =" + oro + "");

	}
}
