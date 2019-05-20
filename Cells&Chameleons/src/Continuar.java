import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Continuar extends JFrame {

	private JFrame frame;
	private JTextField txtAtencinSiContinuas;
	JLabel background;
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Continuar windowCont = new Continuar();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	/** para entrar en un jefe después de una tienda **/

	public Continuar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 367, 550, 300);
		getContentPane().setLayout(null);

		Toolkit marco = Toolkit.getDefaultToolkit();

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);
		setTitle("Cells&Chameleons");
		
		background = new JLabel(new ImageIcon("boss.gif"));
		background.setBounds(84, 113, 412, 137);
		getContentPane().add(background);


		txtAtencinSiContinuas = new JTextField();
		txtAtencinSiContinuas.setText("ATENCI\u00D3N, si continuas te enfrentaras a un JEFE \u00BFDeseas continuar?");
		txtAtencinSiContinuas.setBounds(51, 0, 445, 68);
		getContentPane().add(txtAtencinSiContinuas);
		txtAtencinSiContinuas.setColumns(10);
		txtAtencinSiContinuas.setEditable(false);

		JButton btnLeeroyJenkinsContinuar = new JButton("LEEROY JENKINS! CONTINUAR");
		btnLeeroyJenkinsContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Combate nwc = new Combate();

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				nwc.setVisible(true);

				dispose();

			}
		});
		btnLeeroyJenkinsContinuar.setBounds(20, 79, 211, 23);
		getContentPane().add(btnLeeroyJenkinsContinuar);

		JButton btnQuedarseEnLa = new JButton("QUEDARSE EN LA TIENDA");
		btnQuedarseEnLa.setBounds(333, 79, 191, 23);
		getContentPane().add(btnQuedarseEnLa);
		btnQuedarseEnLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tienda();
				Tienda tiendaVisible = new Tienda();
				tiendaVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new Tienda();
				Tienda tienda = new Tienda();
				tienda.setVisible(true);
				
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
	}
}