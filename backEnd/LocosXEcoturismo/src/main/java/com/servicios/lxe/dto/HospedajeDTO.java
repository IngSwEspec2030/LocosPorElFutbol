package com.servicios.lxe.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class HospedajeDTO {
	
	@NotNull()
	private int idHospedaje;
	@NotNull()
	private String nombre;
	@NotNull()
	private BigDecimal costoPersona;

	private String direccion;

	private String estado;

	private String tipo;

	private String telefono;

	private int idMunicipio;
	
	public List<String> images;
	
	private List<Integer> idActividades;
	
	public HospedajeDTO() {
		
	}
	
	public HospedajeDTO(@NotNull int idHospedaje, @NotNull String nombre, @NotNull BigDecimal costoPersona,
			@NotNull String telefono,@NotNull String tipo,@NotNull String estado,
			@NotNull String direccion , int idMunicipio, List<Integer> idActividades, List<String> images) {
		super();
		this.idHospedaje = idHospedaje;
		this.nombre = nombre;
		this.costoPersona = costoPersona;
		this.telefono = telefono;
		this.tipo = tipo;
		this.estado = estado;
		this.direccion = direccion;
		this.idMunicipio = idMunicipio;
		this.idActividades = idActividades;
		this.images = images;


	}
	
	public int getIdHospedaje() {
		return idHospedaje;
	}

	public void setIdHospedaje(int idHospedaje) {
		this.idHospedaje = idHospedaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getCostoPersona() {
		return costoPersona;
	}

	public void setCostoPersona(BigDecimal costoPersona) {
		this.costoPersona = costoPersona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public List<Integer> getIdActividades() {
		return this.idActividades;
	}

	public void setIdActividades(List<Integer> idActividades) {
		this.idActividades = idActividades;
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
