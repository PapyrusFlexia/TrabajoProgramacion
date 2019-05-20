import java.sql.*;
import java.text.NumberFormat;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;
import java.io.File;

public class CreacionPersonajes extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textFieldid;
	private JTextField vidatotalfield;
	int VidaTotal = Dado.tirarDado(7) + 4;
	int oro = 100;
	String atkInicial = "1d4";
	static int cambiarPj;

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreacionPersonajes window = new CreacionPersonajes();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	/** para crear un personaje, añadirlo a la base de datos y borrar el anterior **/

	public CreacionPersonajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 143, 596, 795);
		getContentPane().setLayout(null);

		JLabel lblNewLabelP = new JLabel(new ImageIcon("Personaje.png"));
		lblNewLabelP.setBounds(0, 11, 605, 85);
		getContentPane().add(lblNewLabelP);

		JButton lblNewLabel = new JButton(new ImageIcon("Humano.gif"));
		lblNewLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPj = 1;
			

			}

		});

		lblNewLabel.setBounds(21, 378, 157, 250);
		lblNewLabel.setOpaque(false);
		lblNewLabel.setContentAreaFilled(false);
		lblNewLabel.setBorderPainted(false);
		getContentPane().add(lblNewLabel);

		JButton lblNewLabel2 = new JButton(new ImageIcon("Lizardmen.gif"));
		lblNewLabel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPj = 2;
				
			}

		});
		lblNewLabel2.setBounds(148, 390, 157, 250);
		lblNewLabel2.setOpaque(false);
		lblNewLabel2.setContentAreaFilled(false);
		lblNewLabel2.setBorderPainted(false);
		getContentPane().add(lblNewLabel2);

		JButton lblNewLabel3 = new JButton(new ImageIcon("Elfo.gif"));
		lblNewLabel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPj = 3;
				
			}

		});
		lblNewLabel3.setBounds(285, 380, 157, 250);
		lblNewLabel3.setOpaque(false);
		lblNewLabel3.setContentAreaFilled(false);
		lblNewLabel3.setBorderPainted(false);
		getContentPane().add(lblNewLabel3);

		JButton lblNewLabel4 = new JButton(new ImageIcon("Enano.gif"));
		lblNewLabel4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPj = 4;
			
			}

		});
		lblNewLabel4.setBounds(413, 340, 157, 250);
		lblNewLabel4.setOpaque(false);
		lblNewLabel4.setContentAreaFilled(false);
		lblNewLabel4.setBorderPainted(false);
		getContentPane().add(lblNewLabel4);
		
		

		Toolkit marco = Toolkit.getDefaultToolkit();

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);
		setTitle("Cells&Chameleons");

		textField = new JTextField();

		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!((c >= 'a') && (c <= 'z') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});

		textField.setBounds(193, 179, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textFieldid = new JTextField("001");
		textFieldid.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		textFieldid.setBounds(193, 124, 86, 20);
		getContentPane().add(textFieldid);
		textFieldid.setEditable(false);
		textFieldid.setColumns(10);

		JLabel lblid = new JLabel("id");
		lblid.setBounds(56, 127, 46, 14);
		getContentPane().add(lblid);

		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(56, 182, 46, 14);
		getContentPane().add(lblNombre);

		JLabel lblValor = new JLabel("ataque");
		lblValor.setBounds(56, 295, 46, 14);
		getContentPane().add(lblValor);

		JLabel lblTipo = new JLabel("vida total");
		lblTipo.setBounds(56, 353, 65, 14);
		getContentPane().add(lblTipo);

		JLabel vidaActual = new JLabel();
		vidaActual.setBounds(193, 247, 129, 14);
		getContentPane().add(vidaActual);

		JLabel label_2 = new JLabel("1d4");
		label_2.setBounds(193, 295, 46, 14);
		getContentPane().add(label_2);

		JLabel vidatotalfield = new JLabel();
		vidatotalfield.setBounds(193, 343, 183, 20);
		getContentPane().add(vidatotalfield);

		final JFrame dado = new JFrame();

		JButton btnCrear = new JButton("CONTINUAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteBaseDeDatos();
				AddBaseDeDatos(textFieldid.getText(), textField.getText(), VidaTotal, atkInicial, VidaTotal, oro); 

				Interfaz nwc = new Interfaz();

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				nwc.setVisible(true);

				dispose();

			}

		});
		btnCrear.setBounds(231, 638, 129, 50);
		btnCrear.setEnabled(false);
		getContentPane().add(btnCrear);

		JButton btndParaTu = new JButton("1d8 para tu vida");
		btndParaTu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(dado.getComponent(0), "Has sacado un " + VidaTotal);
				vidatotalfield.setText("Tienes " + VidaTotal + " de vida total");
				vidaActual.setText("Tienes " + VidaTotal + " de vida actual");
				
				btnCrear.setEnabled(true);

			}
		});

		btndParaTu.setBounds(21, 238, 144, 23);
		getContentPane().add(btndParaTu);

		

	}
	
	/** para coger el ID de la raza que hallamos elegido **/
	public void cogerId() {
		JButton lblNewLabel = new JButton(new ImageIcon("Humano.gif"));
		lblNewLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPj = 1;
				

			}

		});

		lblNewLabel.setBounds(21, 378, 157, 250);
		lblNewLabel.setOpaque(false);
		lblNewLabel.setContentAreaFilled(false);
		lblNewLabel.setBorderPainted(false);
		getContentPane().add(lblNewLabel);

		JButton lblNewLabel2 = new JButton(new ImageIcon("Lizardmen.gif"));
		lblNewLabel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPj = 2;
				
			}

		});
		lblNewLabel2.setBounds(148, 390, 157, 250);
		lblNewLabel2.setOpaque(false);
		lblNewLabel2.setContentAreaFilled(false);
		lblNewLabel2.setBorderPainted(false);
		getContentPane().add(lblNewLabel2);

		JButton lblNewLabel3 = new JButton(new ImageIcon("Elfo.gif"));
		lblNewLabel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPj = 3;
			
			}

		});
		lblNewLabel3.setBounds(285, 380, 157, 250);
		lblNewLabel3.setOpaque(false);
		lblNewLabel3.setContentAreaFilled(false);
		lblNewLabel3.setBorderPainted(false);
		getContentPane().add(lblNewLabel3);

		JButton lblNewLabel4 = new JButton(new ImageIcon("Enano.gif"));
		lblNewLabel4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPj = 4;
				
			}

		});
		lblNewLabel4.setBounds(413, 340, 157, 250);
		lblNewLabel4.setOpaque(false);
		lblNewLabel4.setContentAreaFilled(false);
		lblNewLabel4.setBorderPainted(false);
		getContentPane().add(lblNewLabel4);
	}

	public int getCambiarPj() {
		System.out.println("funciona" + cambiarPj);
		return cambiarPj;
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
	 * SE AÑADEN A LAS BASE DE DATOS LOS DATOS DE LOS JUGADORES
	 * 
	 * @param id
	 * @param nombre
	 * @param vida
	 * @param ataque
	 * @param vida_total
	 * @param oro
	 */
	public static void AddBaseDeDatos(String id, String nombre, int vida, String ataque, int vida_total, int oro) {
		Conexion.conectar();
		Conexion.EjecutarUpdate("INSERT INTO jugadores VALUES (\"" + id + "\",\"" + nombre + "\",\"" + vida + "\",\""
				+ ataque + "\",\"" + vida_total + "\",\"" + oro + "\")");
		Conexion.EjecutarUpdate("UPDATE jefes SET vida = 3");
	}

	public static void DeleteBaseDeDatos() {
		Conexion.conectar();
		Conexion.EjecutarUpdate("DELETE FROM jugadores");
	}
}