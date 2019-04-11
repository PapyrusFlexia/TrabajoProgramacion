import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Interfaz extends JFrame {

	private JPanel contentPane;

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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton buttonPantano = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cover1.png")));
		buttonPantano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pantano nw = new Pantano();
				nw.NewScreen();
				// contentPane.setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new Pantano();
				Pantano pantanoVisible = new Pantano();
				pantanoVisible.setVisible(true);

			}
		});

		buttonPantano.setBounds(10, 42, 560, 155);
		contentPane.add(buttonPantano);

		JButton buttonBosque = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cover3.png")));

		buttonBosque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bosque nwB = new Bosque();
				nwB.NewScreen();

				// contentPane.setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new Bosque();
				Bosque bosqueVisible = new Bosque();
				bosqueVisible.setVisible(true);

			}

		});

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 87, 16);
		contentPane.add(toolBar);

		buttonBosque.setBounds(10, 540, 560, 155);
		contentPane.add(buttonBosque);

		JButton buttonMontana = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cover2.png")));
		buttonMontana.setBounds(10, 208, 560, 155);
		contentPane.add(buttonMontana);

		JButton buttonDesierto = new JButton(new ImageIcon(getClass().getClassLoader().getResource("cover5.png")));
		buttonDesierto.setBounds(10, 374, 560, 155);
		contentPane.add(buttonDesierto);

		JLabel lblEligeElBioma = new JLabel("Elige el BIOMA en el que te encuentras");
		lblEligeElBioma.setBounds(205, 11, 206, 14);
		contentPane.add(lblEligeElBioma);

	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
