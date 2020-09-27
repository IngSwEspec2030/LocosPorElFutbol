package com.servicios.lxe.rest;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.servicios.lxe.dto.HospedajeDTO;
import com.servicios.lxe.dto.TransporteDto;
import com.servicios.lxe.model.Hospedaje;
import com.servicios.lxe.model.Transporte;
import com.servicios.lxe.service.ServicioHospedaje;

@CrossOrigin(origins="*")
@RestController
public class HospedajeController {
	
	@Autowired
	private ServicioHospedaje servicioHospedaje;
	
	@PostMapping("/lodging/create")
	public ResponseEntity<Hospedaje> createHospedaje(@RequestBody HospedajeDTO newHospedaje) throws IOException {
		Hospedaje hospedaje = servicioHospedaje.createHospedaje(newHospedaje);
		
		if (hospedaje == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(hospedaje.getId_hospedaje())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/lodging/update")
	public Hospedaje updateHospedaje(@Valid @RequestBody HospedajeDTO hospedajeToUpdate) throws Exception {		
		Hospedaje hospedaje = servicioHospedaje.updateHospedaje(hospedajeToUpdate);
		return hospedaje;
	}	
	
	@GetMapping("/lodging/list")
	@ResponseBody
	public List<Hospedaje> listTransport() {
		List<Hospedaje> lodgings = servicioHospedaje.listLodging();
		return lodgings;
	}
	
	@GetMapping("/lodging/get/{id}")
	public HospedajeDTO getLodgingById(@PathVariable int id) {
		HospedajeDTO lodging = servicioHospedaje.getLodgingById(id);
		return lodging;
	}	

}
