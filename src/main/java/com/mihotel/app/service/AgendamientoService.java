package com.mihotel.app.service;

import java.util.Optional;

import com.mihotel.app.dao.Agendamiento;

public interface AgendamientoService {
	public Iterable<Agendamiento> findAll();
	
	public Optional<Agendamiento> findById(int id);
}
