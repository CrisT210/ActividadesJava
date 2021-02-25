package com.cristian.eventos.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.cristian.eventos.models.Event;
import com.cristian.eventos.models.Message;
import com.cristian.eventos.models.State;
import com.cristian.eventos.models.User;
import com.cristian.eventos.repositories.EventRepository;
import com.cristian.eventos.repositories.MessageRepository;
import com.cristian.eventos.repositories.StateRepository;
import com.cristian.eventos.repositories.UserRepository;

@Service
public class EventService {
	
	private final UserRepository userRepo;
	private final StateRepository stateRepo;
	private final EventRepository eventRepo;
	private final MessageRepository msnRepo;
	
	public EventService(UserRepository userRepo, StateRepository stateRepo, EventRepository eventRepo, MessageRepository msnRepo) {
		this.userRepo = userRepo;
		this.stateRepo = stateRepo;
		this.eventRepo = eventRepo;
		this.msnRepo = msnRepo;
	}
	
	public List<State> allState(){
		return stateRepo.findAll();
	}
	
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return userRepo.save(user);
	}
	
	public User searchUserEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return false;
		}else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public User infoUser(Long id) {
		Optional<User> op = userRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public List<Event> allEvents(){
		return eventRepo.findAll();
	}
	
	public Event infoEvent(Long id) {
		Optional<Event> op = eventRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public void addEventUser(Event e, User u) {
		e.getUsers().add(u);
		eventRepo.save(e);
		userRepo.save(u);
	}
	
	public Message createMessage(Message msn) {
		return msnRepo.save(msn);
	}
	
	public List<Message> allMessages(){
		return msnRepo.findAll();
	}
	
	public void cancelEvent(Event e, User u) {
		e.getUsers().remove(u);
		eventRepo.save(e);
		userRepo.save(u);
	}
	
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}
	
	public Event updateEvent(Event event) {
		return eventRepo.save(event);
	}

}
