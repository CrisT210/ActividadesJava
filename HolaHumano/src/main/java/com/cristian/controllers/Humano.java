package com.cristian.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Humano {
	
	@RequestMapping("/")
	public String hello(@RequestParam(value="nom", required = false) String nombre, @RequestParam(value = "ape", required = false) String apellido) {
		if(nombre == null && apellido == null || nombre == null) {
			return "<h1>Hola Humano</h1>";
		} 
		else if(apellido == null) {
			return "<h1>Hola "+ nombre +"</h1>";
		} else {
			return "<h1>Hola "+ nombre +" "+ apellido+"</h1>";
		}
	}
	
}
