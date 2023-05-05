package prog3.util;

import prog3.listagenerica.ListaGenericaEnlazada;

public class Cola<T> {

	ListaGenericaEnlazada<T> datos;

	public Cola() {
		datos = new ListaGenericaEnlazada<T>();
	}

	public void encolar(T elem) {
		datos.agregarFinal(elem);
	}

	public T descolar() {
		T inter = datos.elemento(0);
		datos.eliminarEn(0);
		return inter;
	}

	public T tope() {
		return datos.elemento(0);
	}

	public boolean esVacia() {
		return datos.tamanio()==0;
	}

	
	public int tamanio() {
		return datos.tamanio();
	}
}
