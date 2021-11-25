package com.mihotel.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mihotel.app.dao.Acompanantes;
import com.mihotel.app.dao.ConsultasDao;
import com.mihotel.app.repository.AcompananteRepository;
import com.mihotel.app.service.AcompananteService;

@Service
public class AcompananteServiceImpl implements AcompananteService {

	@Autowired
	private AcompananteRepository acompananteRepository;

	@Override
	public List<Acompanantes> findByAgendamiento(int id) {
		return new ConsultasDao().findAcompananteByAgendamiento(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Acompanantes> findById(int id) {
		return acompananteRepository.findById(id);
	}
}
