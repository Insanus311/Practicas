package Practica2A;

public class Multiplos {

	public static int[] getMultiplos (int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = n*(i+1);
		}
		return res;
	}

}

