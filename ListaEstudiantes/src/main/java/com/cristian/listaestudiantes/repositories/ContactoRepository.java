package com.cristian.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.listaestudiantes.models.Contacto;

@Repository
public interface ContactoRepository extends CrudRepository<Contacto, Long> {

	// Lista de todos los contactos
	List<Contacto> findAll();
	//Este método encuentra un contacto por su direccion
	List<Contacto> findByDireccionContaining(String search);
	//Este método cuenta cuántos contactos contiene cierta cadena en el título
	Long countByComunaContaining(String search);
	//Este método borra un lenguaje que empieza con un id específico
	Long deleteByIdStartingWith(String search);
	
}
