package com.cristian.dojoninja.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cristian.dojoninja.models.Dojo;
import com.cristian.dojoninja.models.Ninja;
import com.cristian.dojoninja.services.DojoNinjaService;
import com.cristian.dojoninja.services.DojoService;
import com.cristian.dojoninja.services.NinjaService;

@Controller
public class DojoNinjaController {
	
	private final DojoNinjaService dnServ;
	private final DojoService dService;
	
	public DojoNinjaController(DojoNinjaService dnServ, DojoService dService) {
		this.dnServ = dnServ;
		this.dService = dService;
	}

	@RequestMapping("/dojos/new")
	public String indexDojo() {
		return "/views/newdojo.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String nuevoDojo(@RequestParam("nombre") String nombre) {
		Dojo dojo = new Dojo(nombre);
		dnServ.crearDojo(dojo);
		return "redirect:/dojos/new"; 	
	}
	
	@RequestMapping("/ninjas/new")
	public String indexNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dnServ.listaDojos();
		model.addAttribute("dojos", dojos);
		return "/views/newninja.jsp";
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String nuevoNinja(@ModelAttribute("ninja") Ninja ninja) {
		dnServ.crearNinja(ninja);
		return "redirect:/ninjas/new";
	}
	
	@RequestMapping("/dojos/{id}")
	public String listaDojo(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dnServ.infoDojo(id);
		model.addAttribute("dojo", dojo);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("ninjas", ninjas);
		return "/views/listado.jsp";
	}
	
//	@RequestMapping("/JPQL")
//	public String listJoin(Model model) {
//		model.addAttribute("table", dnServ.listJoin());
//		return "/views/vistaJPQL.jsp";
//	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    //Tenemos que restar 1 porque las páginas iterables empiezan con índice 0. Esto es para que nuestros enlaces puedan mostrarse desde 1...maxPage(última página) 
	    Page<Object[]> dojos = dService.dojoAndNinjaPerPage(pageNumber - 1);
	    //Total número de páginas que tenemos
	    int totalPages = dojos.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("dojos", dojos);
	    return "/views/ninjas.jsp";
	}

	
}
