package telefonos.clases;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", 99, "Entel", "Ring Ring Ring!!!");
		Iphone i10 = new Iphone("X", 100, "Wom", "Zing");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		i10.displayInfo();
		System.out.println(i10.ring());
		System.out.println(i10.unlock());

	}

}
