package prog3.arbol;

import prog3.listagenerica.*;
import prog3.util.Cola;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		Cola<ArbolBinario<T>> p = new Cola<ArbolBinario<T>>();
		ArbolBinario<T> act;
		p.encolar(this);
		p.encolar(null);
		boolean ant = false, anth = false;
		boolean res = true;
		while (!p.esVacia() && res) {
			act = p.descolar();
			if (act == null) {
				if (!p.esVacia()) p.encolar(act);
				ant = false;
			}
			else {
				if (act.tieneHijoIzquierdo()) p.encolar(act.getHijoIzquierdo());
				if (act.tieneHijoDerecho()) p.encolar(act.getHijoDerecho());
				if (ant) {
					if (anth) {
						if(!act.esHoja()) res =false;
					}else if(!act.tieneHijoDerecho()||!act.tieneHijoIzquierdo()) res = false;
				}else if (act.esHoja()) {
					anth = true;
				}
				ant = true;
			}
		}
		return res;
	}

	 boolean esCompleto() {
		Cola<ArbolBinario<T>> p = new Cola<ArbolBinario<T>>();
		ArbolBinario<T> act;
		p.encolar(this);
		p.encolar(null);
		boolean ant = false, anth = false;
		boolean res = true;
		while (!p.esVacia() && res) {
			act = p.descolar();
			if (act == null) {
				if (!p.esVacia()) p.encolar(act);
				ant = false;
			}
			else {
				if (act.tieneHijoIzquierdo()) p.encolar(act.getHijoIzquierdo());
				if (act.tieneHijoDerecho()) p.encolar(act.getHijoDerecho());
				if (ant) {
					if (anth) {
						if(!act.esHoja()) res =false;
					}else if(!act.tieneHijoDerecho()) anth = true;
				}else if (!act.tieneHijoDerecho()) {
					anth = true;
				}
				ant = true;
			}
		}
		return res;
	}

	
	// imprime el arbol en preorden  
	public void printPreorden() {
		System.out.println(this.toString());
		hijoIzquierdo.printPreorden();
		hijoDerecho.printPreorden();
		
	}

	// imprime el arbol en postorden
	public void printInorden() {
		hijoIzquierdo.printInorden();
		System.out.println(this.toString());
		hijoDerecho.printInorden();
	}
	
	// imprime el arbol en postorden
	public void printPostorden() {
		hijoIzquierdo.printPostorden();
		hijoDerecho.printPostorden();
		System.out.println(this.toString());
	}


	public void recorridoPorNiveles() {
		Cola<ArbolBinario<T>> p = new Cola<ArbolBinario<T>>();
		ArbolBinario<T> act;
		p.encolar(this);
		p.encolar(null);
		while (!p.esVacia()) {
			act = p.descolar();
			if (act == null) {
				if (!p.esVacia()) p.encolar(act);
			}
			else {
				if (act.tieneHijoIzquierdo()) p.encolar(act.getHijoIzquierdo());
				if (act.tieneHijoDerecho()) p.encolar(act.getHijoDerecho());
				System.out.println(act.toString());
			}
		}
	}

	

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l1, l = new ListaGenericaEnlazada<T>();
		if (hijoIzquierdo!=null) l = hijoIzquierdo.frontera();
		if (this.esHoja()) l.agregarFinal(dato);
		if (hijoDerecho!=null) {
			l1 = hijoDerecho.frontera();
			for (int i = 0;i<l1.tamanio();i++) {
				l.agregarFinal(l1.elemento(i));
			}
		}
		return l;
	}

	
	
	
	public int contarHojas() {
		if (this.esHoja()) {
			return 1;
		}
		else {
			int hi = 0,hd = 0;
			if (hijoIzquierdo!=null)hi = hijoIzquierdo.contarHojas();
			if (hijoDerecho!=null)	hd = hijoDerecho.contarHojas();
			return hi + hd;
		}
	}

	

}
