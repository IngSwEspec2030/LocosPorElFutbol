package com.servicios.lxe.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

public class TransporteDto {

	@NotNull()
	private int idTransporte;
	
	@NotNull()
	private String nombreRepresentante;
	
	@NotNull()
	private BigDecimal costoPersona;
	
	private String telefono;
	
	private String tipo;
	
	private String transportadora;
	
	private List<Integer> idActividades;	
	
	@NotNull()
	private int userId;
	
	public TransporteDto() {}

	public TransporteDto(@NotNull int idTransporte, @NotNull String nombreRepresentante, @NotNull BigDecimal costoPersona,
			String telefono, String tipo, String transportadora, @NotNull int userId, List<Integer> idActividades) {
		super();
		this.idTransporte = idTransporte;
		this.nombreRepresentante = nombreRepresentante;
		this.costoPersona = costoPersona;
		this.telefono = telefono;
		this.tipo = tipo;
		this.transportadora = transportadora;
		this.userId = userId;
		this.idActividades = idActividades;
	}

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Integer> getIdActividades() {
		return this.idActividades;
	}

	public void setIdActividades(List<Integer> idActividades) {
		this.idActividades = idActividades;
	}	
	
}
