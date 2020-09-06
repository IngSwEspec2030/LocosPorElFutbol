package com.servicios.lxe.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.lxe.dto.PaqueteDto;
import com.servicios.lxe.interfaces.IPaquete;
import com.servicios.lxe.model.Imagen;
import com.servicios.lxe.model.Paquete;


@RestController
@RequestMapping("/paquetes")
public class Paquetes {

	@Autowired
	private IPaquete paquetes;
	
	@GetMapping
	private List<PaqueteDto> consultaPaquetes(){
		List<Paquete> listaPaquetes =  paquetes.findAll();
		List<PaqueteDto> listaPaquetesDto = new ArrayList<>();
		PaqueteDto paque= null;
		for(Paquete pa: listaPaquetes) {
			paque = new PaqueteDto();
			paque.setNombreSitioTuristico(pa.getSitioTuristico().getNombreSitio());
			paque.setNombreMunicipio(pa.getSitioTuristico().getIdMunicipio().getNombreMuni());
			paque.setNombreDepartamento(pa.getSitioTuristico().getIdMunicipio().getIdDepartamento().getNombreDepartamento());
			paque.setIdActividad(pa.getActividadTuristicas().getId_actividad());
			paque.setNombreActividad(pa.getActividadTuristicas().getNombreActividad());
			paque.setEstado(pa.getEstado());
			paque.setUbicacion(String.valueOf(pa.getSitioTuristico().getIdLatitud()) + "," + String.valueOf(pa.getSitioTuristico().getIdLongitud()));
			paque.setImagenesActividad(obtenerImagenes(pa.getSitioTuristico().getImagen()));
			paque.setCategoria(pa.getCategoria());
			paque.setPrecioBase(pa.getPrecioBase());
			paque.setReview(pa.getReview());
			listaPaquetesDto.add(paque);
		}		
		return listaPaquetesDto;		
	}
	
	private List<String> obtenerImagenes(List<Imagen> listaActividad) {
		List<String> listaActividades = new ArrayList<>();
		for (Imagen ima : listaActividad) {
			listaActividades.add(ima.getRutaImagen());
		}
		return listaActividades;
	}
}
