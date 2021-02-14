package com.cristian.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.lookify.models.Cancion;

@Repository
public interface LookifyRepository extends CrudRepository<Cancion, Long>{

	//Este método recupera todos las canciones de la base de datos
    List<Cancion> findAll();
    //Este método encuentra una cancion por su artista
    List<Cancion> findByArtistaContaining(String search);
  //Este método encuentra una cancion por su titulo
    List<Cancion> findByTituloContaining(String search);
    //Este método cuenta cuántas canciones contiene cierta cadena en el artista
    Long countByArtistaContaining(String search);
    //Este método borra un lenguaje que empieza con un nombre específico
    Long deleteByTituloStartingWith(String search);
	
}
