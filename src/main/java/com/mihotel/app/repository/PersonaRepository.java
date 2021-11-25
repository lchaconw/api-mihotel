package com.mihotel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihotel.app.dao.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
}
