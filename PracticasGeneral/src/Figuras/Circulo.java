package Figuras;

public class Circulo extends Figuras {
	
	private double radio;
	
	public Circulo(String color, boolean relleno, double radio) {
		super(color,relleno);
		this.radio = radio;
	}
	
	public Circulo(double radio) {
		super();
		this.radio = radio;
	}
	
	public Circulo() {
		super();
		radio = 1;
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public double getArea() {
		return Math.PI*radio*radio;
	}

	@Override
	public double getPerimetro() {
		return 2*Math.PI*radio;
	}

	@Override
	public String toString() {
		return "Circulo" + super.toString() + ", radio=" + radio + "]";
	}

}
