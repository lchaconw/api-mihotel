package com.mihotel.app.service;

import java.util.List;
import java.util.Optional;

import com.mihotel.app.dao.Acompanantes;

public interface AcompananteService {
	List<Acompanantes> findByAgendamiento(int id);
	
	public Optional<Acompanantes> findById(int id);
}
