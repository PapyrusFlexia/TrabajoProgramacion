public class turnoJugadorGetSet {
	
	private int vida;
	private int id;
	
	public turnoJugadorGetSet(int vida, int id) {
		super();
		this.vida = vida;
		this.id = id;
	}

	public  int getVida() {
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

	@Override
	public String toString() {
		return "turnoJugadorGetSet [vida=" + vida + ", id=" + id + "]";
	}
	
	

}
