package DispositivosMoviles;

public class Tablet extends Mobile {
	
	private int pulgadas;
	
	public Tablet(String marca, String sistemaOperativo, String modelo, double costo, int pulgadas) {
		super(marca,sistemaOperativo,modelo,costo);
		this.pulgadas = pulgadas;
	}

	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}

	@Override
	public boolean equals(Object obj) {
		return ((super.getMarca().equals(((Mobile) obj).getMarca()))&&(super.getModelo().equals(((Mobile) obj).getModelo()))&&(this.pulgadas == ((Tablet) obj).getPulgadas()));
	}
	

	@Override
	public String toString() {
		return "Tablet " + super.toString() + "pulgadas=" + pulgadas + "]";
	}
}
