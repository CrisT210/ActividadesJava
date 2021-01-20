package calculadora;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator a = new Calculator();
		
		a.setOperandOne(10.5);
		a.setOperation("+");
		a.setOperandTwo(5.2);
		System.out.println(a.getResult());
	}

}
