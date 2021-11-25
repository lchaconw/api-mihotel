package com.mihotel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihotel.app.dao.Acompanantes;

@Repository
public interface AcompananteRepository extends JpaRepository<Acompanantes, Integer> {
	
}
