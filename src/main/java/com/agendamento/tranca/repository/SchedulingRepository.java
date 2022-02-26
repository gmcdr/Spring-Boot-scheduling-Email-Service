package com.agendamento.tranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamento.tranca.model.Scheduling;

<<<<<<< HEAD
@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {

	@Query("SELECT i  FROM  Scheduling i WHERE i.data = :data")
	public Scheduling findByData(String data);
	
	
	public List<Scheduling> findByNameContainingIgnoreCase(String name);


	public Scheduling getById(Long id);
	
=======

public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {

>>>>>>> 9e6afe93c57db1bc665925c862f4717a829fcdce
}
