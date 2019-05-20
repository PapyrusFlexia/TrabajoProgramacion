import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BBDD.Conexion;

import java.awt.event.*;

public class Inventario extends JFrame {

	private JFrame frame;
	int idInventario;
	String nombreInventario;
	int poderInventario;
	int valorInventario;
	String estadoInventario;
	String tipoInventario;
	String idInventarioStr;
	String poderInventarioStr;
	String valorInventarioStr;
	private JTextField nombre;
	private JTable jt;
	int oro;
	ArrayList<TiendaGetSet> meterRS = new ArrayList<TiendaGetSet>();
	int sizeRStienda = meterRS.size();
	
	String consultaOro = "SELECT oro FROM jugadores WHERE id = \"1\"";

	ArrayList<jugadorGetSet> meterRSoro = new ArrayList<jugadorGetSet>();
	
	String query = "SELECT * FROM inventario";
	String[] columnas = { "ID", "NOMBRE", "PODER", "VALOR", "CATEGORÍA", "TIPO" };
	DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);

	private JTextField textField;

	/**
	 * para poder abrir esta pestaña
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario windowI = new Inventario();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/** para poder equipar las armas y armaduras que te encuentras en la base de datos y ver todas las que tienes, incluyendo el oro **/
	 
	public Inventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 143, 700, 795);
		getContentPane().setLayout(null);
		
		JLabel inventario = new JLabel(new ImageIcon("Inventario.png"));
		inventario.setBounds(111, 11, 511, 85);
		getContentPane().add(inventario);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("103127.png"));
		lblNewLabel.setBounds(191, 22, 335, 114);
		getContentPane().add(lblNewLabel);

		Toolkit marco = Toolkit.getDefaultToolkit();

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);
		setTitle("Cells&Chameleons");

		nombre = new JTextField();
		nombre.setBounds(178, 230, 120, 20);
		getContentPane().add(nombre);
		nombre.setColumns(10);

		ResultSet rs = Conexion.EjecutarSentencia(query);
		tableModel.addRow(columnas);

		try {

			while (rs.next()) {
				idInventario = rs.getInt("id");
				idInventarioStr = String.valueOf(idInventario);
				nombreInventario = rs.getString("nombre");
				poderInventario = rs.getInt("poder");
				poderInventarioStr = String.valueOf(poderInventario);
				valorInventario = rs.getInt("valor");
				valorInventarioStr = String.valueOf(valorInventario);
				estadoInventario = rs.getString("estado");
				tipoInventario = rs.getString("tipo");

				TiendaGetSet k = new TiendaGetSet(idInventario, nombreInventario, poderInventario, valorInventario,
						estadoInventario, tipoInventario);

				meterRS.add(k);

				String[] data = { idInventarioStr, nombreInventario, poderInventarioStr, valorInventarioStr,
						estadoInventario, tipoInventario };

				tableModel.addRow(data);

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

		jt = new JTable(tableModel);
		getContentPane().add(jt.getTableHeader(), BorderLayout.NORTH);
		getContentPane().add(jt, BorderLayout.CENTER);
		jt.setBounds(22, 255, 652, 490);
		jt.setEnabled(false);
		getContentPane().add(jt);
	

	

	

		JLabel lblOro = new JLabel("ORO: " + oro);
		lblOro.setBounds(96, 107, 78, 14);
		getContentPane().add(lblOro);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(559, 11, 101, 23);
		getContentPane().add(btnVolver);

		JButton btnEquipar = new JButton("EQUIPAR");
		btnEquipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBaseDeDatos(nombre.getText());
				jt.getModel();
				int i = jt.getSelectedRow();
				if (i >= 0) {
					String seleccionar = (String) jt.getValueAt(i, 1);
					tableModel.removeRow(i);
					AddBaseDeDatos(seleccionar);

				}
			}
		});
		btnEquipar.setBounds(178, 196, 120, 23);
		getContentPane().add(btnEquipar);

		JButton btnDesequipar = new JButton("DESEQUIPAR");
		btnDesequipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBaseDeDatos(nombre.getText(), estadoInventario);
				jt.getModel();
				int i = jt.getSelectedRow();
				if (i >= 0) {
					String deseleccionar = (String) jt.getValueAt(i, 1);
					tableModel.removeRow(i);
					AddBaseDeDatos(deseleccionar);

				}
			}
		});
		btnDesequipar.setBounds(406, 196, 120, 23);
		getContentPane().add(btnDesequipar);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(406, 230, 120, 20);
		getContentPane().add(textField);


		JButton btnNewButton = new JButton("ORDENAR ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarId();
			}
		});
		btnNewButton.setBounds(100, 125, 127, 23);
		getContentPane().add(btnNewButton);

		JButton button = new JButton("ORDENAR NOMBRE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarNombre();
			}
		});

		button.setBounds(272, 125, 167, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("ORDENAR PODER");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarPoder();
			}
		});
		button_1.setBounds(489, 125, 133, 23);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("ORDENAR VALOR");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarValor();
			}
		});
		button_2.setBounds(489, 159, 133, 23);
		getContentPane().add(button_2);

		JButton button_3 = new JButton("ORDENAR ESTADO");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarEstado();
			}
		});
		button_3.setBounds(272, 162, 167, 23);
		getContentPane().add(button_3);

		JButton button_4 = new JButton("ORDENAR TIPO");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarTipo();
			}
		});
		button_4.setBounds(100, 162, 127, 23);
		getContentPane().add(button_4);


		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tienda();
				Tienda tiendaVisible = new Tienda();
				tiendaVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();
				
				dispose();

			}

		});

	}

	

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	}

	/**
	 * cambia el estado del arma a equipado
	 * @param nombre
	 */
	public static void AddBaseDeDatos(String nombre) {

		Conexion.EjecutarUpdate("UPDATE inventario SET estado = \"equipado\" WHERE nombre = \"" + nombre + "\"");
	}
/**
 * cambia el estado del arma a desequipado
 * @param nombre
 * @param estado
 */
	public static void DeleteBaseDeDatos(String nombre, String estado) {

		Conexion.EjecutarUpdate(
				"UPDATE inventario SET estado = \" desequipado \"  WHERE nombre = \"" + nombre + "\"");
	}

	public void ordenarId() {

		Conexion.EjecutarUpdate("ALTER TABLE inventario ORDER BY id ASC");

		Inventario actualizar = new Inventario();
		actualizar.setVisible(true);

		dispose();

	}

	public void ordenarNombre() {

		Conexion.EjecutarUpdate("ALTER TABLE inventario ORDER BY nombre ASC");

		Inventario actualizar = new Inventario();
		actualizar.setVisible(true);

		dispose();
	}

	public void ordenarPoder() {

		Conexion.EjecutarUpdate("ALTER TABLE inventario ORDER BY poder ASC");

		Inventario actualizar = new Inventario();
		actualizar.setVisible(true);

		dispose();
	}

	public void ordenarValor() {

		Conexion.EjecutarUpdate("ALTER TABLE inventario ORDER BY valor ASC");

		Inventario actualizar = new Inventario();
		actualizar.setVisible(true);

		dispose();
	}

	public void ordenarEstado() {

		Conexion.EjecutarUpdate("ALTER TABLE inventario ORDER BY estado ASC");

		Inventario actualizar = new Inventario();
		actualizar.setVisible(true);

		dispose();
	}

	public void ordenarTipo() {

		Conexion.EjecutarUpdate("ALTER TABLE inventario ORDER BY tipo ASC");

		Inventario actualizar = new Inventario();
		actualizar.setVisible(true);

		dispose();
	}
}