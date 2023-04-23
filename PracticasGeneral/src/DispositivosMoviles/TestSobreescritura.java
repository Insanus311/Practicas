package DispositivosMoviles;

public class TestSobreescritura {
	
	
	
	
	public static void main(String[] args) {
		SmartPhone celu1 = new SmartPhone("Motorola","Android 12","Moto Edge Pro",1900.0,3644810);
		SmartPhone celu2 = new SmartPhone("Motorola","Android 12","Moto Edge Pro",1900.0,3644810);
		if (celu1.equals(celu2)) {
			System.out.println("son iguales uwu");
		}else System.out.println("no son iguales owo");
		System.out.println(celu1);
		System.out.println(celu2);
	}

}
