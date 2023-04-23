package DispositivosMoviles;

public class SmartPhone extends Mobile {
	
	private int numero;
	
	public SmartPhone(String marca, String sistemaOperativo, String modelo, double costo, int numero) {
		super(marca, sistemaOperativo, modelo, costo);
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public boolean equals(Object obj) {
		return ((super.getMarca().equals(((Mobile) obj).getMarca()))&&(super.getModelo().equals(((Mobile) obj).getModelo()))&&(this.numero == ((SmartPhone) obj).getNumero()));
	}

	@Override
	public String toString() {
		return "Smartphone " + super.toString() + ",numero=" + numero + "]";
	}
	
}
