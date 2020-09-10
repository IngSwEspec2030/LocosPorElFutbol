package com.servicios.lxe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ActividadTuristicaDto{

	private String nombreSitioTuristico;
	private String nombreMunicipio;
	private String nombreDepartamento;
	private Integer idActividad;
	private String nombreActividad;
	private Integer estado;
	private String ubicacion;
	private List<String> imagenesActividad;
	private String categoria;
	private BigDecimal precioBase;
	private Integer review;
	
	public String getNombreSitioTuristico() {
		return nombreSitioTuristico;
	}
	public void setNombreSitioTuristico(String nombreSitioTuristico) {
		this.nombreSitioTuristico = nombreSitioTuristico;
	}
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public Integer getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}
	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	
	public List<String> getImagenesActividad() {
		return imagenesActividad;
	}
	public void setImagenesActividad(List<String> imagenesActividad) {
		this.imagenesActividad = imagenesActividad;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}
	public Integer getReview() {
		return review;
	}
	public void setReview(Integer review) {
		this.review = review;
	}
}
