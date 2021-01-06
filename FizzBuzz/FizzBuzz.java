
public class FizzBuzz {
	public String fizzBuzz(int number) {
		if(number % 3 == 0 && number %5 == 0) {
			return "FizzBuzz";
		}else if(number % 3 == 0) {
			return "Fizz";
		}else if(number % 5 == 0) {
			return "Buzz";
		} else {
			String numero = String.format("El numero% d no es divisible por 3 y 5", number);
			return numero;
		}
	}
}
