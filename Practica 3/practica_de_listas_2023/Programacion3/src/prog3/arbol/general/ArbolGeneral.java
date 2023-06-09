package prog3.arbol.general;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.Cola;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos;

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}
	
	public ArbolGeneral() {
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		if (this.esHoja()) return 0;
		else {
			int act,max=0;
			hijos.comenzar();
			while(!hijos.fin()) {
				act = hijos.proximo().altura();
				if (act>max) max = act;
			}
			return max+1;
		}
	}
	
	public boolean include(T dato) {
		if (this.dato.equals(dato)) return true;
		else {
			if (!hijos.esVacia()) {
				hijos.comenzar();
				boolean r = false;
				while(!hijos.fin()&&!r) 
					if (hijos.proximo().include(dato)) r = true;
				return r;
			}
			else return false;
		}
	}

	public Integer nivel(T dato) {
		if (this.include(dato)) {
			if (this.dato.equals(dato)) return 0;
			else {
				hijos.comenzar();
				int a,max = -1;
				while(!hijos.fin()&&(max>-1)) {
					a = hijos.proximo().nivel(dato);
					if (a>max) max=a+1;
				}
				return max;
			}
		}else return -1;
	}

	public Integer ancho() {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> act;
		cola.encolar(this);
		cola.encolar(null);
		int a=0 ,max = 0;
		while (!cola.esVacia()) {
			act = cola.descolar();
			if ((act == null) && !cola.esVacia()) {
				if (a>max) max = a;
				a=0;
				cola.encolar(null);
			}else {
				a++;
				hijos.comenzar();
				while(!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}
		return max;
	}

}