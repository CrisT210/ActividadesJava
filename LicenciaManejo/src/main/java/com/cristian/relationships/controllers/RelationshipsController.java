package com.cristian.relationships.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cristian.relationships.models.License;
import com.cristian.relationships.models.Person;
import com.cristian.relationships.services.RelationshipsService;

@Controller
public class RelationshipsController {
	
	private final RelationshipsService relServ;

	public RelationshipsController(RelationshipsService relServ) {
		this.relServ = relServ;
	}

	@RequestMapping("/persons/new")
	public String Person(@ModelAttribute("person") Person person) {
		return "/views/person.jsp";
	}
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String crearPerson(@ModelAttribute("person") Person person) {
		relServ.crearPerson(person);
		return "redirect:/persons/new";
	}
	
	@RequestMapping("/licenses/new")
	public String license(Model model, @ModelAttribute("license") License license) {
		List<Person> persons = relServ.allPersons();
		model.addAttribute("persons", persons);
		return "/views/license.jsp";
	}
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String crearLicense(@ModelAttribute("license") License license) {
		relServ.crearLicense(license);
		return "redirect:/persons/"+ license.getPerson().getId();
    }
	
	@RequestMapping("/persons/{id}")
	public String detalleLicense(Model model, @PathVariable("id") Long id) {
		Person person = relServ.infoPerson(id);
		model.addAttribute("person", person);
		return "/views/detail.jsp";
	}
	
}
