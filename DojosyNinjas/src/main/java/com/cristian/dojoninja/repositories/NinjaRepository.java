package com.cristian.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.dojoninja.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{

	List<Ninja> findAll();
	List<Ninja> findByNombreContaining(String search);
	List<Ninja> findByDojoContaining(String search);
	
}
