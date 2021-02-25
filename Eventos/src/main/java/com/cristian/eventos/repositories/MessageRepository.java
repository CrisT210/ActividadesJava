package com.cristian.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristian.eventos.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
	
	List<Message> findAll();
	
}
