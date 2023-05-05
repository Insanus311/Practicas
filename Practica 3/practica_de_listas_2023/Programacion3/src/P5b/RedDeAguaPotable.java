package P5b;

import prog3.arbol.general.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;

public class RedDeAguaPotable {
	public float minimoCaudalEnCasa(ArbolGeneral<Integer> Canios, float n) {
		if (Canios!=null) {
			ListaGenerica<ArbolGeneral<Integer>> l = Canios.getHijos();
			l.comenzar();
			float min = n;
			while(!l.fin()) {
				float act = minimoCaudalEnCasa(l.proximo(),n/l.tamanio());
				if(min > act) min = act;
			}
			return min;
		}else return 0;
	}
}
