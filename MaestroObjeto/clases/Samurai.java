package maestroobjetos.clases;
import maestroobjetos.human.Human;

public class Samurai extends Human{
	
	private static int countSamurai;
	
	public Samurai(String alias) {
		super(alias);
		this.setHealt(200);
		countSamurai++;
	}
	
	public void deathBlow(Human human) {
		System.out.println("El personaje: "+ this.getAlias() +", realiza ataque: Heal, a personaje: "+ human.getAlias());
		System.out.println(human.getAlias() +" A MUERTO");
		
		int puntosDeath = human.getHealt() - human.getHealt();
		int puntosHealt = this.getHealt() - 100;
		this.setHealt(puntosHealt);
		human.setHealt(puntosDeath);
		human = null;
		System.out.println(this.getAlias() +" pierde vida, total: "+ this.getHealt());	
	}
	
	public void meditate() {
		System.out.println("El personaje "+ this.getAlias() +" recupera vida");
		int puntosMeditate = this.getHealt() + (this.getHealt() / 2);
		this.setHealt(puntosMeditate);
		System.out.println(this.getAlias() +" recupera vida: "+ this.getHealt());
	}
	
	public static int howMany() {
		return countSamurai;
	}

}
