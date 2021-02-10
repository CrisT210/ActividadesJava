package com.cristian.lenguajes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cristian.lenguajes.models.Lenguaje;
import com.cristian.lenguajes.services.LenguajeService;

@Controller
@RequestMapping("/lenguajes")
public class LanguageController {
	
	private final LenguajeService lengServ;
	
	public LanguageController(LenguajeService lengServ) {
		this.lengServ = lengServ;
	}

	@RequestMapping("")
	public String index(Model model, @ModelAttribute("leng") Lenguaje leng) {
		List<Lenguaje> lengs = lengServ.allLenguajes();
        model.addAttribute("lengs", lengs);
		return "/views/index.jsp";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
    public String crear(@Valid @ModelAttribute("leng") Lenguaje leng, BindingResult result) {
        if (result.hasErrors()) {
        	return "/views/index.jsp";
        } else {
            lengServ.crearLeng(leng);
            return "redirect:/lenguajes";
        }
    }
	
	@RequestMapping("/{id}")
	public String mostrar(Model model, @PathVariable("id") Long id) {
		Lenguaje leng = lengServ.infoLeng(id);
		model.addAttribute("leng", leng);
		return "/views/show.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long id) {
        lengServ.borrarLeng(id);
        return "redirect:/lenguajes";
    }
	
	@RequestMapping("/{id}/editar")
	public String editar(@PathVariable("id") Long id, Model model) {
        Lenguaje leng = lengServ.infoLeng(id);
        model.addAttribute("leng", leng);
        return "/views/edit.jsp";
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String actualizar(@Valid @ModelAttribute("leng") Lenguaje leng, BindingResult result) {
        if (result.hasErrors()) {
            return "/views/edit.jsp";
        } else {
            lengServ.actualizarLeng(leng.getId(), leng.getNombre(), leng.getCreador(), leng.getVersion());
            return "redirect:/lenguajes";
        }
    }
	
	
	
}
