import java.sql.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Inicio extends JFrame {
	
	/** te lleva a la creación de personajes **/

	public Inicio() {
		Toolkit marco = Toolkit.getDefaultToolkit();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(680, 367, 664, 179);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon("Titulo.png"));
		lblNewLabel.setBounds(20, 11, 605, 85);
		getContentPane().add(lblNewLabel);

		Image icono = marco.getImage("src\\Chameleon.png");
		setIconImage(icono);
		setVisible(true);
		setTitle("Cells&Chameleons");

		JButton btnCrearNuevoPj = new JButton("CREAR NUEVO PERSONAJE");
		btnCrearNuevoPj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreacionPersonajes nwCreacionPersonajes = new CreacionPersonajes();
				nwCreacionPersonajes.NewScreen();

				new CreacionPersonajes();
				CreacionPersonajes creacionpersonajesVisible = new CreacionPersonajes();
				creacionpersonajesVisible.setVisible(true);

				dispose();

			}

		});
		btnCrearNuevoPj.setBounds(231, 107, 189, 23);
		getContentPane().add(btnCrearNuevoPj);

	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
