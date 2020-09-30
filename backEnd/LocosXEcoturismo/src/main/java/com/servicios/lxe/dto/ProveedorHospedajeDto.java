package com.servicios.lxe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProveedorHospedajeDto implements Serializable{

	
	private Integer idHospedaje;
	private BigDecimal costoPersona;
	private String tipo;
	private String nombre;
	private List<String> imagenesHospedaje;
	private String direccion;
	
	public Integer getIdHospedaje() {
		return idHospedaje;
	}
	public void setIdHospedaje(Integer idHospedaje) {
		this.idHospedaje = idHospedaje;
	}
	public BigDecimal getCostoPersona() {
		return costoPersona;
	}
	public void setCostoPersona(BigDecimal costoPersona) {
		this.costoPersona = costoPersona;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getImagenesHospedaje() {
		return imagenesHospedaje;
	}
	public void setImagenesHospedaje(List<String> imagenesHospedaje) {
		this.imagenesHospedaje = imagenesHospedaje;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
