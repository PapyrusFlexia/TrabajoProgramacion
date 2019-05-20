import java.util.ArrayList;
import java.util.Random;

public class Dado {

	private int rango;
	private int resultado;

	public Dado(int rango, int resultado) {
		super();
		this.rango = rango;
		this.resultado = resultado;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Dado [rango=" + rango + ", resultado=" + resultado + "]";
	}

	public static int tirarDado(int rango) {
		double resultado;
		resultado = Math.random() * rango;

		return (int) resultado;

	}

}
