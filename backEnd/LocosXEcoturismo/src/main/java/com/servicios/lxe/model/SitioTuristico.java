package com.servicios.lxe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class SitioTuristico implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_sitio;
	
	@Column(name = "nombreSitio")
	private String nombreSitio;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToOne
	private Municipio idMunicipio;
	
	@Column(name = "idLatitud")
	private String idLatitud;
	
	@Column(name = "idLongitud")
	private String idLongitud;
	
	protected SitioTuristico() {
		
	}
		
	public SitioTuristico(int id_sitio, String nombreSitio, String descripcion, Municipio idMunicipio,
			String idLatitud, String idLongitud) {
		super();
		this.id_sitio = id_sitio;
		this.nombreSitio = nombreSitio;
		this.descripcion = descripcion;
		this.idMunicipio = idMunicipio;
		this.idLatitud = idLatitud;
		this.idLongitud = idLongitud;		
	}

	public int getId_sitio() {
		return id_sitio;
	}
	
	public void setId_sitio(int id_sitio) {
		this.id_sitio = id_sitio;
	}
	
	public String getNombreSitio() {
		return nombreSitio;
	}
	
	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Municipio getIdMunicipio() {
		return idMunicipio;
	}
	
	public void setIdMunicipio(Municipio idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	
	public String getIdLatitud() {
		return idLatitud;
	}
	
	public void setIdLatitud(String idLatitud) {
		this.idLatitud = idLatitud;
	}
	
	public String getIdLongitud() {
		return idLongitud;
	}
	
	public void setIdLongitud(String idLongitud) {
		this.idLongitud = idLongitud;
	}	
}
