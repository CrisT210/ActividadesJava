package com.cristian.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/{dojo}")
	public String dojos(@PathVariable("dojo") String dojo) {
		if(dojo.equals("dojo")) {
			return "¡El Dojo es increible!";
		} else if(dojo.equals("burbank-dojo")) {
			return "El Dojo Burbank esta localizado al sur de California";
		} else if(dojo.equals("san-jose")) {
			return "El Dojo SJ es el cuartel general";
		} else {
			return "@PathVariable no valida: " + dojo;
		}
		
			
	}
}
