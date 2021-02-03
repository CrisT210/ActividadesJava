package com.cristian.encuestadojo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model) {
		ArrayList<String> ciudades = new ArrayList<String>();
		ciudades.add("Santiago");
		ciudades.add("Rancagua");
		ciudades.add("Concepcion");
		ciudades.add("Temuco");
		model.addAttribute("ciudades", ciudades);
		
		ArrayList<String> lenguajes = new ArrayList<String>();
		lenguajes.add("JavaScript");
		lenguajes.add("Python");
		lenguajes.add("SQL");
		lenguajes.add("C#");
		lenguajes.add("Ruby");
		lenguajes.add("Java");
		model.addAttribute("lenguajes", lenguajes);
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String result(Model model, @RequestParam(value="nom") String nom, @RequestParam(value="ubi") String ubi, @RequestParam(value="leng") String leng, @RequestParam(value="com") String com) {
		if(leng.equals("Java")) {
			model.addAttribute("nom", nom);
			model.addAttribute("ubi", ubi);
			model.addAttribute("leng", leng);
			model.addAttribute("com", com);
			return "page-java.jsp";
		}else {
			model.addAttribute("nom", nom);
			model.addAttribute("ubi", ubi);
			model.addAttribute("leng", leng);
			model.addAttribute("com", com);
			return "result.jsp";
		}	
	}
	
}
