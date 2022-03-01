package com.agendamento.tranca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.agendamento.tranca.model.Scheduling;
import com.agendamento.tranca.repository.SchedulingRepository;

@Service
public class SchedulingService {
	
	@Autowired
	private SchedulingRepository repository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	 private void sendMsg(Scheduling scheduling) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("isabelacarvalhotrancista@gmail.com");
	        message.setTo("isabelacarvalhotrancista@gmail.com");
	        message.setTo(scheduling.getEmail());
	        message.setSubject("Preferência de Agedamento! ");
	        message.setText(scheduling.toString());
	        emailSender.send(message);
	  }
	 
	 private void sendMsgEditar(Scheduling scheduling) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("isabelacarvalhotrancista@gmail.com");
	        message.setTo("isabelacarvalhotrancista@gmail.com");
	        message.setTo(scheduling.getEmail());
	        message.setSubject("Preferência de Agendamento Editado!! ");
	        message.setText(scheduling.toStringEditado());
	        emailSender.send(message);
	    }
	 
	 public void sendMsgConfirmar(Scheduling scheduling) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("isabelacarvalhotrancista@gmail.com");
	        message.setTo("isabelacarvalhotrancista@gmail.com");
	        message.setTo(scheduling.getEmail());
	        message.setSubject("Agendamento Confirmado!! ");
	        message.setText(scheduling.confirmado());
	        emailSender.send(message);
	    }
	 	 
	public Scheduling createScheduling(Scheduling scheduling) {
			sendMsg(scheduling);
			return 	repository.save(scheduling);
	}
	 
	 public Scheduling findByDate(Scheduling scheduling) {
		 return repository.findByData(scheduling.getData());
	 }
	 
	 public Scheduling findByCodigo(Long id) {
		 return repository.findByCodigo(id);
	 }
	 
		public Scheduling save(Scheduling scheduling) {
			sendMsgEditar(scheduling);
			return 	repository.save(scheduling);
	}
		
	

}
