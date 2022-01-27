package com.agendamento.tranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agendamento.tranca.model.Scheduling;
import com.agendamento.tranca.repository.SchedulingRepository;

@Controller
public class SchedulingController {

	@Autowired
	private  SchedulingRepository repository;
	
	
	@GetMapping("/agendar")
	public ModelAndView Agendar(Scheduling scheduling) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clientes/agendamento");
		mv.addObject("agendamento", new Scheduling());
		return mv;
		
	}
	
	@PostMapping("agenda")
	public ModelAndView Enviar(Scheduling scheduling) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:clientes/agendamento");
		repository.save(scheduling);
		return mv;
		
	}
	
}
