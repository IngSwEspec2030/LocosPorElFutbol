package com.servicios.lxe.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProveedorTransporteDto implements Serializable{

	private Integer idTransportadora;
	private BigDecimal costoPersona;
	private String tipo;
	private String transportadora;
	
	
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

}
