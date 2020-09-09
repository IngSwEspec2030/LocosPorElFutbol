package com.servicios.lxe.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hospedaje implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_hospedaje;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "estado")
	private String estado;
	/*@OneToOne
	@Column(name = "id_municipio")
	private Municipio municipio;*/
	@Column(name = "costo_persona")
	private BigDecimal costo_persona;
	@Column(name = "telefono")
	private String telefono;
	
	public int getId_hospedaje() {
		return id_hospedaje;
	}
	public void setId_hospedaje(int id_hospedaje) {
		this.id_hospedaje = id_hospedaje;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	/*public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}*/
	public BigDecimal getCosto_persona() {
		return costo_persona;
	}
	public void setCosto_persona(BigDecimal costo_persona) {
		this.costo_persona = costo_persona;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}