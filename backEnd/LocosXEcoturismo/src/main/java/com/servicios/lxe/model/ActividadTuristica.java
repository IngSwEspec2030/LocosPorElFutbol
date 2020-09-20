package com.servicios.lxe.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.servicios.lxe.dto.ActividadDto;

@Entity
public class ActividadTuristica implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_actividad;
	
	@Column(name = "nombreActividad")
	private String nombreActividad;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "precioBase")
	private BigDecimal precioBase;
	
	@Column(name = "review")
	private Integer review;
	
	@Column(name = "estado")
	private Integer estado;
	
	@OneToOne
	private SitioTuristico sitioTuristico;
	
	@OneToMany(targetEntity=ProveedoresActividad.class, mappedBy="actividadTuristica")	   
	private List<ProveedoresActividad> proveedoresActividad;
	
	protected ActividadTuristica() {}
		
	public ActividadTuristica(ActividadDto actividadDto) {
		super();
		this.id_actividad = actividadDto.getIdActividad();
		this.nombreActividad = actividadDto.getNombreActividad();
		this.descripcion = actividadDto.getDescripcion();
		this.categoria = actividadDto.getCategoria();
		this.precioBase = actividadDto.getPrecioBase();
		this.review = actividadDto.getReview();
		this.estado = actividadDto.getEstado();
		this.sitioTuristico = actividadDto.sitioTuristico;
	}

	public int getId_actividad() {
		return id_actividad;
	}
	
	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}
	
	public String getNombreActividad() {
		return nombreActividad;
	}
	
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	public SitioTuristico getSitioTuristico() {
		return sitioTuristico;
	}
	
	public void setSitioTuristico(SitioTuristico sitioTuristico) {
		this.sitioTuristico = sitioTuristico;
	}
	
	public List<ProveedoresActividad> getProveedoresActividad() {
		return proveedoresActividad;
	}
	
	public void setProveedoresActividad(List<ProveedoresActividad> proveedoresActividad) {
		this.proveedoresActividad = proveedoresActividad;
	}
	
	
	
}
