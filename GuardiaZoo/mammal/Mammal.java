package com.codingdojo.mammal;

public class Mammal {

	private int energyLevel;
	
	public Mammal() {
		energyLevel = 100;	
	}

	public int getEnergyLevel() {
		return this.energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel += energyLevel;
	}
	
	public int displayEnergy() {
		System.out.println("Nivel de energia: "+ this.energyLevel);
		return this.energyLevel;
	}
	
}
