package com.cristian.encuestadojo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String result(Model model, @RequestParam(value="nom") String nom, @RequestParam(value="ubi") String ubi, @RequestParam(value="leng") String leng, @RequestParam(value="com") String com) {
		model.addAttribute("nom", nom);
		model.addAttribute("ubi", ubi);
		model.addAttribute("leng", leng);
		model.addAttribute("com", com);
		return "result.jsp";
	}
	
}
