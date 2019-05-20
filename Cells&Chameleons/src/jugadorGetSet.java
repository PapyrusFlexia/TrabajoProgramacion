
public class jugadorGetSet {

	private int oro;

	public jugadorGetSet(int oro) {
		super();
		this.oro = oro;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	@Override
	public String toString() {
		return "jugadorGetSet [oro=" + oro + "]";
	}

}
