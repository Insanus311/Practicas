package Practica2A;

public class Tablet {
	
	private String marca, sistemaOperativo, modelo;
	private double costo;
	private float pulgadas;
	
	public Tablet(String marca, String sistemaOperativo, String modelo, double costo, float pulgadas) {
		super();
		this.marca = marca;
		this.sistemaOperativo = sistemaOperativo;
		this.modelo = modelo;
		this.costo = costo;
		this.pulgadas = pulgadas;
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
	public float getPulgadas() {
		return pulgadas;
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
	public void setPulgadas(float pulgadas) {
		this.pulgadas = pulgadas;
	}
	
	public String devolverDatos() {
		return "Tablet [marca=" + marca + ", sistema operativo=" + sistemaOperativo + ", modelo=" + modelo + ", costo="
				+ costo + ", pulgadas=" + pulgadas + "]";
	}
	

}
