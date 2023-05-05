package ola;
import prog3.arbol.ArbolBinario;

public class ProcesadorDeArbol {
	private static ArbolBinario<Character> arbol = new ArbolBinario<Character>();
	public static void main(String[] args) {
		arbol.setDato('a');
		arbol.agregarHijoIzquierdo(new ArbolBinario<Character>('b'));
		arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Character>('d'));
		arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Character>('e'));
		arbol.getHijoIzquierdo().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Character>('i'));
		arbol.getHijoIzquierdo().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Character>('h'));
		arbol.getHijoIzquierdo().getHijoIzquierdo().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Character>('l'));
		arbol.agregarHijoDerecho(new ArbolBinario<Character>('c'));
		arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Character>('f'));
		arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Character>('g'));
		arbol.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Character>('k'));
		arbol.getHijoDerecho().getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Character>('m'));
		arbol.getHijoDerecho().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Character>('j'));
		arbol.recorridoPorNiveles();
		System.out.println(procesar(0));
	}
	public static int procesar(int k) {
		if (arbol==null || arbol.esVacio()) return 0;
		else return procesarRec(arbol,k);
	}
	
	private static int procesarRec(ArbolBinario<Character> a, int k) {
		if (a.esHoja()) { 
			if (k==0) return 1;
		}
		else if ((a.tieneHijoDerecho()&&a.tieneHijoIzquierdo())) {
			return procesarRec(a.getHijoIzquierdo(),k) + procesarRec(a.getHijoDerecho(),k);
		}
		else if(k>0) {
			if(a.tieneHijoDerecho()&&!a.tieneHijoIzquierdo()) {
				return procesarRec(a.getHijoDerecho(),k-1);
			}
			else return procesarRec(a.getHijoIzquierdo(),k-1);
		}
		return 0;
	}
	
}
