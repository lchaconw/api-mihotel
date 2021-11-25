package com.mihotel.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mihotel.app.dao.Persona;
import com.mihotel.app.repository.PersonaRepository;
import com.mihotel.app.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findAll() {
		return personaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> findById(int id) {
		return personaRepository.findById(id);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		personaRepository.deleteById(id);
	}
}
