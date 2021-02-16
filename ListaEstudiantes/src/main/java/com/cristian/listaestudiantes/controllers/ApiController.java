package com.cristian.listaestudiantes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.listaestudiantes.models.Contacto;
import com.cristian.listaestudiantes.models.Estudiante;
import com.cristian.listaestudiantes.services.ApiService;

@RestController
public class ApiController {
	
	private final ApiService apiService;
	
	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping(value="/studens/create", method=RequestMethod.GET)
	public Estudiante crearEstudiante(@RequestParam(value="nombre") String nombre, @RequestParam(value="apellido") String apellido, @RequestParam(value="edad") Integer edad) {
		Estudiante student = new Estudiante(nombre, apellido, edad);
		return apiService.crearEstudiante(student);
	}
	
	@RequestMapping("/contacts/create")
	public Contacto crearContacto(@RequestParam(value="estudiante") Estudiante estudiante, @RequestParam(value="direccion") String direccion, @RequestParam("ciudad") String ciudad, @RequestParam("comuna") String comuna) {
		Contacto contact = new Contacto(estudiante, direccion, ciudad, comuna);
		return apiService.crearContacto(contact);
		
	}
	
	@RequestMapping("/students")
	public List<Estudiante> infoContato() {
		List<Estudiante> contact = apiService.allStudent();
		return contact;
	}

}
