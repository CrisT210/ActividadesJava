package com.codingdojo.mascotas.modelos;

public class Perro extends Animal implements IMascota {
	
	public Perro(String pnombre, String praza, int ppeso) {
		this.setNombre(pnombre);
		this.setRaza(praza);
		this.setPeso(ppeso);
	}

	@Override
	public String showAffection() {
		if(this.getPeso() < 30 ) {
			return "Haz creado un "+ this.getRaza() +"!\n "+ this.getNombre() +" se sube a tu regazo.";
		} else {
			return "Haz creado un "+ this.getRaza() +"!\n "+ this.getNombre() +" se acurruca a tu lado.";
		}
		
	}

}
