package P5b;

public class Empleado {
	private String nombre;
	private int antiguedad,categoria;
	public Empleado(String nombre, int antiguedad, int categoria) {
		this.nombre=nombre;
		this.antiguedad=antiguedad;
		this.categoria=categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
}
