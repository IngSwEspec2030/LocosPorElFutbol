package com.servicios.lxe.rest;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.servicios.lxe.dto.ActividadDto;
import com.servicios.lxe.interfaces.ISitioTuristico;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.SitioTuristico;
import com.servicios.lxe.service.ServicioActividad;

@CrossOrigin(origins="*")
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
	
	@PostMapping("/activity/update")
	public ActividadTuristica updateActivity(@Valid @RequestBody ActividadDto activityToUpdate) throws Exception {
		activityToUpdate.setSitioTuristico(iSitioTuristico.getOne(activityToUpdate.idSitio));
		ActividadTuristica actividad = servicioActividad.updateActivity(activityToUpdate);
		return actividad;
	}	
	
	@GetMapping("/activity/list")
	@ResponseBody
	public List<Map<String,String>> obtenerActividades() {
		List<Map<String,String>> actividades = servicioActividad.obtenerActividades();
		return actividades;
	}	
	
	@GetMapping("/activity/get/{id}")
	public Optional<ActividadTuristica> obtenerActividadPorId(@PathVariable int id) {
		Optional<ActividadTuristica> activity = servicioActividad.obtenerActividadPorId(id);
		return activity;
	}

}
