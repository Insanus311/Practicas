package Figuras;

public class Rectangulo extends Figuras {

	private double largo,ancho;
	
	public Rectangulo(String color, boolean relleno, double largo, double ancho) {
		super(color, relleno);
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public Rectangulo(double largo, double ancho) {
		super();
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public Rectangulo() {
		super();
		largo = 1;
		ancho = 1;
	}
	
	public double getLargo() {
		return largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	@Override
	public double getArea() {
		return (largo*ancho);
	}

	@Override
	public double getPerimetro() {
		return (2*ancho + 2*largo);
	}

	@Override
	public String toString() {
		return "Rectangulo" + super.toString() + ", largo=" + largo + ", ancho=" + ancho + "]";
	}
	
	public String superToString() {
		return super.toString();
	}

}
