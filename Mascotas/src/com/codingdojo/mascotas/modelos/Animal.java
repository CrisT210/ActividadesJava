package com.codingdojo.mascotas.modelos;
import java.io.Serializable;

public class Animal implements Serializable {
	
	private String nombre;
	private String raza;
	private int peso;
	
	public Animal() {
		
	}
	
	public Animal(String nombre, String raza, int peso) {
		this.nombre = nombre;
		this.raza = raza;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
