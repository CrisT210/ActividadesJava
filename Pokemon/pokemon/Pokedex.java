package pokemon;

public class Pokedex extends AbstractPokemon{
	
	private int myPokemons;
	
	public Pokedex() {
		
	}
	
	public int getMyPokemons() {
		return myPokemons;
	}

	private void setMyPokemons(int myPokemons) {
		this.myPokemons = myPokemons;
	}

	@Override
	public void listPokemon() {
		setMyPokemons(Pokemon.getCount());
		for(int i = 0; i < getMyPokemons(); i++) {
			System.out.println("Nombre: "+ getArr().get(i).getName());
		}
	}
}
