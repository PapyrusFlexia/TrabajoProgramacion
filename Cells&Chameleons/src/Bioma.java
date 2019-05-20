import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Bioma extends JFrame {

	private JFrame frame;

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bioma windowP = new Bioma();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Se añaden los botones y el if, si se saca menos de diez te lleva a un jefe,
	 * si se saca mas de 10, a una tienda
	 **/

	public Bioma() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(1250, 143, 596, 795);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon("Mazmorra.png"));
		lblNewLabel.setBounds(32, 11, 511, 85);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabelC = new JLabel(new ImageIcon("Camino.gif"));
		lblNewLabelC.setBounds(0, 155, 580, 602);
		getContentPane().add(lblNewLabelC);

		Toolkit marco = Toolkit.getDefaultToolkit();

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);
		setTitle("Cells&Chameleons");

		final JFrame dado = new JFrame();

		JPanel topPanel = new JPanel();

		JButton btnNewButton = new JButton("ENTRAR EN EL PORTAL");

		int tirada = Dado.tirarDado(20) + 1;

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(dado.getComponent(0), "Has sacado un " + tirada); // SI ES MENOR QUE DIEZ
																								// ME LLEVA A JEFE, SI
																								// ES MAYOR A TIENDA

				if (tirada > 10) {
					Tienda nwTienda = new Tienda();
					nwTienda.NewScreen();

					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					close();

					new Tienda();
					Tienda tiendaVisible = new Tienda();
					tiendaVisible.setVisible(true);
				} else {
					Combate nwcombate = new Combate();

					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					close();

					nwcombate.setVisible(true);

				}

			}
		});

		btnNewButton.setBounds(192, 121, 185, 23);
		getContentPane().add(btnNewButton);

	}

	/** para inicializar la pestaña **/

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/** para cerrar la pestaña **/

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}