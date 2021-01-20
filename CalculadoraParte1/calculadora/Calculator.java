package calculadora;
import java.io.Serializable;

public class Calculator implements Serializable {


	private String operation;
	private double operandOne;
	private double operandTwo;
	
	public Calculator() {
		operation = "";
		operandOne = 0.0;
		operandTwo = 0.0;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	private double performOperation() {
		double resultado = 0;
		switch(operation) {
			case "+":
				resultado = this.operandOne + this.operandTwo;
				break;
			case "-":
				resultado = this.operandOne - this.operandTwo;
				break;
//			case "*":
//				resultado = this.operandOne * this.operandTwo;
//				break;
//			case "/":
//				resultado = this.operandOne / this.operandTwo;
//				break;
			default:
				System.out.println("Operacion no admitida");
		}
		return resultado;
	}
	
	public double getResult() {
		return performOperation();
	}
	
}
