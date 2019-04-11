import java.util.ArrayList;
import java.util.Random;

public class Dado {
	/*
	 * public static int tirarDado(int rango) { double resultado;
	 * resultado=Math.random()*rango; // Se le suma 1 si el valor del 0 es 10.
	 * return (int)resultado; }
	 */
	// private int rango;
	private int resultado;

	public Dado(int resultado) {
		super();
		this.resultado = resultado;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Dado [resultado=" + resultado + "]";
	}

	public static int tirarDado(int resultado) { // int rango
		// double resultado;
		// resultado=Math.random()*rango; // Se le suma 1 si el valor del 0 es 10.

		// return (int)resultado;
		Random aleatorio = new Random();
		resultado = 1 + aleatorio.nextInt(20);
		return resultado;

	}

}
