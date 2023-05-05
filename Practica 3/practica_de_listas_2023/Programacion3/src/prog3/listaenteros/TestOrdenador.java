package prog3.listaenteros;

import java.util.Scanner;

public class TestOrdenador {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada c, b = new ListaDeEnterosEnlazada(), a = new ListaDeEnterosEnlazada();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("Ingrese el nodo: ");
			Integer as = in.nextInt();
			a.agregarInicio(as);		
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			System.out.print("Ingrese el nodo: ");
			Integer as = in.nextInt();
			b.agregarInicio(as);		
		}
		a = a.ordenar();
		c = b.combinarOrdenado(a);
		System.out.println(c.toString());
		in.close();
	}
}
