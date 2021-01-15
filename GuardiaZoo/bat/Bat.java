package com.codingdojo.bat;
import com.codingdojo.mammal.Mammal;

public class Bat extends Mammal{
	
	public Bat() {
		
		this.setEnergyLevel(200);
		
	}
	
	public void fly() {
		muere();
		System.out.println("FLY!!! FLY!!! FLY!!!");
		this.setEnergyLevel(-50);
	}
	
	public void eatHumans() {
		System.out.println("Bueno, no importa");
		this.setEnergyLevel(25);;
	}
	
	public void attackTown() {
		muere();
		System.out.println("LLAMAS!! LLAMAS!! LLAMAS!!");
		this.setEnergyLevel(-100);
	}
	
	public int muere() {
		if(this.displayEnergy() <= 0) {
			System.out.println("Murio!!!");
			return null;
		}
	}
	
}
