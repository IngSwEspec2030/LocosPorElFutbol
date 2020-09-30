package com.servicios.lxe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProveedorTransporteDto implements Serializable{

	private Integer idTransportadora;
	private BigDecimal costoPersona;
	private String tipo;
	private String transportadora;
	private List<String> imagenesTransporte;
	private String descripcion;
	
	public Integer getIdTransportadora() {
		return idTransportadora;
	}
	public void setIdTransportadora(Integer idTransportadora) {
		this.idTransportadora = idTransportadora;
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
	public String getTransportadora() {
		return transportadora;
	}
	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}
	public List<String> getImagenesTransporte() {
		return imagenesTransporte;
	}
	public void setImagenesTransporte(List<String> imagenesTransporte) {
		this.imagenesTransporte = imagenesTransporte;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
