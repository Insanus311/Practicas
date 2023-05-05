package prog3.util;

import prog3.listagenerica.ListaGenericaEnlazada;

public class PilaGenerica<T> {

	ListaGenericaEnlazada<T> datos;

	public PilaGenerica() {
		datos = new ListaGenericaEnlazada<T>();
	}

	public void apilar(T elem) {
		datos.agregarInicio(elem);
	}

	public T desapilar() {
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

}
