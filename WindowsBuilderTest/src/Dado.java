import java.util.ArrayList;

public class Dado {
  /*  public static int tirarDado(int rango) {
        double resultado;
        resultado=Math.random()*rango; // Se le suma 1 si el valor del 0 es 10. 
        return (int)resultado;
    } */
	private int rango;
	private double resultado;
	
	public Dado(int rango, double resultado) {
		super();
		this.rango = rango;
		this.resultado = resultado;
	}
	public Dado() {
	
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	public static int tirarDado(int rango) {
		double resultado;
        resultado=Math.random()*rango; // Se le suma 1 si el valor del 0 es 10. 
        return (int)resultado;
      
    } 
	
    
    
    
    
    
}
