package com.mihotel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihotel.app.dao.Agendamiento;

@Repository
public interface AgendamientoRepository extends JpaRepository<Agendamiento, Integer> {
	
}
