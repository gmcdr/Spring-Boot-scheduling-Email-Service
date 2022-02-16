package com.agendamento.tranca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.agendamento.tranca.exceptions.EmailException;
import com.agendamento.tranca.model.Scheduling;
import com.agendamento.tranca.repository.SchedulingRepository;

@Service
public class SchedulingService {
	
	@Autowired
	private SchedulingRepository repository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	public Scheduling createScheduling(Scheduling scheduling)  throws Exception{
		
		try {
			if(repository.findByEmail(scheduling.getEmail()) != null) {
				throw new EmailException("Usuário já cadastrado !");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		sendMsg(scheduling);
		return repository.save(scheduling);
	}
	
	 private void sendMsg(Scheduling scheduling) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("gabrielreismc@gmail.com");
	        message.setTo("gabrielreismc@gmail.com");
	        message.setTo(scheduling.getEmail());
	        message.setSubject("Preferência de Agendamento: ");
	        message.setText(scheduling.toString());
	        emailSender.send(message);
	    }

}
