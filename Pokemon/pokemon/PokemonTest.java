package pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		
//		Pokemon poke1 = new Pokemon();
		
//		poke1.setName("Pikachu");
//		poke1.setHealt(100);
//		poke1.setType("Electrico");
		
		Pokedex a = new Pokedex();
		Pokemon poke2 = a.createPokemon("Charmander", 100, "Fuego");
		Pokemon poke3 = a.createPokemon("Snorlax", 100, "Normal");
		
		poke2.attackPokemon(poke3);
		poke3.attackPokemon(poke2);
		poke3.attackPokemon(poke2);
		System.out.println(poke2.getHealt());		
				
		System.out.println(Pokemon.getCount());

		a.listPokemon();
		System.out.println(a.getMyPokemons());
		
	}

}
