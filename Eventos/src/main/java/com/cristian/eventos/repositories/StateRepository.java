package com.cristian.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.eventos.models.State;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

	List<State> findAll();
	
}
