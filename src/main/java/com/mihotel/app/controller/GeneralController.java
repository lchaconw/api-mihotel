package com.mihotel.app.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mihotel.app.dao.Acompanantes;
import com.mihotel.app.dao.Agendamiento;
import com.mihotel.app.dao.Persona;
import com.mihotel.app.dao.Servicio;
import com.mihotel.app.service.AcompananteService;
import com.mihotel.app.service.AgendamientoService;
import com.mihotel.app.service.PersonaService;
import com.mihotel.app.service.ServicioService;

@RestController
@RequestMapping("/api/")
public class GeneralController {

	@Autowired
	private PersonaService personaService;
	@Autowired
	private AgendamientoService agendamientoService;
	@Autowired
	private ServicioService servicioService;
	@Autowired
	private AcompananteService acompananteService;

	@GetMapping("users/{id}")
	public ResponseEntity<?> readPersona(@PathVariable int id) {
		Optional<Persona> oPersona = personaService.findById(id);

		if (!oPersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(oPersona);
	}

	@GetMapping("agendamientos/{id}")
	public ResponseEntity<?> readAgendamiento(@PathVariable int id) {
		Optional<Agendamiento> oAgendamiento = agendamientoService.findById(id);
		int valorTotal = 0;

		if (!oAgendamiento.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		List<Acompanantes> acompanantes = acompananteService.findByAgendamiento(oAgendamiento.get().getIdAgendamiento());
		oAgendamiento.get().setListaAcompanantes(acompanantes);
		
		List<Servicio> servicios = servicioService.findByAgendamiento(oAgendamiento.get().getIdAgendamiento());
		oAgendamiento.get().setServiciosContratados(servicios);
		
		if(!servicios.isEmpty()) {
			for(Servicio serv : servicios) {
				if(serv != null) {
					valorTotal = valorTotal + serv.getCantidad() * serv.getPrecio();
				}
			}
		}
		
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(oAgendamiento.get().getFechaIngreso());
		
		if(oAgendamiento.get().getPlanTodoIncluido() == 1) {
			valorTotal = valorTotal + oAgendamiento.get().getAcompanantes() * 90000;
		}
		
		for(int i=0; i < oAgendamiento.get().getDiasReserva(); i++) {
			if(i >= 1)
			{
				c.add(Calendar.DATE, 1);				
			}
			
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			
			if(oAgendamiento.get().getPlanTodoIncluido() == 1) {
				valorTotal = valorTotal + oAgendamiento.get().getAcompanantes() * 90000;
			}
			
			if(dayOfWeek <= 5) {
				valorTotal = valorTotal + 50000;
			} else {
				valorTotal = valorTotal + 90000;
			}
		}
		
		
		oAgendamiento.get().setPagoTotal(valorTotal);
		

		return ResponseEntity.status(HttpStatus.OK).body(oAgendamiento);
	}

	@GetMapping("servicios/{id}")
	public ResponseEntity<?> readServicio(@PathVariable int id) {
		Optional<Servicio> oServicio = servicioService.findById(id);

		if (!oServicio.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(oServicio);
	}

	@GetMapping("servicios")
	public ResponseEntity<?> readServiciosAll() {
		List<Servicio> servicios = StreamSupport.stream(servicioService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(servicios);
	}
	
	@GetMapping("servicios/agendamiento/{id}")
	public ResponseEntity<?> readServiciosByAgendamiento(@PathVariable int id) {
		List<Servicio> servicios = servicioService.findByAgendamiento(id);

		return ResponseEntity.status(HttpStatus.OK).body(servicios);
	}
	
	@GetMapping("acompanantes/{id}")
	public ResponseEntity<?> readServicioAcompanante(@PathVariable int id) {
		Optional<Acompanantes> oServicio = acompananteService.findById(id);

		if (!oServicio.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(oServicio);
	}
}
