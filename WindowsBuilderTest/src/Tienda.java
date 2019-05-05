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
	String categoriaObjetoUno, categoriaObjetoDos, categoriaObjetoTres;
	String tipoObjetoUno, tipoObjetoDos, tipoObjetoTres;

	int oro = 200;
	String consultaObjetoUno = "SELECT * FROM items ORDER BY RAND() LIMIT 1";
	String consultaObjetoDos = "SELECT * FROM items ORDER BY RAND() LIMIT 1";
	String consultaObjetoTres = "SELECT * FROM items ORDER BY RAND() LIMIT 1";

	ArrayList<TiendaGetSet> meterRS = new ArrayList<TiendaGetSet>();
	int sizeRStienda = meterRS.size();
	// TiendaGetSet objetoTienda = new TiendaGetSet(0, 0, 0, 0, 0, 0);

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda windowT = new Tienda();
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
	public Tienda() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 596, 795);

		final JFrame dado = new JFrame();

		ResultSet rsUno = Conexion.EjecutarSentencia(consultaObjetoUno);
		try {

			while (rsUno.next()) {

				idObjetoUno = rsUno.getInt("id");
				nombreObjetoUno = rsUno.getString("nombre");
				poderObjetoUno = rsUno.getInt("poder");
				valorObjetoUno = rsUno.getInt("valor");
				categoriaObjetoUno = rsUno.getString("categoria");
				tipoObjetoUno = rsUno.getString("tipo");

				TiendaGetSet kUno = new TiendaGetSet(idObjetoUno, nombreObjetoUno, poderObjetoUno, valorObjetoUno,
						categoriaObjetoUno, tipoObjetoUno);

				meterRS.add(kUno);
				// rsUno.close();
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
				categoriaObjetoDos = rsDos.getString("categoria");
				tipoObjetoDos = rsDos.getString("tipo");

				TiendaGetSet kDos = new TiendaGetSet(idObjetoDos, nombreObjetoDos, poderObjetoDos, valorObjetoDos,
						categoriaObjetoDos, tipoObjetoDos);

				meterRS.add(kDos);
				// rsUno.close();
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
				categoriaObjetoTres = rsTres.getString("categoria");
				tipoObjetoTres = rsTres.getString("tipo");

				TiendaGetSet kTres = new TiendaGetSet(idObjetoTres, nombreObjetoTres, poderObjetoTres, valorObjetoTres,
						categoriaObjetoTres, tipoObjetoTres);

				meterRS.add(kTres);
				// rsUno.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		JButton btnNewButton = new JButton("COMPRAR OBJETO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (oro >= valorObjetoUno) {
					AddBaseDeDatos(idObjetoUno, nombreObjetoUno, poderObjetoUno, valorObjetoUno, categoriaObjetoUno,
							tipoObjetoUno);
				} else {
					System.out.println("NO TIENES EL ORO PARA COMPRAR ESE OBJETO");
					System.out.println("Tu oro actual: " + oro);
				}
			}

		});
		btnNewButton.setBounds(119, 293, 147, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("COMPRAR OBJETO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (oro >= valorObjetoDos) {
					AddBaseDeDatos(idObjetoDos, nombreObjetoDos, poderObjetoDos, valorObjetoDos, categoriaObjetoDos,
							tipoObjetoDos);
				} else {
					System.out.println("NO TIENES EL ORO PARA COMPRAR ESE OBJETO");
					System.out.println("Tu oro actual: " + oro);
				}
			}

		});
		btnNewButton_1.setBounds(119, 327, 147, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("COMPRAR OBJETO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (oro >= valorObjetoTres) {
					AddBaseDeDatos(idObjetoTres, nombreObjetoTres, poderObjetoTres, valorObjetoTres,
							categoriaObjetoTres, tipoObjetoTres);
				} else {
					System.out.println("NO TIENES EL ORO PARA COMPRAR ESE OBJETO");
					System.out.println("Tu oro actual: " + oro);
				}
			}

		});
		btnNewButton_2.setBounds(119, 363, 147, 23);
		getContentPane().add(btnNewButton_2);

		JLabel lblTiraParaVer = new JLabel("TIRA PARA VER SI HAY LEGENDARIO");
		lblTiraParaVer.setBounds(190, 492, 184, 14);
		getContentPane().add(lblTiraParaVer);

		JLabel lblTuOro = new JLabel("TU ORO: " + oro);
		lblTuOro.setBounds(361, 11, 119, 14);
		getContentPane().add(lblTuOro);

		JLabel lblBienvenidoALa = new JLabel("BIENVENIDO A LA TIENDA DE DO\u00D1A EUGENIA");
		lblBienvenidoALa.setBounds(23, 11, 243, 14);
		getContentPane().add(lblBienvenidoALa);

		JButton btnNewButton_4 = new JButton("INVENTARIO");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inventario nwInventario = new Inventario();
				nwInventario.NewScreen();

				// contentPane.setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new Inventario();
				Inventario inventarioVisible = new Inventario();
				inventarioVisible.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(440, 46, 130, 23);
		getContentPane().add(btnNewButton_4);

		JLabel lblInventario = new JLabel("INVENTARIO:");
		lblInventario.setBounds(361, 50, 69, 14);
		getContentPane().add(lblInventario);

		JLabel lblTeHaTocado = new JLabel("TE HA TOCADO: sampletext");
		lblTeHaTocado.setBounds(213, 587, 135, 14);
		getContentPane().add(lblTeHaTocado);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 80, 89, 23);
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

		JButton btnAadirObjetos = new JButton("A\u00D1ADIR OBJETOS");

		btnAadirObjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddObjetos nwAddObjetos = new AddObjetos();
				nwAddObjetos.NewScreen();

				// contentPane.setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new AddObjetos();
				AddObjetos addobjetosVisible = new AddObjetos();
				addobjetosVisible.setVisible(true);

				// getText recoge lo que hay en la casilla

			}

		});

		btnAadirObjetos.setBounds(71, 681, 135, 23);
		getContentPane().add(btnAadirObjetos);

		JButton btnQuitarObjetos = new JButton("QUITAR OBJETOS");
		btnQuitarObjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteObjetos nwDeleteObjetos = new DeleteObjetos();
				nwDeleteObjetos.NewScreen();

				// contentPane.setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new DeleteObjetos();
				DeleteObjetos deleteobjetosVisible = new DeleteObjetos();
				deleteobjetosVisible.setVisible(true);
			}

		});
		btnQuitarObjetos.setBounds(351, 681, 119, 23);
		getContentPane().add(btnQuitarObjetos);

		JButton btnContinuar = new JButton("CONTINUAR");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Continuar nwContinuar = new Continuar();
				nwContinuar.NewScreen();

				// contentPane.setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new Continuar();
				Continuar continuar = new Continuar();
				continuar.setVisible(true);
			}

		});
		btnContinuar.setBounds(234, 681, 89, 23);
		getContentPane().add(btnContinuar);

		JPanel topPanel = new JPanel();

		// final JLabel label = new JLabel("Hello World"); //

		// label.setVisible(false); //
		// frame.add(topPanel); //
		// topPanel.add(btnNewButton); //
		// topPanel.add(label); //
		// frame.setVisible(true); //

		int tirada = Dado.tirarDado(20);

		JButton btnNewButton_3 = new JButton("New button");

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Dado Tirada = new Dado();//
				// Tirada.tirarDado(6);//
				JOptionPane.showMessageDialog(dado.getComponent(0), "Has sacado un " + tirada);

			}
		});

		btnNewButton_3.setBounds(234, 540, 89, 23);
		getContentPane().add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("[ " +idObjetoUno + " " +nombreObjetoUno + " " + poderObjetoUno + " " + valorObjetoUno + " " + categoriaObjetoUno +
			" " +	tipoObjetoUno + " ]");
		

		lblNewLabel.setBounds(302, 297, 229, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(302, 331, 46, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(302, 367, 46, 14);
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
		return categoriaObjetoUno;
	}

	public void setCategoriaObjetoUno(String categoriaObjetoUno) {
		this.categoriaObjetoUno = categoriaObjetoUno;
	}

	public String getCategoriaObjetoDos() {
		return categoriaObjetoDos;
	}

	public void setCategoriaObjetoDos(String categoriaObjetoDos) {
		this.categoriaObjetoDos = categoriaObjetoDos;
	}

	public String getCategoriaObjetoTres() {
		return categoriaObjetoTres;
	}

	public void setCategoriaObjetoTres(String categoriaObjetoTres) {
		this.categoriaObjetoTres = categoriaObjetoTres;
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
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public void AddBaseDeDatos(int id, String nombre, int poder, int valor, String categoria, String tipo) {

		Conexion.conectar();

		Conexion.EjecutarUpdate("INSERT INTO inventario VALUES (\"" + id + "\",\"" + nombre + "\",\"" + poder + "\",\""
				+ valor + "\",\"" + categoria + "\",\"" + tipo + "\")");

	}
}
