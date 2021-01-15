package com.codingdojo.gorila;

import com.codingdojo.mammal.Mammal;

public class Gorila extends Mammal {
	
	public void trowSomething(){
		System.out.println("El gorila lanzo un objeto, Cuidado!!!");
		this.setEnergyLevel(-5);
	}
	
	public void eatBananas() {
		System.out.println("El gorila esta comiendo...");
		this.setEnergyLevel(10);
	}
	
	public void climb() {
		System.out.println("El gorila ha subido la cumbre");
		this.setEnergyLevel(-10);
	}
	
}
