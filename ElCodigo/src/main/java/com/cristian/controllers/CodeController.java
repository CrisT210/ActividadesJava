package com.cristian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	
	@RequestMapping(value="/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/code")
	public String code() {
		return "code.jsp";
	}
	
	@RequestMapping(value="/validar", method=RequestMethod.POST)
	public String error(@RequestParam(value="codigo") String codigo, RedirectAttributes redict) {
		System.out.println(codigo);
		if(codigo.equals("bushido")) {
			return "redirect:/code";
		}else {
			redict.addFlashAttribute("error", "Debes entrenar más duro");
			return "redirect:/";
		}
	}
}
