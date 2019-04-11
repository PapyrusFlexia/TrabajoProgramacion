import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;



public class CreacionPersonajes extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// System.out.println(Dado.tirarDado(6)); //
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
	/**
	 * Create the frame.
	 */
	public CreacionPersonajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		getContentPane().setLayout(null);
		
		
		
		
		
		final JFrame dado = new JFrame();
		JLabel lblBienvenido = new JLabel("BIENVENIDO A LA CREACION DE PERSONAJES");
		lblBienvenido.setBounds(180, 100, 238, 14);
		getContentPane().add(lblBienvenido);
		
		JButton btndParaTu = new JButton("1d8 para tu vida");
		btndParaTu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

			// Dado Tirada = new Dado();//
			// Tirada.tirarDado(6);//
			JOptionPane.showMessageDialog(dado.getComponent(0), "Has sacado un " + Dado.tirarDado(20));
		}
	});
		btndParaTu.setBounds(64, 188, 144, 23);
		getContentPane().add(btndParaTu);
		
		JLabel label = new JLabel("");
		label.setBounds(274, 192, 46, 14);
		getContentPane().add(label);
		
		JButton btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.setBounds(244, 491, 89, 23);
		getContentPane().add(btnFinalizar);
		btndParaTu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		Interfaz nwInterfaz = new Interfaz();
		nwInterfaz.NewScreen();

		// contentPane.setVisible(false);
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
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}