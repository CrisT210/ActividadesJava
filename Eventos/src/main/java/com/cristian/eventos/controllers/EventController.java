package com.cristian.eventos.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cristian.eventos.models.Event;
import com.cristian.eventos.models.Message;
import com.cristian.eventos.models.User;
import com.cristian.eventos.services.EventService;
import com.cristian.eventos.validator.UserValidator;

@Controller
public class EventController {
	
	private final EventService service;
	private final UserValidator userVal;
	
	public EventController(EventService service, UserValidator userVal) {
		this.service = service;
		this.userVal = userVal;
	}

	@RequestMapping("")
	public String index(@ModelAttribute("register") User user, Model model) {
		model.addAttribute("states", service.allState());
		return "/index.jsp";
	}
	
	@RequestMapping(value="/registered", method=RequestMethod.POST)
	public String registeredUser(@Valid @ModelAttribute("register") User user, BindingResult result, HttpSession session, Model model) {
		userVal.validate(user, result);
		if(result.hasErrors()) {
			model.addAttribute("states", service.allState());
			return "/index.jsp";
		}else {
			service.registerUser(user);
			session.setAttribute("session", user.getId());
			return "redirect:/events";
		}	
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model,@ModelAttribute("register") User log) {
		if(service.authenticateUser(email, password) == true) {
			User user = service.searchUserEmail(email);
			session.setAttribute("session", user.getId());
			return "redirect:/events";
		}else {
			model.addAttribute("error", "Error al verificar su Email o Password");
			return "/index.jsp";
		}
	}
	
	@RequestMapping("/events")
	public String events(HttpSession session, Model model,@ModelAttribute("event") Event event) {
		Long id = (Long) session.getAttribute("session");
		User user = service.infoUser(id);
		List<Event> eventsState = new ArrayList<>();
		List<Event> eventsOutState = new ArrayList<>();
		for(Event e : service.allEvents()) {
			if(user.getState().equals(e.getState())) {
				eventsState.add(e);
			}else {
				eventsOutState.add(e);
				
			}
		}
		model.addAttribute("eventsState", eventsState);
		model.addAttribute("eventsOutState", eventsOutState);
		model.addAttribute("user", user);
		model.addAttribute("states", service.allState());
		return "/events.jsp";
	}
	
	@RequestMapping("/events/{id}")
	public String detailEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Event event = service.infoEvent(id);
		int count = event.getUsers().size();
		model.addAttribute("count", count);
		model.addAttribute("event", event);
		List<Message> comments = new ArrayList<>();
		for(Message m : service.allMessages()) {
			if(m.getEvent().equals(event)) {
				comments.add(m);
			}
		}
		model.addAttribute("comments", comments);
		return "/detailEvent.jsp";
	}
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.POST)
	public String createMessage(@RequestParam("comment") String comment, @PathVariable("id") Long id, Model model, HttpSession session) {
		Long idUser = (Long) session.getAttribute("session");
		Event event = service.infoEvent(id);
		User user = service.infoUser(idUser);
		Message msn = new Message(comment, user, event);
		service.createMessage(msn);
		return "redirect:/events/"+ event.getId();
	}
	
	@RequestMapping(value="/events", method=RequestMethod.POST)
	public String createEvent(Model model, @Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		Long id = (Long) session.getAttribute("session");
		User user = service.infoUser(id);
		event.setHost(user);
		if(result.hasErrors()) {
			List<Event> eventsState = new ArrayList<>();
			List<Event> eventsOutState = new ArrayList<>();
			for(Event e : service.allEvents()) {
				if(user.getState().equals(e.getState())) {
					eventsState.add(e);
				}else {
					eventsOutState.add(e);
				}
			}
			model.addAttribute("eventsState", eventsState);
			model.addAttribute("eventsOutState", eventsOutState);
			model.addAttribute("user", user);
			model.addAttribute("states", service.allState());
			return "/events.jsp";
		}else {
			service.createEvent(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@RequestParam("idUser") Long idUser, @RequestParam("idEvent") Long idEvent, HttpSession session) {
		Long id = (Long) session.getAttribute("session");
		User user = service.infoUser(id);
		Event event = service.infoEvent(idEvent);
		service.addEventUser(event, user);
		return "redirect:/events";
	}
	
	@RequestMapping(value="/cancel/{idUser}", method=RequestMethod.DELETE)
	public String cancel(@PathVariable("idUser") Long idUser, @RequestParam("idEvent") Long idEvent, HttpSession session){
		Long id = (Long) session.getAttribute("session");
		User user = service.infoUser(id);
		Event event = service.infoEvent(idEvent);
		service.cancelEvent(event, user);
		return "redirect:/events";
	}
	
	@RequestMapping(value="/delete/{idEvent}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("idEvent") Long idEvent) {
		service.deleteEvent(idEvent);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}/edit")
	public String editEvent(Model model, @PathVariable("id") Long id, @ModelAttribute("event") Event event) {
		Event e = service.infoEvent(id);
		model.addAttribute("states", service.allState());
		model.addAttribute("event", e);
		return "/editEvent.jsp";
	}
	
	@RequestMapping(value="/events/{id}/edit", method=RequestMethod.PUT)
	public String updateEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession session) {
		User user = service.infoUser((Long) session.getAttribute("session"));
		event.setHost(user);
		if(result.hasErrors()) {
			Event e = service.infoEvent(id);
			model.addAttribute("states", service.allState());
			model.addAttribute("event", e);
			return "/editEvent.jsp";
		}else {
			service.updateEvent(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
