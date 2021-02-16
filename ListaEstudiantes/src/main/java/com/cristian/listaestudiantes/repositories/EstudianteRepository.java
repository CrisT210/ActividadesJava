package com.cristian.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.listaestudiantes.models.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Long>{

	// Lista de todos los estudiantes
	List<Estudiante> findAll();
	//Este método encuentra un estudiante por su nombre
    List<Estudiante> findByNombreContaining(String search);
    //Este método cuenta cuántos lenguajes contiene cierta cadena en el título
    Long countByNombreContaining(String search);
    //Este método borra un lenguaje que empieza con un nombre específico
    Long deleteByNombreStartingWith(String search);
	
	
}
