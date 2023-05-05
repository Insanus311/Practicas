package prog3.listaenteros;

import java.util.Scanner;

public class ListaEnterosPrueba {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada a = new ListaDeEnterosEnlazada();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("Ingrese el primer nodo");
			Integer as = in.nextInt();
			a.agregarFinal(as);		
		}
		listaInversa(a,a.tamanio());
		in.close();
	}
	
	public static void listaInversa(ListaDeEnterosEnlazada a, int tamanio) {
		if (tamanio > 0) {
			System.out.println(a.elemento(tamanio - 1));
			listaInversa(a,tamanio-1);
		}
	}
}
