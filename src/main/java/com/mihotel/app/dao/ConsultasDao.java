package com.mihotel.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultasDao {
private final EntityManager lem_manager;
    
    public ConsultasDao()
    {
        EntityManagerFactory lemf_managerFactory;
        lemf_managerFactory = Persistence.createEntityManagerFactory("hotelPU");
        lem_manager = lemf_managerFactory.createEntityManager();
    }
    
    @SuppressWarnings("unchecked")
	public List<Servicio> findServicioByAgendamiento(int idAgendamiento) {
    	List<Servicio> servicios;
    	servicios = lem_manager.createQuery("SELECT s FROM Servicio s WHERE id_agendamiento = ?1")
    	.setParameter(1, idAgendamiento)
    	.getResultList();
    	
    	lem_manager.close();
    	
    	return servicios;
    }
    
    @SuppressWarnings("unchecked")
	public List<Acompanantes> findAcompananteByAgendamiento(int idAgendamiento) {
    	List<Acompanantes> acompanantes;
    	acompanantes = lem_manager.createQuery("SELECT ac FROM Acompanantes ac  WHERE id_agendamiento = ?1")
    	.setParameter(1, idAgendamiento)
    	.getResultList();
    	
    	lem_manager.close();
    	
    	return acompanantes;
    }
}
