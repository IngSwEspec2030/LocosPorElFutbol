package com.servicios.lxe.rest;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.servicios.lxe.dto.ActividadDto;
import com.servicios.lxe.interfaces.ISitioTuristico;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.service.ServicioActividad;

@RestController
public class Actividad {
	
	@Autowired
	private ServicioActividad servicioActividad;
	
	@Autowired
	public ISitioTuristico iSitioTuristico;	
	
	@PostMapping("/activity/create")
	public ResponseEntity<ActividadTuristica> createUser(@RequestBody ActividadDto newActivity) throws IOException {
		newActivity.setSitioTuristico(iSitioTuristico.getOne(newActivity.idSitio));
		ActividadTuristica activity = servicioActividad.createActivity(newActivity);
		
		if (activity == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(activity.getId_actividad())
				.toUri();
		return ResponseEntity.created(location).build();
	}	

}
