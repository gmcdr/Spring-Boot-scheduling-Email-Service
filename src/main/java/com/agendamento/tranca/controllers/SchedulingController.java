package com.agendamento.tranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agendamento.tranca.model.Scheduling;
import com.agendamento.tranca.services.SchedulingService;

@Controller
public class SchedulingController {

	@Autowired
	private SchedulingService service;
	
	
	@GetMapping("/agendar")
	public ModelAndView Agendar(Scheduling scheduling) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clientes/agendamento");
		mv.addObject("agendamento", new Scheduling());
		return mv;
		
	}
	
	@PostMapping("/agendar")
	public ModelAndView Enviar(Scheduling scheduling) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/agendar");
		service.createScheduling(scheduling);
		return mv;
		
	}
	
}
