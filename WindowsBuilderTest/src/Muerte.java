import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Muerte extends JFrame {

	private JFrame frame;
	private JTextField crearNuevoPj;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Muerte windowM = new Muerte();
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
	public Muerte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 173);
		getContentPane().setLayout(null);

		crearNuevoPj = new JTextField();
		crearNuevoPj.setText("HAS MUERTO :( , ¿QUIERES CREAR UN NUEVO PERSONAJE?");
		crearNuevoPj.setBounds(43, 0, 361, 68);
		getContentPane().add(crearNuevoPj);
		crearNuevoPj.setColumns(10);

		JButton btnLeeroyJenkinsContinuar = new JButton("LOK'TAR OGAR! (CONTINUAR)");
		btnLeeroyJenkinsContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CreacionPersonajes();
				CreacionPersonajes CreacionPersonajesVisible = new CreacionPersonajes(); // QUITAR CUANDO SE TERMINE EL PROGRAMA
				CreacionPersonajesVisible.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

			}

		});
		btnLeeroyJenkinsContinuar.setBounds(10, 79, 181, 23);
		getContentPane().add(btnLeeroyJenkinsContinuar);

		JButton btnQuedarseEnLa = new JButton("ME RETIRO POR HOY, PARA LUCHAR OTRO DIA (ABANDONAR) ");
		btnQuedarseEnLa.setBounds(241, 79, 181, 23);
		getContentPane().add(btnQuedarseEnLa);
		btnQuedarseEnLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

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