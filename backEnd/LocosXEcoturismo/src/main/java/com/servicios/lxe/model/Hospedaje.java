package com.servicios.lxe.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.servicios.lxe.dto.HospedajeDTO;

@SuppressWarnings("serial")
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
	private int estado;
	/*@OneToOne
	@Column(name = "id_municipio")
	private Municipio municipio;*/
	@Column(name = "idUsuario")
	private int idUsuario;
	@Column(name = "costo_persona")
	private BigDecimal costo_persona;
	@Column(name = "telefono")
	private String telefono;
	
	public Hospedaje() {}
		
	public Hospedaje(HospedajeDTO newHospedaje) {
		super();
		this.id_hospedaje=newHospedaje.getIdHospedaje();
		this.tipo=newHospedaje.getTipo();
		this.nombre = newHospedaje.getNombre();
		this.costo_persona = newHospedaje.getCostoPersona();
		this.telefono = newHospedaje.getTelefono();
		this.direccion = newHospedaje.getDireccion();
		this.idUsuario = newHospedaje.getUserId();
		this.estado = newHospedaje.getEstado();
	}
	
	public void setAll(HospedajeDTO hospedajeToUpdate) {
		this.id_hospedaje = hospedajeToUpdate.getIdHospedaje();
		this.tipo = hospedajeToUpdate.getTipo();
		this.nombre = hospedajeToUpdate.getNombre();
		this.costo_persona = hospedajeToUpdate.getCostoPersona();
		this.telefono = hospedajeToUpdate.getTelefono();
		this.direccion = hospedajeToUpdate.getDireccion();	
		this.idUsuario = hospedajeToUpdate.getUserId();
		this.estado = hospedajeToUpdate.getEstado();	
	}
	
	
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
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
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
