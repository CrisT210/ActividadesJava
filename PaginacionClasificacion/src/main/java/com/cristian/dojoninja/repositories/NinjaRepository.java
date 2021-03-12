package com.cristian.dojoninja.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cristian.dojoninja.models.Ninja;

@Repository
public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long>{

//	List<Ninja> findAll();
//	List<Ninja> findByNombreContaining(String search);
//	List<Ninja> findByDojoContaining(String search);
	
}
