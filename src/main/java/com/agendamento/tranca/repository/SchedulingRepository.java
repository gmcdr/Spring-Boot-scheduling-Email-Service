package com.agendamento.tranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamento.tranca.model.Scheduling;


public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {

}
