package com.servicios.lxe.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	
	public List<String> images;
	
	public String descripcion;
	
	@NotNull()
	private int userId;
	
	public TransporteDto() {}

	public TransporteDto(@NotNull int idTransporte, @NotNull String nombreRepresentante, @NotNull BigDecimal costoPersona,
			String telefono, String tipo, String transportadora, String descripcion,
			@NotNull int userId, List<Integer> idActividades, List<String> images) {
		super();
		this.idTransporte = idTransporte;
		this.nombreRepresentante = nombreRepresentante;
		this.costoPersona = costoPersona;
		this.telefono = telefono;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.transportadora = transportadora;
		this.userId = userId;
		this.idActividades = idActividades;
		this.images = images;
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
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images= images;
	}

	public void setImagesObj(List<Object[]> imagesObj) {
		List<String> images = new ArrayList<>();
		for(Object[] imageObj: imagesObj) {
			images.add((String) imageObj[1]);
		}
		
		this.setImages(images);
	}	
	
}
