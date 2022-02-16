package com.agendamento.tranca.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agendamento.tranca.model.Scheduling;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {
		
		@Query(" select i from Scheduling i where i.email = :email")
		public Scheduling findByEmail(String email);
		
}
