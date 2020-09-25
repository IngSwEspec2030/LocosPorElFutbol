package com.servicios.lxe.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.servicios.lxe.interfaces.ISitioTuristico;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.SitioTuristico;

public class ActividadDto {
	
	@NotNull() 
	private int idActividad;
	
	@NotNull()
	public String nombreActividad;
	
	public String categoria;
	
	public String descripcion;
	
	public int estado;
	
	public BigDecimal precioBase;
	
	public int review;
	
	public SitioTuristico sitioTuristico;
	
	public int idSitio;
	
	public List<String> images;

	public ActividadDto() {}

	public ActividadDto(@NotNull int idActividad, @NotNull String nombreActividad, String categoria, String descripcion,
			int estado, BigDecimal precioBase, int review, int idSitio, List<String> images) {
		super();
		this.idActividad = idActividad;
		this.nombreActividad = nombreActividad;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precioBase = precioBase;		
		this.review = review;	
		this.idSitio = idSitio;
		this.images = images;
	}


	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}


	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public BigDecimal getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public SitioTuristico getSitioTuristico() {
		return sitioTuristico;
	}

	public void setSitioTuristico(SitioTuristico sitioTuristico) {
		this.sitioTuristico = sitioTuristico;
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
