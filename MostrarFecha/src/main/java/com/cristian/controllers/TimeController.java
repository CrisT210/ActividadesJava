package com.cristian.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimeController {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model fecha) {
		Date date = new Date();
//		String fecha = date.toString();
//		System.out.println(fecha);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, dd 'de' MMMMM, YYYY");
//		System.out.println(dateFormat.format(date));
		fecha.addAttribute("fecha", dateFormat.format(date));
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model hora) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
		hora.addAttribute("hora", dateFormat.format(date));
		
		return "time.jsp";
	}

}
