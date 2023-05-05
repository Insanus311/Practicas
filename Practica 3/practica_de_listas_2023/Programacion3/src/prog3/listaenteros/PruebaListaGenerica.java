package prog3.listaenteros;

import prog3.listagenerica.*;


import java.util.Scanner;
import prog3.util.*;

public class PruebaListaGenerica {

	public static void main(String[] args) {
		ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			System.out.print("Ingrese el nodo: ");
			Integer as = in.nextInt();
			lista.agregarInicio(as);		
		}
		UtilitariosLista nue = new UtilitariosLista();
		System.out.println(lista);
		lista = nue.MergeShort(lista);
		System.out.println(lista);
		lista = lista.invertir();
		System.out.println(lista);
		in.close();
	}

}
