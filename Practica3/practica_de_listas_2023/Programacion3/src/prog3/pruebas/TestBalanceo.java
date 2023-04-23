package prog3.pruebas;
import java.util.Scanner;

import prog3.util.PilaGenerica;

public class TestBalanceo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a="";
		a = in.next();
		if (esBalanceado(a))System.out.println("Si");
		else System.out.println("No");
		in.close();
	}
	public static boolean esBalanceado(String a) {
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		int i =0;
		boolean res = true;
		while (i<a.length()) {
			char c = a.charAt(i);
			if ((c == '(')||(c == '[')||(c == '{')) {
				pila.apilar(a.charAt(i));
			}
			else if ((c == ')')||(c == ']')||(c == '}')) {
				char d = pila.desapilar();
				if (((c == ')')&&(d != '('))||((c == ']')&&(d != '['))||((c == '}')&&(d != '{'))) {
					res = false;
				}
			}
			i++;
		}
		return res;
	}
}
