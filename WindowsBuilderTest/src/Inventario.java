import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;

import java.awt.event.*;

public class Inventario extends JFrame {

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

			// jt.setPreferredScrollableViewportSize(new Dimension(450, 63));
			// jt.setFillsViewportHeight(true);

			// JScrollPane jps = new JScrollPane(jt);
			// getContentPane().add(jps);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel(new ImageIcon("103127.png"));
		lblNewLabel.setBounds(73, 0, 335, 114);
		getContentPane().add(lblNewLabel);

		JLabel lblInventario = new JLabel("INVENTARIO");
		lblInventario.setBounds(113, 40, 78, 14);
		getContentPane().add(lblInventario);

		JLabel lblOro = new JLabel("ORO:");
		lblOro.setBounds(370, 40, 46, 14);
		getContentPane().add(lblOro);
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 11, 89, 23);
		getContentPane().add(btnVolver);

		jt = new JTable(tableModel);
		jt.setBounds(22, 255, 548, 490);
		getContentPane().add(jt);
		
		JButton btnEquipar = new JButton("EQUIPAR");
		btnEquipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBaseDeDatos(nombre.getText());
				jt.getModel();
				int i = jt.getSelectedRow();
				if ( i >= 0) {
					String seleccionar = (String) jt.getValueAt(i, 1);
					tableModel.removeRow(i);
					
					
				}
			}
		});
		btnEquipar.setBounds(90, 196, 120, 23);
		getContentPane().add(btnEquipar);
		
		JButton buttonDesequipar = new JButton("DESEQUIPAR");
		buttonDesequipar.setBounds(336, 196, 120, 23);
		getContentPane().add(buttonDesequipar);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(336, 230, 120, 20);
		getContentPane().add(textField);

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
		Conexion.conectar();
		Conexion.EjecutarUpdate("UPDATE inventario SET categoria = \"enfundado\" WHERE nombre = \"" + nombre + "\"");
	}
}