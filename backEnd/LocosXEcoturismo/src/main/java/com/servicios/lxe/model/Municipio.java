package com.servicios.lxe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Municipio implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_municipio;
	@Column(name = "nombreMuni")
	private String nombreMuni;
	@OneToOne
	private Departamento idDepartamento;
	
	public int getId_municipio() {
		return id_municipio;
	}
	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}
	public String getNombreMuni() {
		return nombreMuni;
	}
	public void setNombreMuni(String nombreMuni) {
		this.nombreMuni = nombreMuni;
	}
	public Departamento getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Departamento idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
}
