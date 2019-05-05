public class TiendaGetSet {
	private int valor;
	private int id;
	
	public TiendaGetSet(int valor, int id) {
		super();
		this.valor = valor;
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TiendaGetSet [valor=" + valor + ", id=" + id + "]";
	}
	
	
	

	
	

}
