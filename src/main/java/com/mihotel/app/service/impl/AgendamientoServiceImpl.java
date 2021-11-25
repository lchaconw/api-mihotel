package com.mihotel.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mihotel.app.dao.Agendamiento;
import com.mihotel.app.repository.AgendamientoRepository;
import com.mihotel.app.service.AgendamientoService;

@Service
public class AgendamientoServiceImpl implements AgendamientoService {

	@Autowired
	private AgendamientoRepository agendamientoRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Agendamiento> findAll() {
		return agendamientoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Agendamiento> findById(int id) {
		return agendamientoRepository.findById(id);
	}
}
