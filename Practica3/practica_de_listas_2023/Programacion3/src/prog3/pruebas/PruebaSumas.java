package prog3.pruebas;

import prog3.arbol.*;
import prog3.arbol.binario.util.Utiles;

public class PruebaSumas {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(1);
		a.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		a.agregarHijoDerecho(new ArbolBinario<Integer>(3));
		a.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		a.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(5));
		a.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		a.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(7));
		ProbarSumasVerticales(a);
		ProbarSumasNiveles(a);
		ProbarTrayectoriasPesadas(a);
	}
	
	public static void ProbarTrayectoriasPesadas(ArbolBinario<Integer> a) {
		System.out.println(Utiles.trayectoriaPesada(a));
	}
	public static void ProbarSumasVerticales(ArbolBinario<Integer> a) {
		System.out.println(Utiles.sumaMaximaVertical(a));
	}
	
	public static void ProbarSumasNiveles(ArbolBinario<Integer> a) {
		System.out.println(Utiles.sumaMaximaHorizontal(a));
	}

}
