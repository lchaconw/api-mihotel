package com.mihotel.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mihotel.app.dao.Servicio;
import com.mihotel.app.dao.ConsultasDao;
import com.mihotel.app.repository.ServicioRepository;
import com.mihotel.app.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioRepository ServicioRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Servicio> findAll() {
		return ServicioRepository.findAll();
	}
	
	@Override
	public List<Servicio> findByAgendamiento(int id) {
		return new ConsultasDao().findServicioByAgendamiento(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Servicio> findById(int id) {
		return ServicioRepository.findById(id);
	}
}
