package com.servicios.lxe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Imagen implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_imagen;
	
	@Column(name = "rutaImagen")
	private String rutaImagen;
	
	@Column(name="entidad_id")
	private int idEntidad;	
	
	@Column(name = "tipoImagen")
	private String tipoImagen;
	
	public Imagen() {}
			
	public Imagen(int id_imagen, String rutaImagen, int idEntidad, String tipoImagen) {
		super();
		this.id_imagen = id_imagen;
		this.rutaImagen = rutaImagen;
		this.idEntidad = idEntidad;
		this.tipoImagen = tipoImagen;
	}

	public int getId_imagen() {
		return id_imagen;
	}
	
	public void setId_imagen(int id_imagen) {
		this.id_imagen = id_imagen;
	}
	
	public String getRutaImagen() {
		return rutaImagen;
	}
	
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public String getTipoImagen() {
		return tipoImagen;
	}
	
	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}
	
	public int getEntidadId() {
		return idEntidad;
	}
	
	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}	
}
