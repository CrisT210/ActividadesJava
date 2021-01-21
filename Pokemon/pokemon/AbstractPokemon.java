package pokemon;
import java.util.ArrayList;
import Interfaz.PokemonInterface;

public abstract class AbstractPokemon implements PokemonInterface {
	
	private ArrayList<Pokemon> arr = new ArrayList<Pokemon>();

	public ArrayList<Pokemon> getArr() {
		return arr;
	}

	public Pokemon createPokemon(String nombre, int salud, String tipo) {
		Pokemon pok = new Pokemon(nombre, salud, tipo);
		arr.add(pok);
//		return new Pokemon(nombre, salud, tipo);
		return pok;
	}
	
	public String pokemonInfo(Pokemon pokemon) {
		
		return "Nombre Pokemon: "+ pokemon.getName() +"- Salud: "+ pokemon.getHealt() +"- Tipo: "+ pokemon.getType();
	}
	
}
