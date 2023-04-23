package DispositivosMoviles;

public class Mobile {
	
	private String marca, sistemaOperativo, modelo;
	private double costo;
	
	public Mobile(String marca, String sistemaOperativo, String modelo, double costo) {
		super();
		this.marca = marca;
		this.sistemaOperativo = sistemaOperativo;
		this.modelo = modelo;
		this.costo = costo;
	}
	
	public String getMarca() {
		return marca;
	}
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	public String getModelo() {
		return modelo;
	}
	public double getCosto() {
		return costo;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	@Override
	public String toString() {
		return " [marca=" + marca + ", sistema operativo=" + sistemaOperativo + ", modelo=" + modelo + ", costo="
				+ costo;
	}
	

}