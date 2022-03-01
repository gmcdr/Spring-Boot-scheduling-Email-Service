package com.agendamento.tranca.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/excluir/{codigo}")
	public String excluirAgendamento(@PathVariable("codigo") Long codigo) {
		repository.deleteById(codigo);
		return "redirect:/admin";
	}
	
	@GetMapping("/confirmar/{codigo}")
	public String excluirConfirmar(@PathVariable("codigo") Long codigo) {
		Scheduling agendamento = service.findByCodigo(codigo);
		service.sendMsgConfirmar(agendamento);
		repository.deleteById(codigo);
		return "redirect:/admin";
	}
	
	@GetMapping("/update/{codigo}")
    public String updateAgendamentoForm(@PathVariable("codigo")Long codigo, Model model) {
        Scheduling agendamento = service.findByCodigo(codigo);
        model.addAttribute("agendamento", agendamento);
        return "admin/alterar_agendamento";
    }
	

    @PostMapping("/update/{codigo}")
    public String updateAgendamento(Scheduling scheduling) {
            service.save(scheduling);
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
	
}

