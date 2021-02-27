package calculadora;
import java.io.Serializable;

public class Calculator implements Serializable{
	
	private String operacion;
	private double res;
	private boolean suma;
	private boolean resta;
	private boolean multiplicacion;
	private boolean division;
	
	public Calculator() {
		
		operacion = "";
		suma = false;
		resta = false;
		multiplicacion = false;
		division = false;
		
	}
	
	public void performOperation(double operacion) {
		this.operacion += operacion;
//		System.out.print(operacion);
//		return this.operacion;
	}
	
	public void performOperation(String operador) {
		if(operador != "=") {
			this.operacion += operador;
//			System.out.print(operador);
		}else {
			for(int i = 0; i < operacion.length(); i++) {
				System.out.println("Caracter " + i + ": " + operacion.charAt(i));
			}
		}
//		return this.operacion;
	}
	
	public void suma(String operador) {
		this.res = Double.parseDouble(operador);
		suma = true;
		this.operacion = "";
	}
	
	public void resta(String operador) {
		this.res = Double.parseDouble(operador);
		resta = true;
		this.operacion = "";
	}
	
	public void multiplicacion(String operador) {
		this.res = Double.parseDouble(operador);
		multiplicacion = true;
		this.operacion = "";
	}
	
	public void division(String operador) {
		this.res = Double.parseDouble(operador);
		division = true;
		this.operacion = "";
	}
	
	public double operaciones(double num) {
		if(suma == true) {
			res = res + num;
		} else if(resta == true) {
			res = res - num;
		} else if(multiplicacion == true) {
			res = res * num;
		} else if(division == true) {
			res = res / num;
		}
		
		suma = false;
		resta = false;
		multiplicacion = false;
		division = false;
		return res;
	}
	
	public void getResults() {
		System.out.println(res);
	}

}
