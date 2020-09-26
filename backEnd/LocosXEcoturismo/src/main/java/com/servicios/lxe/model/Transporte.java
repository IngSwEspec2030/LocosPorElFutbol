package com.servicios.lxe.model;

import java.io.Serializable;
import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.servicios.lxe.dto.TransporteDto;

@Entity
public class Transporte implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_transporte;	
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "transportadora")
	private String transportadora;
	
	@Column(name = "nombreRepresentante")
	private String nombreRepresentante;
	
	@Column(name = "costoPersona")
	private BigDecimal costoPersona;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "idUsuario")
	private int idUsuario;
	
	@Column(name = "descripcion")
	private String descripcion;	
	

	public Transporte() {}
	
	public Transporte(TransporteDto newTransport) {
		super();
		this.id_transporte = newTransport.getIdTransporte();
		this.tipo = newTransport.getTipo();
		this.transportadora = newTransport.getTransportadora();
		this.nombreRepresentante = newTransport.getNombreRepresentante();
		this.costoPersona = newTransport.getCostoPersona();
		this.telefono = newTransport.getTelefono();
		this.idUsuario = newTransport.getUserId();
		this.descripcion = newTransport.getDescripcion();
	}
	
	public void setAll(TransporteDto transportToUpdate) {
		this.id_transporte = transportToUpdate.getIdTransporte();
		this.tipo = transportToUpdate.getTipo();
		this.transportadora = transportToUpdate.getTransportadora();
		this.nombreRepresentante = transportToUpdate.getNombreRepresentante();
		this.costoPersona = transportToUpdate.getCostoPersona();
		this.telefono = transportToUpdate.getTelefono();
		this.idUsuario = transportToUpdate.getUserId();
		this.descripcion = transportToUpdate.getDescripcion();
	}
	
	
	public int getId_transporte() {
		return id_transporte;
	}
	
	public void setId_transporte(int id_transporte) {
		this.id_transporte = id_transporte;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTransportadora() {
		return transportadora;
	}
	
	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}
	
	public String getNombreRepresentante() {
		return nombreRepresentante;
	}
	
	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}
	
	public BigDecimal getCostoPersona() {
		return costoPersona;
	}
	
	public void setCostoPersona(BigDecimal costoPersona) {
		this.costoPersona = costoPersona;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
}