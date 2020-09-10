package com.servicios.lxe.dto;

import javax.validation.constraints.NotNull;

public class CotizacionDto {
	@NotNull()
    public long fechaInicio;
	@NotNull()
	public long fechaFin;
	@NotNull()
    public int idActividad;
	@NotNull()
    public int idTransporte;
	@NotNull()
    public int idHospedaje;
	@NotNull()
    public int numPersonas;
	@NotNull()
    public int estadoCotizacion;
	
	public CotizacionDto() {
		
	}
			
	public CotizacionDto(long fechaInicio, long fechaFin, int idActividad,
			int idTransporte, int idHospedaje, int numPersonas,
			int estadoCotizacion) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idActividad = idActividad;
		this.idTransporte = idTransporte;
		this.idHospedaje = idHospedaje;
		this.numPersonas = numPersonas;
		this.estadoCotizacion = estadoCotizacion;
	}
	public long getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(long fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public long getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(long fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}
	public int getIdTransporte() {
		return idTransporte;
	}
	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}
	public int getIdHospedaje() {
		return idHospedaje;
	}
	public void setIdHospedaje(int idHospedaje) {
		this.idHospedaje = idHospedaje;
	}
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	public int getEstadoCotizacion() {
		return estadoCotizacion;
	}
	public void setEstadoCotizacion(int estadoCotizacion) {
		this.estadoCotizacion = estadoCotizacion;
	}
		
}
