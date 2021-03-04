package com.cristian.dojoverflow.controllers;

import java.util.Arrays;
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

import com.cristian.dojoverflow.models.Answer;
import com.cristian.dojoverflow.models.Question;
import com.cristian.dojoverflow.models.Tag;
import com.cristian.dojoverflow.services.DojoOverflowService;

@Controller
@RequestMapping("/questions")
public class DojoOverflowController {
	
	private final DojoOverflowService service;
	
	public DojoOverflowController(DojoOverflowService service) {
		this.service = service;
	}
	
	@RequestMapping("")
	public String listQuestions(Model model) {
		model.addAttribute("questions", service.allQuestions());
		return "/questions.jsp";
	}
	
	@RequestMapping("/new")
	public String newQuestion(@ModelAttribute("quest") Question question) {
		return "/newquestion.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String createQuestionTag(@Valid @ModelAttribute("quest") Question question, BindingResult result, @RequestParam("tag") String tags, Model model) {
		if (result.hasErrors()) {
            return "/newquestion.jsp";
        } else {
        	Question saveQuestion = service.crearQuestion(question);
        	List<String> arrTags = Arrays.asList(tags.split("\\s*,\\s*"));
        	for(String tag : arrTags) {
    			if(service.allTagNames().contains(tag) == false) {
    				Tag saveTag = service.crearTag(new Tag(tag));
    				service.addTagQuestion(saveTag, saveQuestion);
    			} else {
    				service.addTagQuestion(service.searchTagName(tag), saveQuestion);
    			}
    		}
        	model.addAttribute("questions", service.allQuestions());
            return "redirect:/questions";
        }
	}
	
	@RequestMapping("/{id}")
	public String detailQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("ans") Answer answer) {
		model.addAttribute("question", service.infoQuestion(id));
		return "detailquestion.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String createAnswer(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("ans") Answer answer, BindingResult result) {
		Question q = service.infoQuestion(id);
		if(result.hasErrors()) {
			model.addAttribute("question", q);
			return "detailquestion.jsp";
		}else {
			service.createAnswer(answer);
			return "redirect:/questions/"+ q.getId();
		}
	}

}
