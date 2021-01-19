package banco.cuenta;
import java.util.Random;

public class CuentaBanco {
	
	private String nroCuenta;
	private double saldoCuentaCorriente, saldoCuentaAhorro;
	private static int count;
	private static double totalCuenta;
	
	public CuentaBanco() {
		this.nroCuenta = asignacionNroCuenta();
		saldoCuentaCorriente = 0;
		saldoCuentaAhorro = 0;
		count++;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public double getSaldoCuentaCorriente() {
		return saldoCuentaCorriente;
	}

	public double getSaldoCuentaAhorro() {
		return saldoCuentaAhorro;
	}

	public static int getCount() {
		return count;
	}

	public static double getTotalCuenta() {
		return totalCuenta;
	}
	
	private String asignacionNroCuenta() {
		Random rand = new Random();
		nroCuenta = "";
		for(int i = 0; i < 10; i++) {
			nroCuenta += (char) (rand.nextInt(58 - 48) + 48);
		}
//		System.out.println(nroCuenta);
		return nroCuenta;
	}
	
	public void depositar(double montoCorriente, double montoAhorro) {
		if(montoCorriente > 0) {
			this.saldoCuentaCorriente += montoCorriente;
			System.out.println("Deposito Efectuado");
			System.out.println("Saldo Cuenta Corriente: "+ this.saldoCuentaCorriente);
		}

		if(montoAhorro > 0) {
			this.saldoCuentaAhorro += montoAhorro;
			System.out.println("Deposito Efectuado");
			System.out.println("Saldo Cuenta de Ahorro: "+ this.saldoCuentaAhorro);
		}
		
		CuentaBanco.totalCuenta += (montoCorriente + montoAhorro);
		
	}
	
	public void girar(double montoCorriente, double montoAhorro) {
		if(montoCorriente <= this.saldoCuentaCorriente && montoCorriente > 0) {
			this.saldoCuentaCorriente -= montoCorriente;
			System.out.println("Giro Efectuado Satisfactiamente");
			System.out.println("Saldo Cuenta Corriente: "+ this.saldoCuentaCorriente);
		}else if(montoCorriente == 0) {
			System.out.println("No se ingreso monto para giro en Cuenta Corriente");
		}else {
			System.out.println("Saldo insuficiente en la cuenta, puede retirar hasta un monto de: "+ this.saldoCuentaCorriente);
		}
		
		if(montoAhorro <= this.saldoCuentaAhorro && montoAhorro > 0) {
			this.saldoCuentaAhorro -= montoAhorro;
			System.out.println("Giro Efectuado Satisfactiamente");
			System.out.println("Saldo Cuenta de Ahorro: "+ this.saldoCuentaAhorro);
		}else if(montoAhorro == 0) {
			System.out.println("No se ingreso monto para giro en Cuenta de Ahorro");
		}else {
			System.out.println("Saldo insuficiente en la cuenta, puede retirar hasta un monto de: "+ this.saldoCuentaAhorro);
		}
		CuentaBanco.totalCuenta -= (montoCorriente + montoAhorro);
	}
	
	public void totalCuentas() {
		System.out.println("Saldos numero de cuenta: "+ this.nroCuenta);
		System.out.println("Cuenta Corriente: "+ this.saldoCuentaCorriente);
		System.out.println("Cuenta de Ahorro: "+ this.saldoCuentaAhorro);
	}

}
