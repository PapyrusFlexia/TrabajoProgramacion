package src;

public class turnoJugadorGetSet {

	private int vida;
	private int id;
	private String nombre;

	public turnoJugadorGetSet(int vida, int id, String nombre) {
		super();
		this.vida = vida;
		this.id = id;
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "turnoJugadorGetSet [vida=" + vida + ", id=" + id + ", nombre=" + nombre + "]";
	}

}
