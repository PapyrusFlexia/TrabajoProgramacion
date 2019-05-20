package src;

import java.awt.EventQueue;

import src.BBDD.Conexion;

public class Main {
	
	/** para empezar el programa llamando a la clase Inicio **/

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public static void AddBaseDeDatos() {
		Conexion.conectar();

	}
}
