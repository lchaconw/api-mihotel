package com.mihotel.app.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "agendamiento")
public class Agendamiento implements Serializable {

	private static final long serialVersionUID = -4834916282333752553L;

	@Column(name = "id_agendamiento")
	@Id
	private int idAgendamiento;

	@Column(name = "id_cliente")
	private int idCliente;

	private int acompanantes;

	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	@Column(name = "dias_reserva")
	private int diasReserva;
	
	private int planTodoIncluido;
	
	public int getPlanTodoIncluido() {
		return planTodoIncluido;
	}

	public void setPlanTodoIncluido(int planTodoIncluido) {
		this.planTodoIncluido = planTodoIncluido;
	}

	@Transient
	private List<Servicio> serviciosContratados;	
	
	@Transient
	private List<Acompanantes> listaAcompanantes;
	
	@Transient
	private int pagoTotal;
	
	public List<Acompanantes> getListaAcompanantes() {
		return listaAcompanantes;
	}

	public void setListaAcompanantes(List<Acompanantes> listaAcompanantes) {
		this.listaAcompanantes = listaAcompanantes;
	}

	public int getPagoTotal() {
		return pagoTotal;
	}

	public void setPagoTotal(int pagoTotal) {
		this.pagoTotal = pagoTotal;
	}

	public List<Servicio> getServiciosContratados() {
		return serviciosContratados;
	}

	public void setServiciosContratados(List<Servicio> serviciosContratados) {
		this.serviciosContratados = serviciosContratados;
	}

	public int getIdAgendamiento() {
		return idAgendamiento;
	}

	public void setIdAgendamiento(int idAgendamiento) {
		this.idAgendamiento = idAgendamiento;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getAcompanantes() {
		return acompanantes;
	}

	public void setAcompanantes(int acompanantes) {
		this.acompanantes = acompanantes;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getDiasReserva() {
		return diasReserva;
	}

	public void setDiasReserva(int diasReserva) {
		this.diasReserva = diasReserva;
	}

	@Override
	public String toString() {
		return "Agendamiento [idAgendamiento=" + idAgendamiento + ", idCliente=" + idCliente + ", acompanantes="
				+ acompanantes + ", fechaIngreso=" + fechaIngreso + ", diasReserva=" + diasReserva + "]";
	}
}
