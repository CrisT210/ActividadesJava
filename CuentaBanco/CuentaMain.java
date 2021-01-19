package banco.cuenta;

public class CuentaMain {

	public static void main(String[] args) {
		
		CuentaBanco cuenta1 = new CuentaBanco();
		
//		System.out.println(cuenta1.getNroCuenta());
//		System.out.println(CuentaBanco.getCount());
		cuenta1.depositar(10000, 15000);
		cuenta1.girar(0, 5000);
		cuenta1.totalCuentas();
		System.out.println(CuentaBanco.getTotalCuenta());
	}

}
