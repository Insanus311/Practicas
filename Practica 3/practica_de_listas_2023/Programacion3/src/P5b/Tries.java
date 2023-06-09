package P5b;

import java.util.LinkedList;
import java.util.List;

import prog3.arbol.general.ArbolGeneral;

public class Tries {
	ArbolGeneral<Character> tries = new ArbolGeneral<Character>(' ');
	public void agregarPalabra(String palabra) {
		palabra.length();
		insertar(tries,palabra,palabra.length());
	}
	private void insertar(ArbolGeneral<Character> tries, String palabra, int faltan) {
		if(faltan!=0) {
			ArbolGeneral<Character> act;
			tries.getHijos().comenzar();
			boolean noEsta = true;
			while(!tries.getHijos().fin() && noEsta) {
				act = tries.getHijos().proximo();
				if (act.getDato()==palabra.charAt(palabra.length()-faltan)) {
					insertar(act,palabra,faltan-1);
					noEsta = false;
				}
			}
			if (noEsta) {
				act = new ArbolGeneral<Character>(palabra.charAt(palabra.length()-faltan));
				tries.getHijos().agregarInicio(act);
				insertar(tries.getHijos().elemento(0),palabra,faltan-1);
			}
		}
	}
	public List<StringBuilder> palabrasQueEmpiezanCon(String prefijo){
		char[] prefijos = new char[prefijo.length()];
		prefijo.getChars(0, prefijo.length(), prefijos, 0);
		List<StringBuilder> lista = new LinkedList<StringBuilder>();
		ArbolGeneral<Character> s = BuscarArbol(prefijos,0,tries);
		if(!s.getHijos().esVacia()) {
			StringBuilder prefijoTo = new StringBuilder(prefijo.length()+s.altura());
			prefijoTo.insert(0, prefijo);
			insertarPalabras(lista,s,prefijoTo);
		}
		return lista;
		
	}
	private ArbolGeneral<Character> BuscarArbol(char[] prefijos, int ind,ArbolGeneral<Character> tries) {
		tries.getHijos().comenzar();
		ArbolGeneral<Character> act = null;
		boolean esta = false;
		while(!tries.getHijos().fin() && !esta) {
			act = tries.getHijos().proximo();
			if (act.getDato().compareTo(prefijos[ind])==0) {
				esta = true;
				for (int i = 0; i<prefijos.length-1;i++) 
					prefijos[i]=prefijos[i+1];
			}
		}
		if (esta)return BuscarArbol(prefijos,ind+1,act);
		else return null;
	}
	
	private void insertarPalabras(List<StringBuilder> lista, ArbolGeneral<Character> cont,StringBuilder prefijo) {
		if (!cont.getHijos().esVacia()) {
			cont.getHijos().comenzar();
			ArbolGeneral<Character> act;
			while(!cont.getHijos().fin()) {
				act = cont.getHijos().proximo();
				prefijo.insert(prefijo.length(), act.getDato());
				insertarPalabras(lista,act,prefijo);
			}
		}
		else {
			prefijo.insert(prefijo.length(), cont.getDato());
			lista.add(prefijo);
		}
	}

}
