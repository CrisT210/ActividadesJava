package com.cristian.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristian.eventos.models.Event;

public interface EventRepository extends CrudRepository<Event, Long>{
	
	List<Event> findAll();

}
