package com.agendamento.tranca.controllers;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

=======
>>>>>>> 9e6afe93c57db1bc665925c862f4717a829fcdce
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> 9e6afe93c57db1bc665925c862f4717a829fcdce
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.agendamento.tranca.model.Scheduling;
<<<<<<< HEAD
import com.agendamento.tranca.repository.SchedulingRepository;
import com.agendamento.tranca.services.SchedulingService;import lombok.experimental.PackagePrivate;
=======
import com.agendamento.tranca.services.SchedulingService;
>>>>>>> 9e6afe93c57db1bc665925c862f4717a829fcdce

@Controller
public class SchedulingController {

	@Autowired
	private SchedulingService service;
	
<<<<<<< HEAD
=======
	
>>>>>>> 9e6afe93c57db1bc665925c862f4717a829fcdce
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
	
<<<<<<< HEAD
	
	@Autowired
	private SchedulingRepository repository;
	
	@GetMapping(value="/admin")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cliente",  repository.findAll());
		mv.addObject("clienteP",  new Scheduling());
		mv.setViewName("admin/allScheduling");
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirAgendamento(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:/admin";
	}
	
	
	@GetMapping("/{id}")
	public String formAtualizar(@PathVariable Long id,  Model model) {
		model.addAttribute("agendamento", service.findAgendamento(id));
		return "admin/alterar_agendamento";
	}
	
	@PostMapping("/update")
	public String atualizarAgendamento( Scheduling scheduling) {
			service.atualizarAgendamento(scheduling);
			return "redirect:/admin";
	}
	
	
	@PostMapping(value="/admin")
	public ModelAndView pesquisar(@RequestParam(required = false) String name){
		ModelAndView mv = new ModelAndView();
		List<Scheduling> listaAgendamentos;
		if(name == null || name.trim().isEmpty()) {
			listaAgendamentos = repository.findAll();
		}else {
			listaAgendamentos = repository.findByNameContainingIgnoreCase(name);
		}
		mv.addObject("ListaDeClientes", listaAgendamentos);
		mv.setViewName("admin/pesquisa");
		return mv;
	}
	



=======
>>>>>>> 9e6afe93c57db1bc665925c862f4717a829fcdce
}
