import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class PuzzleJava {

	public ArrayList<Integer> puzzleA() {
		
		int[] arr = {3,5,1,2,7,9,8,13,25,32};
		int suma = 0;
		ArrayList<Integer> mayores = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			suma = suma + arr[i];
			if(arr[i] > 10) {
				mayores.add(arr[i]);
			}
		}
		System.out.println("La suma del arreglo es: "+ suma);
		return mayores;
		
	}

	public ArrayList<String> puzzleB() {
		
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> newArr = new ArrayList<String>();
		
		arr.add("Nancy");
		arr.add("Jinichi");
		arr.add("Fujibayashi");
		arr.add("Momochi");
		arr.add("Ishikawa");
		System.out.println("Arreglo Original: "+ arr);
		
		Collections.shuffle(arr);
		System.out.println("Arreglo Mezclado: "+ arr);
		
		for(int i = 0; i < arr.size(); i++) {
			String aux = arr.get(i);
			if(aux.length() > 5) {
				newArr.add(aux);
			}
				
		}
		return newArr;
		
	}
	
	public void abcdario() {
		
		String[] abc = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		List<String> abcList = Arrays.asList(abc);
		Collections.shuffle(abcList);
		abcList.toArray(abc);
		
		System.out.println(Arrays.toString(abc));
		System.out.println("Ultima letra: "+ abc[abc.length -1]);
		if(abc[0] == "A" || abc[0] == "E" || abc[0] == "I" || abc[0] == "O" || abc[0] == "U") {
			System.out.println("La primera letra es vocal: " + abc[0]);
		}else {
			System.out.println("Primera letra: "+ abc[0]);
		}
		
	}
	
	public int[] arrayRandom(){
		
		int[] arr = new int[10];
		
		Random rand = new Random();
		//rand.ints(10, 1 , 51);
		//IntStream intRand = rand.ints(10, 55, 101);
	    //Iterator iter = intRand.iterator();
				
		for(int i = 0; i < arr.length; i++) {
			//arr[i] = (int) iter.next();
			arr[i] = rand.nextInt(101 - 55) + 55;
		}
		return arr;
		
	}
	
	public Integer[] arrayOrdenado() {
		
		Integer[] arr = new Integer[10];
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++) {
			// nextInt(max - min) + min, para obtener numeros en un cierto rango
			arr[i] = rand.nextInt(101 - 55) + 55;
		}
		
		// crear una lista con los elementos del arreglo
		List<Integer> arrList = Arrays.asList(arr);
		// ordenar lista
		Collections.sort(arrList);
		// Devolver lista al arreglo
		arrList.toArray(arr);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arreglo["+ i +"]: "+ arr[i]);
		}
		System.out.println("Valor minimo: "+ arr[0] +" - Valor maximo: "+ arr[arr.length - 1]);
		return arr;
		
	}
	
	public void cadena() {
		
		String caracteres = "";
		Random rand = new Random();
		
		for(int i = 0; i < 5; i++) {
			caracteres += (char) (rand.nextInt(91) + 48);	
		}
		System.out.println(caracteres);
		
	}
	
	public void arregloCadena() {
		
		String[] arr = new String[10];
		String caracteres = "";
		Random rand = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			caracteres = "";
			for(int j = 0; j < 5; j++) {
				caracteres += (char) (rand.nextInt(91) + 48);
			}
			arr[i] = caracteres;
		}
		System.out.println(Arrays.toString(arr));
	}
}
