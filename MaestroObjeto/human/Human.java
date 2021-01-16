package maestroobjetos.human;

public class Human {
	
	private int strength, intelligence, stealth, healt;
	private String alias; 

	public Human(String alias) {
		super();
		this.alias = alias;
		strength = 3;
		intelligence = 3;
		stealth = 3;
		healt = 100;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getHealt() {
		return healt;
	}

	public void setHealt(int healt) {
		this.healt = healt;
	}
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public void attack(Human human) {
		System.out.println("El personaje: "+ this.alias + ", realiza ataque: PUÑO, a personaje: "+ human.alias);
		System.out.println("Valor Ataque: "+ this.strength);
		
		human.healt -= this.strength; 
		System.out.println("Puntos vida "+ human.alias +": "+ human.getHealt());
	}

}
