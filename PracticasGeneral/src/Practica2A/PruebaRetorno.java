package Practica2A;

public class PruebaRetorno {

	
	public void procesarArreglo(int[] arreglo, Resultado res) {
		int 	max = -999999999,
				min = 999999999;
		double promedio;
		for (int a:arreglo) {
			if (a<min) min = a;
			else if (a>max) max = a;
		}
		promedio = (max + min)/2;
		res.setMax(max);
		res.setMin(min);
		res.setPromedio(promedio);
	}
	
}
