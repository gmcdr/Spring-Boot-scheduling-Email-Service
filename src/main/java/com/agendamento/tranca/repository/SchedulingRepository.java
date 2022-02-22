package com.agendamento.tranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agendamento.tranca.model.Scheduling;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {

	@Query("SELECT i  FROM  Scheduling i WHERE i.data = :data")
	public Scheduling findByData(String data);
	
}
