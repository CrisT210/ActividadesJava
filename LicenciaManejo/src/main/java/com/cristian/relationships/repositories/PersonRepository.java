package com.cristian.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

	//Este método recupera todos las personas de la base de datos
    List<Person> findAll();
    //Este método encuentra un lenguaje por su nombre
    List<Person> findByFirstNameContaining(String search);
    //Este método cuenta cuántos lenguajes contiene cierta cadena en el título
    Long countByIdContaining(String search);
    //Este método borra un lenguaje que empieza con un nombre específico
    Long deleteByFirstNameStartingWith(String search);
	
}
