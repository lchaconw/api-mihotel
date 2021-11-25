package com.mihotel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihotel.app.dao.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
	
}
