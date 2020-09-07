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
public class Paquete implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_cotizacion;
	@OneToOne
	private SitioTuristico sitioTuristico;
	@OneToOne
	private ActividadTuristica actividadTuristicas;	
	@Column(name = "categoria")
	private String categoria;
	@Column(name = "precioBase")
	private BigDecimal precioBase;
	@Column(name = "review")
	private Integer review;
	@Column(name = "estado")
	private Integer estado;
	
	public int getId_cotizacion() {
		return id_cotizacion;
	}
	public void setId_cotizacion(int id_cotizacion) {
		this.id_cotizacion = id_cotizacion;
	}
	public SitioTuristico getSitioTuristico() {
		return sitioTuristico;
	}
	public void setSitioTuristico(SitioTuristico sitioTuristico) {
		this.sitioTuristico = sitioTuristico;
	}
	public ActividadTuristica getActividadTuristicas() {
		return actividadTuristicas;
	}
	public void setActividadTuristicas(ActividadTuristica actividadTuristicas) {
		this.actividadTuristicas = actividadTuristicas;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}
	public Integer getReview() {
		return review;
	}
	public void setReview(Integer review) {
		this.review = review;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}
