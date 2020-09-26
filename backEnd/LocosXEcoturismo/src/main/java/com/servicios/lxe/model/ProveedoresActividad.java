package com.servicios.lxe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProveedoresActividad implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_proveedor_actividad;
	
	@Column(name = "id_proveedor_transporte_hospedaje")
	private int id_proveedor_transporte_hospedaje;
	
	@Column(name = "tipo")
	private String tipo;
	
	@ManyToOne()
	@JoinColumn(name="actividad_id")
	@JsonIgnore
	private ActividadTuristica actividadTuristica;	
	
	
	public ProveedoresActividad() {}

	public ProveedoresActividad(int id_proveedor_actividad, int id_proveedor_transporte_hospedaje, String tipo,
			ActividadTuristica actividadTuristica) {
		super();
		this.id_proveedor_actividad = id_proveedor_actividad;
		this.id_proveedor_transporte_hospedaje = id_proveedor_transporte_hospedaje;
		this.tipo = tipo;
		this.actividadTuristica = actividadTuristica;
	}
	
	public int getId_proveedor_actividad() {
		return id_proveedor_actividad;
	}
	
	public void setId_proveedor_actividad(int id_proveedor_actividad) {
		this.id_proveedor_actividad = id_proveedor_actividad;
	}
	
	public int getId_proveedor_transporte_hospedaje() {
		return id_proveedor_transporte_hospedaje;
	}
	
	public void setId_proveedor_transporte_hospedaje(int id_proveedor_transporte_hospedaje) {
		this.id_proveedor_transporte_hospedaje = id_proveedor_transporte_hospedaje;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public ActividadTuristica getActividadTuristica() {
		return actividadTuristica;
	}
	
	public void setActividadTuristica(ActividadTuristica actividadTuristica) {
		this.actividadTuristica = actividadTuristica;
	}
}

