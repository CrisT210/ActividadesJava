package maestroobjetos.clases;
import maestroobjetos.human.Human;

public class Wizard extends Human{
	
	public Wizard(String alias) {
		super(alias);
		this.setHealt(50);
		this.setIntelligence(8);
	}
	
	public void heal(Human human) {
		System.out.println("El personaje: "+ this.getAlias() +", realiza ataque: Heal, a personaje: "+ human.getAlias());
		System.out.println("Valor ataque: "+ this.getIntelligence());
		
		int totalRoboVida = (human.getHealt() - this.getIntelligence());
		int totalVida = (this.getHealt() + this.getIntelligence());
		human.setHealt(totalRoboVida);
		this.setHealt(totalVida);
		
		System.out.println(this.getAlias() +" recupera vida: "+ this.getHealt());
		System.out.println("Puntos vida "+ human.getAlias() +": "+ human.getHealt());
	}
	
	public void fireBall(Human human) {
		System.out.println("El personaje: "+ this.getAlias() +", realiza ataque: FIREBALL, a personaje: "+ human.getAlias());
		System.out.println("Valor ataque: "+ (this.getIntelligence() * 3));
		
		int totalAtaque = ((human.getHealt() - this.getIntelligence() * 3));
		human.setHealt(totalAtaque);
		
		System.out.println("Puntos vida "+ human.getAlias() +": "+ human.getHealt());
	}
	
}
