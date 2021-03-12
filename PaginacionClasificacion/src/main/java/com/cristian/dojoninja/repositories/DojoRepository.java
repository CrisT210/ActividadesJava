package com.cristian.dojoninja.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cristian.dojoninja.models.Dojo;

@Repository
public interface DojoRepository extends PagingAndSortingRepository<Dojo, Long>{
	
	List<Dojo> findAll();
	List<Dojo> findByNombreContaining(String search);
	
	// obtener todos los dojos
    @Query("SELECT d FROM Dojo d")
    List<Dojo> findAllDojos();
    
    // obtener todos los nombre de los dojos.
    @Query("SELECT d.nombre From Dojo d")
    List<String> findAllDojosNames();
    
    // Pasar parámetros y filtrar (todavía devuelve una lista)
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    List<Dojo> getListDojoWhereId(Long id);
    
    // Pasando parámetros y filtrando.
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    Dojo getSingleDojoWhereId(Long id);
    
    @Modifying
    @Query("update Dojo d set d.nombre = ?1 WHERE d.id = ?2")
    int setNameForOne(String name, Long id);
    
    @Modifying
    @Query("update Dojo d set d.nombre = ?1")
    int setNameForAll(String name);
    
    @Modifying
    @Query("delete Dojo d WHERE d.id = ?1")
    int deleteOneDojo(Long id);
    
    // Seleccionar todo. Obtenemos una lista de objetos Dojo.
    @Query(value="SELECT * from dojos", nativeQuery=true)
    List<Dojo> findAllDojosWithNativeQuery();
    
    // Obtener todos los nombres y el id de los dojos. Si queremos seleccionar una columna específica, 
    // obtenemos un arreglo de objetos porque ya no son objetos Dojos. 
    // Cada índice del arreglo será la columna seleccionada respectivamente, por lo tanto, 0 = columna id, 1 = columna nombre.
    @Query(value="SELECT id, nombre from dojos", nativeQuery=true)
    List<Object[]> findAllDojosNamesWithId2();
    
    // Obtener un dojo.
    @Query(value="SELECT * FROM dojos WHERE id = ?1", nativeQuery=true)
    Dojo getDojoWhereId(Long id);
    
    // inner join para obtener solo los dojos
    @Query("SELECT d FROM Dojo d JOIN d.ninjas n")
    List<Dojo> joinDojosAndNinjas();
    
    // inner join para obtener los dojos y los ninjas
    @Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
    Page<Object[]> joinDojosAndNinjas2(PageRequest pageRequest);
	
}
