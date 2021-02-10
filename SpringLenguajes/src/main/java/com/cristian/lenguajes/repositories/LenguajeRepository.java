package com.cristian.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.lenguajes.models.Lenguaje;

@Repository
public interface LenguajeRepository extends CrudRepository<Lenguaje, Long> {

	//Este método recupera todos los libros de la base de datos
    List<Lenguaje> findAll();
    //Este método encuentra un lenguaje por su nombre
    List<Lenguaje> findByNombreContaining(String search);
    //Este método cuenta cuántos lenguajes contiene cierta cadena en el título
    Long countByCreadorContaining(String search);
    //Este método borra un lenguaje que empieza con un nombre específico
    Long deleteByNombreStartingWith(String search);
	
}
