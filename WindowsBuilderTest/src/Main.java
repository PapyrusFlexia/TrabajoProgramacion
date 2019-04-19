import java.awt.EventQueue;

import BBDD.Conexion;

public class Main {

	public static void main(String[] args) { ////////////////// CAMBIAR POR NEWSCREEN DE INTERFAZ
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

	public static void AddBaseDeDatos() {
		Conexion.conectar();

	}
}
