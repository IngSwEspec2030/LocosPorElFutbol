package com.servicios.lxe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class InformacionActividadTuristicaDto{

	private String nombreSitioTuristico;
	private String descripcion;
	private BigDecimal precioBase;
	private Integer idActividad;
	private Integer review;
	private List<String> imagenesActividad;
	private Integer estado;
	private List<ProveedorHospedajeDto> provedoresHospedaje;
	private List<ProveedorTransporteDto> provedoresTransporte;
	
	
	public String getNombreSitioTuristico() {
		return nombreSitioTuristico;
	}
	public void setNombreSitioTuristico(String nombreSitioTuristico) {
		this.nombreSitioTuristico = nombreSitioTuristico;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}
	public Integer getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}
	public Integer getReview() {
		return review;
	}
	public void setReview(Integer review) {
		this.review = review;
	}
	public List<String> getImagenesActividad() {
		return imagenesActividad;
	}
	public void setImagenesActividad(List<String> imagenesActividad) {
		this.imagenesActividad = imagenesActividad;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public List<ProveedorHospedajeDto> getProvedoresHospedaje() {
		return provedoresHospedaje;
	}
	public void setProvedoresHospedaje(List<ProveedorHospedajeDto> provedoresHospedaje) {
		this.provedoresHospedaje = provedoresHospedaje;
	}
	public List<ProveedorTransporteDto> getProvedoresTransporte() {
		return provedoresTransporte;
	}
	public void setProvedoresTransporte(List<ProveedorTransporteDto> provedoresTransporte) {
		this.provedoresTransporte = provedoresTransporte;
	}
}
