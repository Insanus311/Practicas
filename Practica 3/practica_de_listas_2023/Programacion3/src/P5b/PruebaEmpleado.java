package P5b;

import prog3.arbol.general.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;

public class PruebaEmpleado {

	public static void main(String[] args) {
		Empresa e = new Empresa();
		e.getEmpleados().setDato(new Empleado("Jefe",25,1));
		e.getEmpleados().agregarHijo(new ArbolGeneral<Empleado>(new Empleado("subjefe1",1,2)));
		e.getEmpleados().agregarHijo(new ArbolGeneral<Empleado>(new Empleado("subjefe2",2,2)));
		e.getEmpleados().agregarHijo(new ArbolGeneral<Empleado>(new Empleado("subjefe3",4,2)));
		e.getEmpleados().agregarHijo(new ArbolGeneral<Empleado>(new Empleado("subjefe4",3,2)));
		e.getEmpleados().getHijos().elemento(2).agregarHijo(new ArbolGeneral<Empleado>(new Empleado("emp1",6,3)));
		System.out.println(e.categoriaConMasEmpleados());
		System.out.println(e.cantidadTotalEmpleados());
		ListaGenerica<Empleado> l = e.empleadosPorCategoria(2);
		l.comenzar();
		while(!l.fin()) System.out.println(l.proximo().getNombre());
		e.reemplazarPresidente();
		System.out.println(e.categoriaConMasEmpleados());
		System.out.println(e.cantidadTotalEmpleados());
		l = e.empleadosPorCategoria(2);
		l.comenzar();
		while(!l.fin()) System.out.println(l.proximo().getNombre());
	}
}
