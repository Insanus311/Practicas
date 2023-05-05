package prog3.arbol.binario.util;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Adivinanza {
	
	public static ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntasv2(ArbolBinario<String> a){
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> res = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		ListaGenericaEnlazada<String> act = new ListaGenericaEnlazada<String>();
		int[] maxprof = {0};
		dfs(a,act,res,maxprof,0);
		return res;
	}
	
	private static void dfs(ArbolBinario<String> a, ListaGenericaEnlazada<String> act, ListaGenericaEnlazada<ListaGenericaEnlazada<String>> res, int[] maxprof, int profact) {
	    act.agregarFinal(a.getDato());
	    profact++;
	    if (!a.tieneHijoDerecho() && !a.tieneHijoIzquierdo()) {
	        if (profact >= maxprof[0]) {
	            if (profact > maxprof[0]) {
	                maxprof[0] = profact;
	                while(!res.esVacia()) {
	                	res.eliminarEn(0);
	                }
	            }
	            ListaGenericaEnlazada<String> nuevaAct = new ListaGenericaEnlazada<String>();
	            act.comenzar();
	            while (!act.fin()) {
	                nuevaAct.agregarFinal(act.proximo());
	            }
	            res.agregarFinal(nuevaAct);
	        }
	    } else {
	        if (a.tieneHijoIzquierdo()) {
	            ListaGenericaEnlazada<String> nuevaAct = new ListaGenericaEnlazada<String>();
	            act.comenzar();
	            while (!act.fin()) {
	                nuevaAct.agregarFinal(act.proximo());
	            }
	            dfs(a.getHijoIzquierdo(), nuevaAct, res, maxprof, 0);
	        }
	        if (a.tieneHijoDerecho()) {
	            ListaGenericaEnlazada<String> nuevaAct = new ListaGenericaEnlazada<String>();
	            act.comenzar();
	            while (!act.fin()) {
	                nuevaAct.agregarFinal(act.proximo());
	            }
	            dfs(a.getHijoDerecho(), nuevaAct, res, maxprof, 0);
	        }
	    }
	    act.eliminarEn(act.tamanio() - 1);
	}

	
	public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> a){
	    ListaGenericaEnlazada<String> secuencia = new ListaGenericaEnlazada<String>();
	    secuenciaConMasPreguntasRec(a, new ListaGenericaEnlazada<String>(), secuencia);
	    return secuencia;
	}

	private static void secuenciaConMasPreguntasRec(ArbolBinario<String> a, ListaGenericaEnlazada<String> actual, ListaGenericaEnlazada<String> maxima) {
	    if (a != null) {
	        actual.agregarFinal(a.getDato());
	        if (a.esHoja()) {
	            if (actual.tamanio() > maxima.tamanio()) {
	            	actual.comenzar();
	            	while(!actual.fin()) {
	            		maxima.agregarFinal(actual.proximo());
	            	}
	            }
	        } else {
	            secuenciaConMasPreguntasRec(a.getHijoIzquierdo(), actual, maxima);
	            secuenciaConMasPreguntasRec(a.getHijoDerecho(), actual, maxima);
	        }
	        actual.eliminarEn(actual.tamanio()-1);
	    }
	}
}