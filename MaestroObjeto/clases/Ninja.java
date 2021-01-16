package maestroobjetos.clases;
import maestroobjetos.human.Human;

public class Ninja extends Human {
	
	public Ninja(String alias) {
		super(alias);
		this.setStealth(10);;
	}
	
	public void steal(Human human) {
		System.out.println("El personaje: "+ this.getAlias() +", realiza ataque: STEAL, a personaje: "+ human.getAlias());
		System.out.println("Valor ataque: "+ this.getStealth());
		
		int totalHealt = this.getHealt() + this.getStealth();
		int totalSteal = human.getHealt() - this.getStealth();
		human.setHealt(totalSteal);
		this.setHealt(totalHealt);
		
		System.out.println(this.getAlias() +" recupera vida: "+ this.getHealt());
		System.out.println("Puntos vida "+ human.getAlias() +": "+ human.getHealt());
	}
	
	public void runAway() {
		System.out.println("El personaje: "+ this.getAlias() +" huyo");
		
		int total = this.getHealt() - 10;
		this.setHealt(total);
		
		System.out.println(this.getAlias() +" pierde vida: "+ this.getHealt());
	}

}
