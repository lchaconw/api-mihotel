package com.mihotel.app.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "servicio")
/*@NamedQueries({
	@NamedQuery(name="Servicio.findById", query="SELECT s FROM servicio s WHERE s.id_servicio = :idServicio")
	, @NamedQuery(name="Servicio.findByAgendamiento", query="SELECT s FROM servicio s WHERE s.id_agendamiento = :idAgendamiento")
})*/
public class Servicio implements Serializable {

	private static final long serialVersionUID = -4834916282333752553L;

	@Column(name = "id_servicio")
	@Id
	private int idServicio;

	@Column(name = "id_agendamiento")
	private int idAgendamiento;

	private String nombre;
	private int precio;
	private int cantidad;

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public int getIdAgendamiento() {
		return idAgendamiento;
	}

	public void setIdAgendamiento(int idAgendamiento) {
		this.idAgendamiento = idAgendamiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", idAgendamiento=" + idAgendamiento + ", nombre=" + nombre
				+ ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}
}
