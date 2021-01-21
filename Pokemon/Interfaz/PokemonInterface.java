package Interfaz;
import pokemon.Pokemon;

public interface PokemonInterface {

	Pokemon createPokemon(String nombre, int salud, String tipo);
	String pokemonInfo(Pokemon pokemon);
	void listPokemon();
	
}
