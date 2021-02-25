package com.cristian.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	
	@RequestMapping("/gold")
	public String index(HttpSession s, Model model) {
		if(s.getAttribute("sesion") == null) {
			String sesion = "Sesion Iniciada";
			s.setAttribute("sesion", sesion);
			System.out.println("Sesion: "+ s.getAttribute("sesion"));
			
			int gold = 0;
			s.setAttribute("gold", gold);
			System.out.println("Oro: "+ s.getAttribute("gold"));
			model.addAttribute("gold", s.getAttribute("gold"));
			return "index.jsp";
		}
		return "index.jsp";
	}
	
	@RequestMapping(value="/gold", method=RequestMethod.POST)
	public String obtenerOro(HttpSession s, Model model, @RequestParam("opcion") int opcion) {
		Random rand = new Random();
		String output = null;
		int oroActividad = 0, oroActual, total;
		Date registroTiempo;
		SimpleDateFormat formato = new SimpleDateFormat("'('MMMMM dd yyyy h:mm a')'");
		
		if(s.getAttribute("log") == null) {
			ArrayList<String> log = new ArrayList<String>();
			s.setAttribute("log", log); 	
		}
		
		ArrayList<String> log = (ArrayList<String>) s.getAttribute("log");
		
			switch(opcion) {
			case 0:
				s.invalidate();
				return "redirect:/gold";
			case 1:
				oroActividad = rand.nextInt(21 - 10) + 10;
				registroTiempo = new Date();
				System.out.println("Oro granja: "+ oroActividad);
				output = "<p class='text-success mb-0'>Entraste a la granja y obtuviste "+ oroActividad + ". "+ formato.format(registroTiempo) +"</p>";
				break;
			case 2:
				oroActividad = rand.nextInt(11 - 5) + 5;
				registroTiempo = new Date();
				System.out.println("Oro cueva: "+ oroActividad);		
				output = "<p class='text-success mb-0'>Entraste a la cueva y obtuviste "+ oroActividad + ". "+ formato.format(registroTiempo) +"</p>";
				break;
			case 3:
				oroActividad = rand.nextInt(6 - 2) + 2;
				registroTiempo = new Date();
				System.out.println("Oro casa: "+ oroActividad);
				output = "<p class='text-success mb-0'>Entraste a la casa y obtuviste "+ oroActividad + ". "+ formato.format(registroTiempo) +"</p>";
				break;
			case 4:
				oroActividad = (rand.nextInt(101) - 50);
				registroTiempo = new Date();
				System.out.println("Oro casino: "+ oroActividad);
				if(oroActividad >= 0) {
					output = "<p class='text-success mb-0'>Entraste al casino y obtuviste "+ oroActividad + ". "+ formato.format(registroTiempo) +"</p>";
				}else {
					output = "<p class='text-danger mb-0'>Entraste al casino y obtuviste "+ oroActividad + ". "+ formato.format(registroTiempo) +"</p>";
				}
				break;
			case 5:
				oroActividad = (rand.nextInt(20 - 4) - 20);
				registroTiempo = new Date();
				System.out.println("Oro spa: "+ oroActividad);
				output = "<p class='text-danger mb-0'>Entraste al casino y obtuviste "+ oroActividad + ". "+ formato.format(registroTiempo) +"</p>";
			}
			
			oroActual = (int) s.getAttribute("gold");
			total = oroActividad + oroActual;
			if(total < -50) {
				return "redirect:/prison";
			}else {
				s.setAttribute("gold", total);
				model.addAttribute("gold", s.getAttribute("gold"));
				
				log.add(output);
				System.out.println(s.getAttribute("log"));
				model.addAttribute("historial", s.getAttribute("log"));
				
				return "index.jsp";
			}
	}
	
	@RequestMapping("/prison")
	public String prison() {
		return "prison.jsp";
	}
	
}
