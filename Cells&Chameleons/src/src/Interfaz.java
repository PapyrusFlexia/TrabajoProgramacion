package src;

import java.sql.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import src.BBDD.Conexion;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import java.awt.event.*;
import java.io.*;

import java.io.File;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	int vidaActualTres;
	
	/** para avanzar en el juego, con la posibilidad de crear jefes, llevandote a la clase CreacionJefes **/

	public Interfaz() {
		Toolkit marco = Toolkit.getDefaultToolkit();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 143, 596, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabelP = new JLabel(new ImageIcon("biomatitle.png"));
		lblNewLabelP.setBounds(-13, 11, 605, 85);
		getContentPane().add(lblNewLabelP);
		
		JLabel lblNewLabelC = new JLabel(new ImageIcon("caos.png"));
		lblNewLabelC.setBounds(-13, 83, 605, 85);
		getContentPane().add(lblNewLabelC);

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);
		setVisible(true);
		setTitle("Cells&Chameleons");

		
		JButton lblNewLabel4 = new JButton(new ImageIcon("bioma.gif"));
		lblNewLabel4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion.conectar();

				Bioma nwB = new Bioma();
				nwB.NewScreen();

				new Bioma();
				Bioma biomaVisible = new Bioma();
				biomaVisible.setVisible(true);

				lblNewLabel4.setEnabled(false);
			}

		});
		lblNewLabel4.setBounds(10, 225, 560, 531);
		lblNewLabel4.setOpaque(false);
		lblNewLabel4.setContentAreaFilled(false);
		lblNewLabel4.setBorderPainted(false);
		getContentPane().add(lblNewLabel4);

		

		JButton btnCrearNuevoJefe = new JButton("CREAR NUEVO JEFE");
		btnCrearNuevoJefe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreacionJefes nwCreacionJefes = new CreacionJefes();
				nwCreacionJefes.NewScreen();

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				close();

				new CreacionJefes();
				CreacionJefes creacionjefesVisible = new CreacionJefes();
				creacionjefesVisible.setVisible(true);
				
				dispose();

			}

		});
		btnCrearNuevoJefe.setBounds(219, 179, 152, 23);
		contentPane.add(btnCrearNuevoJefe);

	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
