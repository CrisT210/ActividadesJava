import java.util.ArrayList;
import java.util.Arrays;

public class EjerciciosBasicos {
	
	public void secuencia() {
		for(int i = 1; i <= 255; i++) {
			System.out.println(i);
		}
	}
	
	public void impares() {
		for(int i = 1; i <= 255; i++) {
			if((i % 2)!=0) {
				System.out.println(i);
			}
		}
	}
	
	public void sumaParcial() {
		int suma = 0;
		for(int i = 0; i <= 255; i++) {
			suma = suma + i;
			String res = String.format("Nuevo numero:% d Suma:% d", i, suma);
			System.out.println(res);
		}
	}
	
	public void recorrerArreglo() {
		int[] arr = {4,8,12,16,20,24,28,32,36,40};
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void maximo() {
		int[] arr = {-5,-15,-10,-100,-45,-105,-30,-2};
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("El numero maximo es: "+ max);
	}
	
	public void promedio() {
		int[] arr = {2, 10, 5};
		int sum = 0;
		int pro = 0;
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		pro = sum / arr.length;
		System.out.println("Promedio de: "+ pro);
	}
	
	public void arrImpares() {
		ArrayList<Integer> y = new ArrayList<Integer>();
		for(int i = 1; i <= 255; i++) {
			if((i % 2) != 0) {
				y.add(i);
			}
		}
		System.out.println(y);
	}
	
	public void mayoresQue() {
		int[] y = {1,3,40,5,30,12,33,19};
		int Y = 3;
		int count = 0;
		for(int i = 0; i < y.length; i++) {
			if(i > Y) {
				count++;
			}
		}
		System.out.println("El cantidad de valores mayores que "+ Y +" es: "+ count);
	}
	
	public void valoresCuadrado() {
		int[] x = {1,5,10,-2};
		int aux = 0;
		for(int i = 0; i < x.length; i++) {
			aux = x[i] * x[i];
			x[i] = aux;
		}
		System.out.println(Arrays.toString(x));
	}
	
	public void eliminarNegativos() {
		int[] x = {1,-5,10,-2,-7,4};
		for(int i = 0; i < x.length; i++) {
			if(x[i] < 0) {
				x[i] = 0;
			}
		}
		System.out.println(Arrays.toString(x));
	}
	
	public void minMaxPro() {
		int[] x = {1,-5,10,-2,-7,40};
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int min = x[0];
		int max = x[0];
		int sum = 0;
		int avg = 0;
		for(int i = 0; i < x.length; i++) {
			sum = sum + x[i];
			if(min > x[i]) {
				min = x[i];
			}
			else if(max < x[i]) {
				max = x[i];
			}
		}
		avg = sum / x.length;
		arr.add(max);
		arr.add(min);
		arr.add(avg);
		System.out.println(arr);
	}
	
	public void cambiarValores() {
		int[] arr = {1,5,10,7,-2};
		int aux;
		for(int i = 0 ; i < arr.length ; i++) {
			if(i < (arr.length - 1)) {
				aux = arr[i + 1];
				arr[i] = aux;
			} else {
				arr[arr.length - 1] = 0;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
