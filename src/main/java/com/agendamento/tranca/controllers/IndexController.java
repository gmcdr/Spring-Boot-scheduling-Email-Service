package com.agendamento.tranca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mv	= new ModelAndView();
		mv.setViewName("home/index");
		return mv;
	}
	
}
