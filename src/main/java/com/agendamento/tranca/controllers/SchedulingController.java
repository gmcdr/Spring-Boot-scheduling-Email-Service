package com.agendamento.tranca.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agendamento.tranca.model.Scheduling;
import com.agendamento.tranca.repository.SchedulingRepository;
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
	
	@PostMapping(value="/agendar")
	public ModelAndView Enviar(@Valid Scheduling scheduling,  RedirectAttributes attributes ) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/agendar");
		if (service.findByDate(scheduling) != null) {
			//mv.addObject("msg", "Data cadastrada !");
			attributes.addFlashAttribute("msg", "Data já cadastrada! ");
			return mv;
		}else {
			String[] textoSeparado = scheduling.getData().split("-");
			
			scheduling.setMes(textoSeparado[1]);
			
			service.createScheduling(scheduling);
			return mv;
		}
		
	}
	
	
	/*
	@Autowired
	private SchedulingRepository repository;
	
	@GetMapping(value ="/admin")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listaAgendados", repository.findAll());
		mv.setViewName("admin/allScheduling");
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirAgendamento(@PathVariable("id") Integer id) {
		repository.deleteById(id);
		return "admin/allScheduling";
	}

*/
}

