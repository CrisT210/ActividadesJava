package com.cristian.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	
	//Este método recupera todos las personas de la base de datos
    List<License> findAll();
    //Este método encuentra un lenguaje por su nombre
    List<License> findByNumberContaining(String search);
    //Este método cuenta cuántos lenguajes contiene cierta cadena en el título
    Long countByStateContaining(String search);
    //Este método borra un lenguaje que empieza con un nombre específico
    Long deleteByNumberStartingWith(String search);

}
