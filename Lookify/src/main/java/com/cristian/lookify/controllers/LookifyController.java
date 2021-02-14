package com.cristian.lookify.controllers;

import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cristian.lookify.models.Cancion;
import com.cristian.lookify.services.LookifyService;

@Controller
public class LookifyController {
	
	private final LookifyService lookifyServ;
	
	public LookifyController(LookifyService lookifyServ) {
		this.lookifyServ = lookifyServ;
	}
	
	@RequestMapping("")
	public String index() {
		return "/views/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("artista") Cancion song) {
		List<Cancion> songs = lookifyServ.allSongs();
		model.addAttribute("songs", songs);
		return "/views/dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Cancion song) {
		return "/views/newsong.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Cancion song, BindingResult result) {
		if (result.hasErrors()) {
        	return "/views/newsong.jsp";
        } else {
            lookifyServ.createSong(song);
            return "redirect:/dashboard";
        }
	}
	
	@RequestMapping("/songs/{id}")
	public String showSong(Model model, @PathVariable("id") Long id) {
		Cancion song = lookifyServ.infoSong(id);
		model.addAttribute("song", song);
		return "/views/showsong.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String dropSong(@PathVariable("id") Long id) {
        lookifyServ.deleteSong(id);
        return "redirect:/dashboard";
    }
	
	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
	public String searchDasboard(Model model, @RequestParam("artista") String search) {
		return "redirect:/search/"+search;
	}
	
	@RequestMapping("/search/{search}")
	public String listSong(Model model, @PathVariable("search") String search) {
		List<Cancion> listado = lookifyServ.allSongArtist(search);
		model.addAttribute("search", search);
		model.addAttribute("listado", listado);
		return "/views/search.jsp";
	}
	
	@RequestMapping("search/topTen")
	public String top(Model model) {
		List<Cancion> songs = lookifyServ.allSongs();
		// Ordena la lista de mayor Clasificacion a menor 
		songs.sort(Comparator.comparing(Cancion::getClasificacion).reversed());
		model.addAttribute("songs", songs);
		return "/views/top.jsp";
	}

}
