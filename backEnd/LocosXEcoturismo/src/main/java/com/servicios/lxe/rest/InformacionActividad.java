package com.servicios.lxe.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.lxe.dto.InformacionActividadTuristicaDto;
import com.servicios.lxe.dto.ProveedorHospedajeDto;
import com.servicios.lxe.dto.ProveedorTransporteDto;
import com.servicios.lxe.general.Constantes;
import com.servicios.lxe.interfaces.IActividadTuristica;
import com.servicios.lxe.interfaces.IHospedaje;
import com.servicios.lxe.interfaces.ITransporte;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.Hospedaje;
import com.servicios.lxe.model.Imagen;
import com.servicios.lxe.model.ProveedoresActividad;
import com.servicios.lxe.model.Transporte;

@CrossOrigin(origins="*")
@RestController
public class InformacionActividad {

	
	@Autowired
	private IActividadTuristica actividadTuristica; 
	@Autowired
	private ITransporte transporte;
	@Autowired
	private IHospedaje hospedaje;
	
	@GetMapping("/informacionActividad")
	public InformacionActividadTuristicaDto consultarInformacionActividad(@RequestParam Integer idActividad) {
		InformacionActividadTuristicaDto result = new InformacionActividadTuristicaDto();
		
		ActividadTuristica  actividad = actividadTuristica.getOne(idActividad);
		result.setNombreSitioTuristico(actividad.getSitioTuristico().getNombreSitio());
		result.setNombreDepartamento(actividad.getSitioTuristico().getIdMunicipio().getIdDepartamento().getNombreDepartamento());
		result.setDescripcion(actividad.getSitioTuristico().getDescripcion());
		result.setLatitud(actividad.getSitioTuristico().getIdLatitud());
		result.setLongitud(actividad.getSitioTuristico().getIdLongitud());
		result.setIdActividad(actividad.getId_actividad());
		result.setNombreActividad(actividad.getNombreActividad());
		result.setDescripcionActividad(actividad.getDescripcion());		
		result.setPrecioBase(actividad.getPrecioBase());
		result.setReview(actividad.getReview());
		result.setImagenesActividad(obtenerImagenes(actividad.getSitioTuristico().getImagen()));
		result.setEstado(actividad.getEstado());
		result.setProvedoresHospedaje(obtenerProveedoresHospedaje(actividad));
		result.setProvedoresTransporte(obtenerProveedoresTransporte(actividad));
		
		return result;
	}
	
	private List<ProveedorTransporteDto> obtenerProveedoresTransporte(ActividadTuristica actividad) {
		List<ProveedorTransporteDto>  resulProveedoresTransporte = new ArrayList<>();
		List<ProveedoresActividad> provAc= actividad.getProveedoresActividad();
		ProveedorTransporteDto proveedorTransporte = null;
		 
		 for(ProveedoresActividad proveedor: provAc) {
			 if(proveedor.getTipo().equals(Constantes.NOMBRE_PROVEEDOR_ACTIVIDAD_TRANSPORTE)) {
				 Transporte trans = transporte.getOne(proveedor.getId_proveedor_transporte_hospedaje());
				 proveedorTransporte = new ProveedorTransporteDto();
				 proveedorTransporte.setIdTransportadora(trans.getId_transporte());
				 proveedorTransporte.setCostoPersona(trans.getCostoPersona());
				 proveedorTransporte.setTipo(trans.getTipo());
				 proveedorTransporte.setTransportadora(trans.getTransportadora());
				 resulProveedoresTransporte.add(proveedorTransporte);
			 }
		 }
		
		return resulProveedoresTransporte;
	}

	private List<ProveedorHospedajeDto> obtenerProveedoresHospedaje(ActividadTuristica actividad) {
		List<ProveedorHospedajeDto>  resulProveedoresHospedaje = new ArrayList<>();
		List<ProveedoresActividad> provAc= actividad.getProveedoresActividad();
		ProveedorHospedajeDto proveedorHospedaje = null;
		 
		 for(ProveedoresActividad proveedor: provAc) {
			 if(proveedor.getTipo().equals(Constantes.NOMBRE_PROVEEDOR_ACTIVIDAD_HOSPEDAJE)) {
				 Hospedaje hospe = hospedaje.getOne(proveedor.getId_proveedor_transporte_hospedaje());
				 proveedorHospedaje = new ProveedorHospedajeDto();
				 proveedorHospedaje.setIdHospedaje(hospe.getId_hospedaje());
				 proveedorHospedaje.setCostoPersona(hospe.getCosto_persona());
				 proveedorHospedaje.setTipo(hospe.getTipo());
				 proveedorHospedaje.setNombre(hospe.getNombre());
				 resulProveedoresHospedaje.add(proveedorHospedaje);
			 }
		 }
		
		return resulProveedoresHospedaje;
	}

	private List<String> obtenerImagenes(List<Imagen> listaActividad) {
		List<String> listaActividades = new ArrayList<>();
		for (Imagen ima : listaActividad) {
			listaActividades.add(ima.getRutaImagen());
		}
		return listaActividades;
	}
}
package com.servicios.lxe.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.lxe.dto.InformacionActividadTuristicaDto;
import com.servicios.lxe.dto.ProveedorHospedajeDto;
import com.servicios.lxe.dto.ProveedorTransporteDto;
import com.servicios.lxe.general.Constantes;
import com.servicios.lxe.interfaces.IActividadTuristica;
import com.servicios.lxe.interfaces.IHospedaje;
import com.servicios.lxe.interfaces.ITransporte;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.Hospedaje;
import com.servicios.lxe.model.Imagen;
import com.servicios.lxe.model.ProveedoresActividad;
import com.servicios.lxe.model.Transporte;

@CrossOrigin(origins="*")
@RestController
public class InformacionActividad {

	
	@Autowired
	private IActividadTuristica actividadTuristica; 
	@Autowired
	private ITransporte transporte;
	@Autowired
	private IHospedaje hospedaje;
	
	@GetMapping("/informacionActividad")
	public InformacionActividadTuristicaDto consultarInformacionActividad(@RequestParam Integer idActividad) {
		InformacionActividadTuristicaDto result = new InformacionActividadTuristicaDto();
		
		ActividadTuristica  actividad = actividadTuristica.getOne(idActividad);
		result.setNombreSitioTuristico(actividad.getSitioTuristico().getNombreSitio());
		result.setNombreDepartamento(actividad.getSitioTuristico().getIdMunicipio().getIdDepartamento().getNombreDepartamento());
		result.setDescripcion(actividad.getSitioTuristico().getDescripcion());
		result.setLatitud(actividad.getSitioTuristico().getIdLatitud());
		result.setLongitud(actividad.getSitioTuristico().getIdLongitud());
		result.setIdActividad(actividad.getId_actividad());
		result.setNombreActividad(actividad.getNombreActividad());
		result.setDescripcionActividad(actividad.getDescripcion());		
		result.setPrecioBase(actividad.getPrecioBase());
		result.setReview(actividad.getReview());
		result.setImagenesActividad(obtenerImagenes(actividad.getSitioTuristico().getImagen()));
		result.setEstado(actividad.getEstado());
		result.setProvedoresHospedaje(obtenerProveedoresHospedaje(actividad));
		result.setProvedoresTransporte(obtenerProveedoresTransporte(actividad));
		
		return result;
	}
	
	private List<ProveedorTransporteDto> obtenerProveedoresTransporte(ActividadTuristica actividad) {
		List<ProveedorTransporteDto>  resulProveedoresTransporte = new ArrayList<>();
		List<ProveedoresActividad> provAc= actividad.getProveedoresActividad();
		ProveedorTransporteDto proveedorTransporte = null;
		 
		 for(ProveedoresActividad proveedor: provAc) {
			 if(proveedor.getTipo().equals(Constantes.NOMBRE_PROVEEDOR_ACTIVIDAD_TRANSPORTE)) {
				 Transporte trans = transporte.getOne(proveedor.getId_proveedor_transporte_hospedaje());
				 proveedorTransporte = new ProveedorTransporteDto();
				 proveedorTransporte.setIdTransportadora(trans.getId_transporte());
				 proveedorTransporte.setCostoPersona(trans.getCostoPersona());
				 proveedorTransporte.setTipo(trans.getTipo());
				 proveedorTransporte.setTransportadora(trans.getTransportadora());
				 resulProveedoresTransporte.add(proveedorTransporte);
			 }
		 }
		
		return resulProveedoresTransporte;
	}

	private List<ProveedorHospedajeDto> obtenerProveedoresHospedaje(ActividadTuristica actividad) {
		List<ProveedorHospedajeDto>  resulProveedoresHospedaje = new ArrayList<>();
		List<ProveedoresActividad> provAc= actividad.getProveedoresActividad();
		ProveedorHospedajeDto proveedorHospedaje = null;
		 
		 for(ProveedoresActividad proveedor: provAc) {
			 if(proveedor.getTipo().equals(Constantes.NOMBRE_PROVEEDOR_ACTIVIDAD_HOSPEDAJE)) {
				 Hospedaje hospe = hospedaje.getOne(proveedor.getId_proveedor_transporte_hospedaje());
				 proveedorHospedaje = new ProveedorHospedajeDto();
				 proveedorHospedaje.setIdHospedaje(hospe.getId_hospedaje());
				 proveedorHospedaje.setCostoPersona(hospe.getCosto_persona());
				 proveedorHospedaje.setTipo(hospe.getTipo());
				 proveedorHospedaje.setNombre(hospe.getNombre());
				 resulProveedoresHospedaje.add(proveedorHospedaje);
			 }
		 }
		
		return resulProveedoresHospedaje;
	}

	private List<String> obtenerImagenes(List<Imagen> listaActividad) {
		List<String> listaActividades = new ArrayList<>();
		for (Imagen ima : listaActividad) {
			listaActividades.add(ima.getRutaImagen());
		}
		return listaActividades;
	}
}

