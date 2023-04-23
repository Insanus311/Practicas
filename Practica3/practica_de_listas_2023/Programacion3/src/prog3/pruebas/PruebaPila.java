package prog3.pruebas;

import prog3.util.*;

public class PruebaPila {

	public static void main(String[] args) {
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		pila.apilar('a');
		pila.apilar('e');
		pila.apilar('i');
		pila.apilar('o');
		pila.apilar('u');
		pila.desapilar();
		pila.desapilar();
		pila.desapilar();
		pila.desapilar();
		System.out.println(pila.tope());
	}

}
