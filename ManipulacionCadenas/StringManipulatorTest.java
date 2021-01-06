
public class StringManipulatorTest {

	public static void main(String[] args) {
		
		StringManipulator manipulator = new StringManipulator();
		String str = manipulator.trimAndConcat("    Hola     ","     Mundo    ");
		System.out.println("Trim y concat: "+ str); // HolaMundo 
		
		char letter = 'n';
		int a = manipulator.getIndexOrNull("Coding", letter);
		int b = manipulator.getIndexOrNull("Hola Mundo", letter);
		int c = manipulator.getIndexOrNull("Saludar", letter);
		System.out.println("indexOf a: "+ a); // 4
		System.out.println("indexOf b: "+ b); // 7
		System.out.println("indexOf c: "+ c); // -1

		String word = "Hola";
		String subString = "la";
		String notSubString = "mundo";
		int d = manipulator.getIndexOrNull(word, subString);
		int e = manipulator.getIndexOrNull(word, notSubString);
		System.out.println("indexOf d: "+ d); // 2
		System.out.println("indexOf e: "+ e); // -1
		
		String word2 = manipulator.concatSubstring("Hola", 1, 3, "mundo");
		System.out.println("Concat y substring: "+ word2); // olmundo

	}

}
