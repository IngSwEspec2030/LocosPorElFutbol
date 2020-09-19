package com.servicios.lxe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Roles {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_rol;
	@Column(name = "nombreRol")
	private String nombreRol;
	@Column(name = "descripcionRol")
	private String descripcionRol;
	@Column(name = "indicador")
	private Character indicadorRol;
	
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public String getDescripcionRol() {
		return descripcionRol;
	}
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	public Character getIndicadorRol() {
		return indicadorRol;
	}
	public void setIndicadorRol(Character indicadorRol) {
		this.indicadorRol = indicadorRol;
	}
	
}
