import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Continuar extends JFrame {

	private JFrame frame;
	private JTextField txtAtencinSiContinuas;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Continuar windowCont = new Continuar();
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
	public Continuar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 173);
		getContentPane().setLayout(null);

		txtAtencinSiContinuas = new JTextField();
		txtAtencinSiContinuas.setText("ATENCI\u00D3N, si continuas te enfrentaras a un JEFE \u00BFDeseas continuar?");
		txtAtencinSiContinuas.setBounds(43, 0, 361, 68);
		getContentPane().add(txtAtencinSiContinuas);
		txtAtencinSiContinuas.setColumns(10);

		JButton btnLeeroyJenkinsContinuar = new JButton("LEEROY JENKINS! CONTINUAR");
		btnLeeroyJenkinsContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Combate();
				Combate combateVisible = new Combate(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				combateVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});
		btnLeeroyJenkinsContinuar.setBounds(10, 79, 181, 23);
		getContentPane().add(btnLeeroyJenkinsContinuar);

		JButton btnQuedarseEnLa = new JButton("QUEDARSE EN LA TIENDA");
		btnQuedarseEnLa.setBounds(241, 79, 181, 23);
		getContentPane().add(btnQuedarseEnLa);
		btnQuedarseEnLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tienda();
				Tienda tiendaVisible = new Tienda(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				tiendaVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});

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
	}
}