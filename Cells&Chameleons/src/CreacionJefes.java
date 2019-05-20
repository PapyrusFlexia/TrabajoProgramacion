import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class CreacionJefes extends JFrame {

	private JFrame frame;
	private JTextField Dificultad;

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreacionJefes windowCJ = new CreacionJefes();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	/** para llamar a la creacion de los jefes dependiendo de la dificultad **/

	public CreacionJefes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 367, 448, 173);
		getContentPane().setLayout(null);

		Toolkit marco = Toolkit.getDefaultToolkit();

		Image icono = marco.getImage("Cells&Chameleons\\src\\Chameleon.png");
		setIconImage(icono);
		setTitle("Cells&Chameleons");

		Dificultad = new JTextField();
		Dificultad.setText("Elige la dificultad del JEFE que quieres crear");
		Dificultad.setBounds(43, 0, 361, 68);
		getContentPane().add(Dificultad);
		Dificultad.setColumns(10);

		JButton btnJefeFacil = new JButton("JEFE FÁCIL");
		btnJefeFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JefeFacil();
				JefeFacil combateJefeFacil = new JefeFacil();
				combateJefeFacil.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();
				
				dispose();

			}

		});
		btnJefeFacil.setBounds(10, 79, 107, 23);
		getContentPane().add(btnJefeFacil);

		JButton btnJefeMedio = new JButton("JEFE MEDIO");
		btnJefeMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JefeMedio();
				JefeMedio combateJefeMedio = new JefeMedio();
				combateJefeMedio.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();
				
				dispose();

			}

		});
		btnJefeMedio.setBounds(163, 79, 107, 23);
		getContentPane().add(btnJefeMedio);

		JButton btnJefeDificil = new JButton("JEFE DIFÍCIL");
		btnJefeDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JefeDificil();
				JefeDificil combateJefeDificil = new JefeDificil();
				combateJefeDificil.setVisible(true);

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();
				
				dispose();

			}

		});
		btnJefeDificil.setBounds(315, 79, 107, 23);
		getContentPane().add(btnJefeDificil);

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
