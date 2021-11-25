package com.mihotel.app.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Acompanantes")
public class Acompanantes implements Serializable {

	private static final long serialVersionUID = 5674053516756718230L;

	@Column(name = "id_acompanante")
	@Id
	private int idAcompanante;

	private String nombre;
	
	@Column(name = "id_agendamiento")
	private int idAgendamiento;

	public int getIdAcompanante() {
		return idAcompanante;
	}

	public void setIdAcompanante(int idAcompanante) {
		this.idAcompanante = idAcompanante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdAgendamiento() {
		return idAgendamiento;
	}

	public void setIdAgendamiento(int idAgendamiento) {
		this.idAgendamiento = idAgendamiento;
	}

	@Override
	public String toString() {
		return "Acompanante [idAcompanante=" + idAcompanante + ", nombre=" + nombre + ", idAgendamiento="
				+ idAgendamiento + "]";
	}
}
