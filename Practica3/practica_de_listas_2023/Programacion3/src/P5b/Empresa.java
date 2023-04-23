package P5b;

import prog3.arbol.general.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Empresa {
	ArbolGeneral<Empleado> empleados = new ArbolGeneral<Empleado>();
	
	public ArbolGeneral<Empleado> getEmpleados() {
		return empleados;
	}

	public ListaGenerica<Empleado> empleadosPorCategoria(int categoria){
		ListaGenerica<Empleado> lista = new ListaGenericaEnlazada<Empleado>();
		llenarlista(categoria,lista, empleados);
		return lista;
	}
	
	private void llenarlista(int categoria, ListaGenerica<Empleado> lista, ArbolGeneral<Empleado> arbol) {
		if (arbol!=null) {
			if (categoria==arbol.getDato().getCategoria()) {
				lista.agregarFinal(arbol.getDato());
			}
			else {
				arbol.getHijos().comenzar();
				while(!arbol.getHijos().fin()) {
					llenarlista(categoria,lista,arbol.getHijos().proximo());
				}
			}
		}
	}
	
	public int categoriaConMasEmpleados(){
		int[] ancho = new int[empleados.altura()+2];
		int[] max = new int[2];
		anchos(ancho,max,empleados);
		return max[1];
	}
	
	private void anchos(int[] anchos, int[] maxancho, ArbolGeneral<Empleado> act) {
		if (act!=null) {
			if (++anchos[act.altura()]>maxancho[0])
				maxancho[0]=anchos[act.altura()];
				maxancho[1]=act.getDato().getCategoria();
			act.getHijos().comenzar();
			while(!act.getHijos().fin()) {
				anchos(anchos,maxancho,act.getHijos().proximo());
			}
		}
	}
	
	public int cantidadTotalEmpleados() {
		return cantidadTotalEmpleados(empleados);
	}
	private int cantidadTotalEmpleados(ArbolGeneral<Empleado> act) {
		if (act.esHoja()) return 1;
		else {
			int cant = 1;
			act.getHijos().comenzar();
			while(!act.getHijos().fin()) {
				cant+=cantidadTotalEmpleados(act.getHijos().proximo());
			}
			return cant;
		}
	}
	
	public void reemplazarPresidente() {
		if (empleados != null && !empleados.getHijos().esVacia())
			reemplazarEmpleado(empleados,empleados.getHijos());
		else empleados = null;
	}
	
	private void reemplazarEmpleado(ArbolGeneral<Empleado> empleado,ListaGenerica<ArbolGeneral<Empleado>> aCargo) {
		aCargo.comenzar();
		ArbolGeneral<Empleado> eAct, eMax = aCargo.proximo();
		int max = eMax.getDato().getAntiguedad();
		while(!aCargo.fin()) {
			eAct = aCargo.proximo();
			if(eAct.getDato().getAntiguedad()>max) {
				eMax = eAct;
				max = eMax.getDato().getAntiguedad();
			}
		}
		empleado.getDato().setNombre(eMax.getDato().getNombre());
		empleado.getDato().setAntiguedad(max);
		if (eMax.getHijos().esVacia())
			aCargo.eliminar(eMax);
		else 
			reemplazarEmpleado(eMax, eMax.getHijos());
	}
}
