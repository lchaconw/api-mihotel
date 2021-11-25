package com.mihotel.app.service;

import java.util.Optional;

import com.mihotel.app.dao.Persona;

public interface PersonaService {
	public Iterable<Persona> findAll();
	
	public Optional<Persona> findById(int id);
	
	public Persona save(Persona persona);
	
	public void deleteById(int id);
}
