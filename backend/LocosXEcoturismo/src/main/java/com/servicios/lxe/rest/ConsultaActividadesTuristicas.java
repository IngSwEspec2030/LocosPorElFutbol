package com.servicios.lxe.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.lxe.dto.ActividadTuristicaDto;
import com.servicios.lxe.interfaces.IActividadTuristica;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.Imagen;


@RestController
@RequestMapping("/paquetes")
public class ConsultaActividadesTuristicas {

	@Autowired
	private IActividadTuristica actividadTuristica ;
	
	@GetMapping
	private List<ActividadTuristicaDto> consultaPaquetes(){
		List<ActividadTuristica> listaActividadTuristicas =  actividadTuristica.findAll();
		List<ActividadTuristicaDto> listaActividadesDto = new ArrayList<>();
		ActividadTuristicaDto actividad= null;
		for(ActividadTuristica ac: listaActividadTuristicas) {
			actividad = new ActividadTuristicaDto();
			actividad.setNombreSitioTuristico(ac.getSitioTuristico().getNombreSitio());
			actividad.setNombreMunicipio(ac.getSitioTuristico().getIdMunicipio().getNombreMuni());
			actividad.setNombreDepartamento(ac.getSitioTuristico().getIdMunicipio().getIdDepartamento().getNombreDepartamento());
			actividad.setIdActividad(ac.getId_actividad());
			actividad.setNombreActividad(ac.getNombreActividad());
			actividad.setEstado(ac.getEstado());
			actividad.setUbicacion(String.valueOf(ac.getSitioTuristico().getIdLatitud()) + "," + String.valueOf(ac.getSitioTuristico().getIdLongitud()));
			actividad.setImagenesActividad(obtenerImagenes(ac.getSitioTuristico().getImagen()));
			actividad.setCategoria(ac.getCategoria());
			actividad.setPrecioBase(ac.getPrecioBase());
			actividad.setReview(ac.getReview());
			listaActividadesDto.add(actividad);
		}		
		return listaActividadesDto;		
	}
	
	private List<String> obtenerImagenes(List<Imagen> listaActividad) {
		List<String> listaActividades = new ArrayList<>();
		for (Imagen ima : listaActividad) {
			listaActividades.add(ima.getRutaImagen());
		}
		return listaActividades;
	}
}
