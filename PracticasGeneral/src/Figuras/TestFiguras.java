package Figuras;

public class TestFiguras {

	public static void main(String[] args) {
		Figuras[] arreglo = new Figuras[3];
		arreglo[0] = new Cuadrado("Rojo",true,4.2);
		arreglo[1] = new Rectangulo("Azul",false,3.0,9.1);
		arreglo[2] = new Circulo("Amarillo",true,2.1);
		for(Figuras a:arreglo) {
			System.out.println(a.toString());
		}
	}

}
