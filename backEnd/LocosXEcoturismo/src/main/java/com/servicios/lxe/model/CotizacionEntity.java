package com.servicios.lxe.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.servicios.lxe.dto.CotizacionDto;

@Entity
@Table(name = "cotizacion")
public class CotizacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_contizacion;
	@CreationTimestamp
	private LocalDateTime fecha_cotizacion;
	private long fecha_ini;
	private long fecha_fin;
	private int id_actividad;
	private int id_transporte;
	private int id_hospedaje;
	private int num_personas;
	private int estado_cotizacion;
	
	protected CotizacionEntity() {}
	
	public CotizacionEntity(CotizacionDto nuevaCotizacion) {
		super();
		this.fecha_ini = nuevaCotizacion.fechaInicio;
		this.fecha_fin = nuevaCotizacion.fechaFin;
		this.id_actividad = nuevaCotizacion.idActividad;
		this.id_transporte = nuevaCotizacion.idTransporte;
		this.id_hospedaje = nuevaCotizacion.idHospedaje;
		this.num_personas = nuevaCotizacion.numPersonas;
		this.estado_cotizacion = nuevaCotizacion.estadoCotizacion;
	}
	
	public int getId_contizacion() {
		return id_contizacion;
	}
	public void setId_contizacion(int id_contizacion) {
		this.id_contizacion = id_contizacion;
	}
	public LocalDateTime getFecha_cotizacion() {
		return fecha_cotizacion;
	}
	public void setFecha_cotizacion(LocalDateTime fecha_cotizacion) {
		this.fecha_cotizacion = fecha_cotizacion;
	}
	public long getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(long fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public long getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(long fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getId_actividad() {
		return id_actividad;
	}
	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}
	public int getId_transporte() {
		return id_transporte;
	}
	public void setId_transporte(int id_transporte) {
		this.id_transporte = id_transporte;
	}
	public int getId_hospedaje() {
		return id_hospedaje;
	}
	public void setId_hospedaje(int id_hospedaje) {
		this.id_hospedaje = id_hospedaje;
	}
	public int getNum_personas() {
		return num_personas;
	}
	public void setNum_personas(int num_personas) {
		this.num_personas = num_personas;
	}
	public int getEstado_cotizacion() {
		return estado_cotizacion;
	}
	public void setEstado_cotizacion(int estado_cotizacion) {
		this.estado_cotizacion = estado_cotizacion;
	}
	
	
}
