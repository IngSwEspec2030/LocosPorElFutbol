package com.servicios.lxe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_proveedor;
	@Column(name = "nombreProveedor")
	private String nombreProveedor;
	@Column(name = "nombreRepresentante")
	private String nombreRepresentante;
	@Column(name = "telefono")
	private String telefono;
		
	public int getId_proveedor() {
		return id_proveedor;
	}
	
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getNombreRepresentante() {
		return nombreRepresentante;
	}
	
	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
