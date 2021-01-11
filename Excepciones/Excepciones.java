import java.util.ArrayList;

public class Excepciones {

	public void manejarExcepciones() {
		
		ArrayList<Object> listaObjetos = new ArrayList<Object>();
		listaObjetos.add("13");
		listaObjetos.add("Hola Mundo");
		listaObjetos.add(48);
		listaObjetos.add("Adios Mundo");
		
		for(int i = 0; i < listaObjetos.size(); i++) {
			
			try {
				int cast = (int) listaObjetos.get(i);
				System.out.println(cast);
			}catch(ClassCastException e) {
				System.out.println(e.getMessage());
				System.out.println("Indice error: "+ i +" - Valor: "+ listaObjetos.get(i));
			}
			
		}
		
		
	}
}
