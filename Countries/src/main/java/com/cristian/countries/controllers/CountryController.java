package com.cristian.countries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cristian.countries.services.ApiService;

@Controller
public class CountryController {
	
	private final ApiService service;
	
	public CountryController(ApiService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("slo", service.listaEsloveno());
		model.addAttribute("count", service.totalCiudades());
		model.addAttribute("mex", service.poblacionMexico());
		model.addAttribute("lang", service.languagesWorld());
		model.addAttribute("area", service.areaPopulationWorld());
		model.addAttribute("monarchy", service.monarchy());
		model.addAttribute("arg", service.citiesArg());
		model.addAttribute("continent", service.countCountries());
		return "/index.jsp";
	}
	
}
