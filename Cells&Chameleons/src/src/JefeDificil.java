package src;

import java.sql.*;
import java.text.NumberFormat;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import src.BBDD.Conexion;

import java.awt.event.*;
import java.io.File;

public class JefeDificil extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textFieldid;
	private JTextField vidatotalfield;
	int VidaTotal = Dado.tirarDado(7) + 5;

	String atkInicial = "1d8";
	

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
	
	/** igual que la creacion de personajes pero con jefes dificiles y lo añade a la base de datos **/

	public JefeDificil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 143, 596, 795);
		getContentPane().setLayout(null);

		JLabel lblNewLabelP = new JLabel(new ImageIcon("Jefe.png"));
		lblNewLabelP.setBounds(0, 11, 605, 85);
		getContentPane().add(lblNewLabelP);
		

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

		textFieldid = new JTextField("");
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

		JLabel label_2 = new JLabel("1d8");
		label_2.setBounds(193, 295, 46, 14);
		getContentPane().add(label_2);

		JLabel vidatotalfield = new JLabel();
		vidatotalfield.setBounds(193, 343, 183, 20);
		getContentPane().add(vidatotalfield);

		final JFrame dado = new JFrame();

		JButton btnCrear = new JButton("CONTINUAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				AddBaseDeDatos(textFieldid.getText(), textField.getText(), VidaTotal, atkInicial, VidaTotal); // RELLENAR

				Interfaz nwc = new Interfaz();

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				nwc.setVisible(true);

				dispose();

			}

		});
		btnCrear.setBounds(231, 638, 129, 50);
		getContentPane().add(btnCrear);

		JButton btndParaTu = new JButton("1d8 para tu vida");
		btndParaTu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(dado.getComponent(0), "Has sacado un " + VidaTotal);
				vidatotalfield.setText("Tienes " + VidaTotal + " de vida total");
				vidaActual.setText("Tienes " + VidaTotal + " de vida actual");

			}
		});

		btndParaTu.setBounds(21, 238, 144, 23);
		getContentPane().add(btndParaTu);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(481, 80, 89, 23);
		getContentPane().add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Interfaz();
				Interfaz interfazVisible = new Interfaz();
			

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();
				
				dispose();

			}

		});

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

	public static void AddBaseDeDatos(String id, String nombre, int vida, String ataque, int vida_total) {
		Conexion.conectar();
		Conexion.EjecutarUpdate("INSERT INTO jefes VALUES (\"" + id + "\",\"" + nombre + "\",\"" + vida + "\",\""
				+ ataque + "\",\"" + vida_total + "\")");

	}

	
}