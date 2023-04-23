package Practica2A;

import java.util.Scanner;

public class IterdorAB {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] c = Multiplos.getMultiplos(a);
		for (int i = 0; i < a; i++) {
			System.out.println(c[i]);
		}
		in.close();
	}
	
	public static void iteracionConFor(int a, int b) {
		for (int i = a; i <= b;i++) {
			System.out.println(i);
		}
	}
	
	public static void iteracionConWhile(int a, int b) {
		while (a<=b) {
			System.out.println(a);
			a++;
		}
	}
	public static void recursion (int a, int b) {
		if (a <= b) {
			System.out.println(a);
			recursion(a+1,b);
		}
	}

}
