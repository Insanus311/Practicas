package Figuras;

public abstract class Figuras {
	
	private String color;
	private boolean relleno;
	
	public Figuras(String color, boolean relleno) {
		super();
		this.color = color;
		this.relleno = relleno;
	}
	
	public Figuras() {
		color = "Blanco";
		relleno = false;
	}

	public String getColor() {
		return color;
	}

	public boolean isRelleno() {
		return relleno;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimetro();

	@Override
	public String toString() {
		return " [color=" + color + ", relleno=" + relleno + ", area=" + this.getArea() + ", perimetro=" + this.getPerimetro();
	}
}
