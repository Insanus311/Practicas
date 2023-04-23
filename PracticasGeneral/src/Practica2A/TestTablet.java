package Practica2A;

public class TestTablet {

	public static void main(String[] args) {
		Tablet[] t = new Tablet[3];
		t[0] = new Tablet("a", "b", "c", 1, 2);
		t[1] = new Tablet("d", "e", "f", 3, 4);
		t[2] = new Tablet("g", "h", "i", 5, 6);
		for (Tablet a:t) {
			System.out.println(a.devolverDatos());
		}

	}

}
