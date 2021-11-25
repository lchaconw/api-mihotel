package com.mihotel.app.service;

import java.util.List;
import java.util.Optional;

import com.mihotel.app.dao.Servicio;

public interface ServicioService {
	public Iterable<Servicio> findAll();
	
	public Optional<Servicio> findById(int id);

	List<Servicio> findByAgendamiento(int id);
}
