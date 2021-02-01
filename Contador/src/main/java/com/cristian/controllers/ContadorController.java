package com.cristian.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContadorController {
	
	@RequestMapping("/")
	public String index(HttpSession s) {
		if(s.getAttribute("count") == null) {
			int count = 0;
			count++;
			s.setAttribute("count", count);
			System.out.println(count);
			return "index.jsp";
		}else {
			int contador = (int) s.getAttribute("count");
			contador++;
			s.setAttribute("count", contador);
			System.out.println(contador);
			return "index.jsp";
		}
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession s, Model model, @RequestParam(value = "c", required = false) Integer reset) {
		System.out.println(reset);
		if(reset == null) {
			model.addAttribute("conteo", s.getAttribute("count"));
			return "counter.jsp";
		} else {
			s.setAttribute("count", reset);
			model.addAttribute("conteo", s.getAttribute("count"));
			return "counter.jsp";
		}
		
	}
	
	@RequestMapping("/counter-doble")
	public String counterDoble(HttpSession s) {
		if(s.getAttribute("count") == null) {
			int count = 0;
			count += 2;
			s.setAttribute("count", count);
			System.out.println(count);
			return "counter-doble.jsp";
		}else {
			int contador = (int) s.getAttribute("count");
			contador += 2;
			s.setAttribute("count", contador);
			System.out.println(contador);
			return "counter-doble.jsp";
		}
	}
	
}
