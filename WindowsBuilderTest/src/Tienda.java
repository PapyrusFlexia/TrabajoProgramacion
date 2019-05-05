import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;

public class Tienda extends JFrame {

	private JFrame frame;

	int valorObjetoUno, valorObjetoDos, valorObjetoTres;
	int idObjetoUno, idObjetoDos, idObjetoTres;
	int oro = 200;
	String consultaObjetoUno = "SELECT * FROM items ORDER BY RAND() LIMIT 1";
	String consultaObjetoDos = "SELECT * FROM items ORDER BY RAND() LIMIT 1";
	String consultaObjetoTres = "SELECT * FROM items ORDER BY RAND() LIMIT 1";

	ArrayList<TiendaGetSet> meterRS = new ArrayList<TiendaGetSet>();
	int sizeRStienda = meterRS.size();
	TiendaGetSet objetoTienda = new TiendaGetSet(0, 0);

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

				valorObjetoUno = rsUno.getInt("valor");
				idObjetoUno = rsUno.getInt("id");

				TiendaGetSet kUno = new TiendaGetSet(valorObjetoUno, idObjetoUno);

				meterRS.add(kUno);
				// rsUno.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsDos = Conexion.EjecutarSentencia(consultaObjetoDos);
		try {

			while (rsDos.next()) {

				valorObjetoDos = rsDos.getInt("valor");
				idObjetoDos = rsUno.getInt("id");

				TiendaGetSet kDos = new TiendaGetSet(valorObjetoDos, idObjetoDos);

				meterRS.add(kDos);
				// rsUno.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet rsTres = Conexion.EjecutarSentencia(consultaObjetoTres);
		try {

			while (rsTres.next()) {

				valorObjetoTres = rsTres.getInt("valor");
				idObjetoTres = rsUno.getInt("id");

				TiendaGetSet kTres = new TiendaGetSet(valorObjetoTres, idObjetoTres);

				meterRS.add(kTres);
				// rsUno.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		JButton btnNewButton = new JButton("COMPRAR OBJETO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (oro >= valorObjetoUno ) {
					
				} else {
					System.out.println("NO TIENES EL ORO PARA COMPRAR ESE OBJETO");
				}
			}

		});
		btnNewButton.setBounds(155, 293, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(155, 327, 89, 23);
		getContentPane().add(btnNewButton_1);



		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(155, 363, 89, 23);
		getContentPane().add(btnNewButton_2);

		JLabel lblTiraParaVer = new JLabel("TIRA PARA VER SI HAY LEGENDARIO");
		lblTiraParaVer.setBounds(190, 492, 184, 14);
		getContentPane().add(lblTiraParaVer);

		JLabel lblTuOro = new JLabel("TU ORO: " + oro);
		lblTuOro.setBounds(430, 11, 119, 14);
		getContentPane().add(lblTuOro);

		JLabel lblBienvenidoALa = new JLabel("BIENVENIDO A LA TIENDA DE DO\u00D1A EUGENIA");
		lblBienvenidoALa.setBounds(10, 11, 243, 14);
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
		btnNewButton_4.setBounds(481, 46, 89, 23);
		getContentPane().add(btnNewButton_4);

		JLabel lblInventario = new JLabel("INVENTARIO:");
		lblInventario.setBounds(407, 50, 69, 14);
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

		JLabel lblTiraElDado = new JLabel("TIRA EL DADO");
		lblTiraElDado.setBounds(180, 11, 79, 14);
		getContentPane().add(lblTiraElDado);

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

	public void AddBaseDeDatos(String id, String nombre, String poder, String valor, String categoria, String tipo) {

		Conexion.conectar();

		Conexion.EjecutarUpdate("INSERT INTO inventario VALUES (\"" + id + "\",\"" + nombre + "\",\"" + poder + "\",\""
				+ valor + "\",\"" + categoria + "\",\"" + tipo + "\")");

	}
}
