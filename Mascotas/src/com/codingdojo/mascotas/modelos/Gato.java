package com.codingdojo.mascotas.modelos;

public class Gato extends Animal implements IMascota{

	public Gato(String gnombre, String graza, int gpeso) {
		this.setNombre(gnombre);
		this.setRaza(graza);
		this.setPeso(gpeso);
	}

	@Override
	public String showAffection() {
		return "Tu gato " + this.getRaza() +", "+ this.getNombre() +" te mira con afecto.";
	}

}
