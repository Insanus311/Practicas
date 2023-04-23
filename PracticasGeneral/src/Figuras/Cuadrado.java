package Figuras;

public class Cuadrado extends Rectangulo {
	
	public Cuadrado(String color, boolean relleno, double lado) {
		super(color, relleno, lado, lado);
	}
	
	public Cuadrado(double lado) {
		super(lado,lado);
	}
	
	public Cuadrado() {
		super();
	}
	
	public double getLado() {
		return super.getAncho();
	}
	
	public void setLado(double lado) {
		super.setAncho(lado);
		super.setLargo(lado);
	}
	
	@Override
	public void setLargo(double largo) {
		super.setLargo(largo);
		super.setAncho(largo);
	}
	
	@Override
	public void setAncho(double ancho) {
		super.setLargo(ancho);
		super.setAncho(ancho);
	}
	
	@Override
	public String toString() {
		return "Cuadrado" + super.superToString() + ", lado=" + super.getAncho() + "]";
	}
	
}
