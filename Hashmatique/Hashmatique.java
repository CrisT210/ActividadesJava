import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
	
	public void tracks() {
	
		HashMap<String, String> trackList  = new HashMap<String, String>();
		
		trackList.put("Cancion Uno", "Letra Uno");
		trackList.put("Cancion Dos", "Letra Dos");
		trackList.put("Cancion Tres", "Letra Tres");
		trackList.put("Cancion Cuatro", "Letra Cuatro");
		
		// System.out.println(trackList);
		
		String titulo = trackList.get("Cancion Tres");
		System.out.println("Letra: "+ titulo);
		
		Set<String> Lyrics = trackList.keySet();
		System.out.println("Listado de Canciones - Letras");
		for(String Track : Lyrics) {
			System.out.println(Track);
			System.out.println(trackList.get(Track));
		}
	}
	
}
