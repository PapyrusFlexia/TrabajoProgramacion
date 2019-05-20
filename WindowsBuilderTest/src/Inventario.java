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
	String categoriaInventario;
	String tipoInventario;
	String idInventarioStr;
	String poderInventarioStr;
	String valorInventarioStr;
	private JTextField nombre;
	private JTable jt;
	ArrayList<TiendaGetSet> meterRS = new ArrayList<TiendaGetSet>();
	int sizeRStienda = meterRS.size();

	String query = "SELECT * FROM inventario";
	String[] columnas = { "ID", "NOMBRE", "PODER", "VALOR", "CATEGORÍA", "TIPO" };
	DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);

	private JTextField textField;

	/**
	 * Launch the application.
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

	/**
	 * Create the frame.
	 */
	public Inventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);

		nombre = new JTextField();
		nombre.setBounds(90, 230, 120, 20);
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
				categoriaInventario = rs.getString("categoria");
				tipoInventario = rs.getString("tipo");

				TiendaGetSet k = new TiendaGetSet(idInventario, nombreInventario, poderInventario, valorInventario,
						categoriaInventario, tipoInventario);

				meterRS.add(k);

				String[] data = { idInventarioStr, nombreInventario, poderInventarioStr, valorInventarioStr,
						categoriaInventario, tipoInventario };

				tableModel.addRow(data);

			}
			// jt = new JTable(tableModel);
			// jt.setBounds(30, 461, 488, -161);
			// jt.setVisible(true);
			// getContentPane().add(jt);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		jt = new JTable(tableModel);
		getContentPane().add(jt.getTableHeader(), BorderLayout.NORTH);
		getContentPane().add(jt, BorderLayout.CENTER);
		jt.setBounds(22, 255, 548, 490);
		getContentPane().add(jt);
		// JScrollPane jps = new JScrollPane(jt);
		// getContentPane().add(jps);

		JLabel lblNewLabel = new JLabel(new ImageIcon("103127.png"));
		lblNewLabel.setBounds(73, 0, 335, 114);
		getContentPane().add(lblNewLabel);

		JLabel lblInventario = new JLabel("INVENTARIO");
		lblInventario.setBounds(242, 15, 78, 14);
		getContentPane().add(lblInventario);

		JLabel lblOro = new JLabel("ORO:");
		lblOro.setBounds(113, 69, 46, 14);
		getContentPane().add(lblOro);
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 11, 89, 23);
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
		btnEquipar.setBounds(90, 196, 120, 23);
		getContentPane().add(btnEquipar);

		JButton btnDesequipar = new JButton("DESEQUIPAR");
		btnDesequipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBaseDeDatos(nombre.getText(), categoriaInventario);
				jt.getModel();
				int i = jt.getSelectedRow();
				if (i >= 0) {
					String deseleccionar = (String) jt.getValueAt(i, 1);
					tableModel.removeRow(i);
					AddBaseDeDatos(deseleccionar);

				}
			}
		});
		btnDesequipar.setBounds(319, 196, 120, 23);
		getContentPane().add(btnDesequipar);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(319, 230, 120, 20);
		getContentPane().add(textField);

		JButton btnNewButton = new JButton("ORDENAR ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarId();
			}
		});
		btnNewButton.setBounds(342, 50, 89, 23);
		getContentPane().add(btnNewButton);

		JButton button = new JButton("ORDENAR NOMBRE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarNombre();
			}
		});

		button.setBounds(342, 84, 89, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("ORDENAR PODER");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarPoder();
			}
		});
		button_1.setBounds(342, 119, 89, 23);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("ORDENAR VALOR");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarValor();
			}
		});
		button_2.setBounds(441, 50, 89, 23);
		getContentPane().add(button_2);

		JButton button_3 = new JButton("ORDENAR CATEGORÍA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarCategoria();
			}
		});
		button_3.setBounds(441, 84, 89, 23);
		getContentPane().add(button_3);

		JButton button_4 = new JButton("ORDENAR TIPO");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarTipo();
			}
		});
		button_4.setBounds(441, 119, 89, 23);
		getContentPane().add(button_4);

		// table = new JTable();
		// table.setBounds(170, 479, 292, 216);
		// getContentPane().add(table);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tienda();
				Tienda tiendaVisible = new Tienda();
				tiendaVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});

	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	}

	public static void AddBaseDeDatos(String nombre) {

		Conexion.EjecutarUpdate("UPDATE inventario SET categoria = \"enfundado\" WHERE nombre = \"" + nombre + "\"");
	}

	public static void DeleteBaseDeDatos(String nombre, String categoria) {

		Conexion.EjecutarUpdate(
				"UPDATE inventario SET categoria = \" desenfundado \"  WHERE nombre = \"" + nombre + "\"");
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

	public void ordenarCategoria() {

		Conexion.EjecutarUpdate("ALTER TABLE inventario ORDER BY categoria ASC");

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