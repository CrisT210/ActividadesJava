package com.cristian.listaestudiantes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cristian.listaestudiantes.models.Contacto;
import com.cristian.listaestudiantes.models.Estudiante;
import com.cristian.listaestudiantes.repositories.ContactoRepository;
import com.cristian.listaestudiantes.repositories.EstudianteRepository;

@Service
public class ApiService {

	private final EstudianteRepository studentRepo;
	private final ContactoRepository contactRepo;
	
	public ApiService(EstudianteRepository studentRepo, ContactoRepository contactRepo) {
		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
	}
	
	public Estudiante crearEstudiante(Estudiante estudiante) {
		return studentRepo.save(estudiante);
	}
	
	public Contacto crearContacto(Contacto contacto) {
		return contactRepo.save(contacto);
	}
	
	public List<Estudiante> allStudent(){
		return studentRepo.findAll();
	}
	
}
