package prog3.util;

import prog3.listagenerica.ListaGenericaEnlazada;

public class UtilitariosLista {
	public ListaGenericaEnlazada<Integer> MergeShort(ListaGenericaEnlazada<Integer> lista){
		int q = lista.tamanio();
		return Merge(lista,0,q-1);
	}
	private ListaGenericaEnlazada<Integer> Merge(ListaGenericaEnlazada<Integer> lista, int i, int f){
		int i1 = i, f1 = i + (f-i)/2, i2 = i + (f-i)/2 + 1, f2=f;
		if (i<f) {
			System.out.println("i1= "+i1+"  f1= "+f1+"  i2= "+i2+"  f2= "+f2);
			Merge(lista,i1,f1);
			Merge(lista,i2,f2);
			while ((i1<=f1)&&(i2<=f2)) {
				if (lista.elemento(i1)>=lista.elemento(i2)) {
					lista.agregarEn(lista.elemento(i2), i1);
					i1++;
					i2++;
					lista.eliminarEn(i2);
				}
				else i2++;
			}
		}
		return lista;
	}
}



