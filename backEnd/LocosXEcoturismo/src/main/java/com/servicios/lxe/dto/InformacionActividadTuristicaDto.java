package com.servicios.lxe.dto;


import java.math.BigDecimal;
import java.util.List;

public class InformacionActividadTuristicaDto{

	private String nombreSitioTuristico;
	private String descripcionSitio;
	private String latitud;
	private String longitud;
	private Integer idActividad;
	private String nombreActividad;
	private String descripcionActividad;
	private BigDecimal precioBase;	
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
	public String getDescripcionSitio() {
		return descripcionSitio;
	}
	public void setDescripcionSitio(String descripcionSitio) {
		this.descripcionSitio = descripcionSitio;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
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
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
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
