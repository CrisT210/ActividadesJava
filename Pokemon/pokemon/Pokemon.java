package pokemon;

public class Pokemon {
	
	private String name;
	private int healt;
	private String type;
	private static int count;
	
	public Pokemon(String nombre, int salud, String tipo) {
		name = nombre;
		healt = salud;
		type = tipo;
		count++;
	}
	
	public Pokemon() {
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealt() {
		return healt;
	}

	public void setHealt(int healt) {
		this.healt = healt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Pokemon.count = count;
	}
	
	void attackPokemon(Pokemon pokemon) {
		System.out.println("Pokemon "+ this.name +" ataco a "+ pokemon.name);
		int ataque = pokemon.getHealt() - 10;
		pokemon.setHealt(ataque);
		System.out.println("Pokemon "+ pokemon.name +" tiene una salud de: "+ pokemon.healt);
	}
}
