public class TiendaGetSet {
	private int id;
	private String nombre;
	private int poder;
	private int valor;
	private String estado;
	private String tipo;

	public TiendaGetSet(int id, String nombre, int poder, int valor, String estado, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.poder = poder;
		this.valor = valor;
		this.estado = estado;
		this.tipo = tipo;
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

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TiendaGetSet [id=" + id + ", nombre=" + nombre + ", poder=" + poder + ", valor=" + valor + ", estado="
				+ estado + ", tipo=" + tipo + "]";
	}

}
