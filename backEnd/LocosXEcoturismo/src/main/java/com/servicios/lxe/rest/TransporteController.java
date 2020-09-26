package com.servicios.lxe.rest;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.servicios.lxe.dto.ActividadDto;
import com.servicios.lxe.dto.TransporteDto;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.Transporte;
import com.servicios.lxe.service.ServicioTransporte;

@CrossOrigin(origins="*")
@RestController
public class TransporteController {
	
	@Autowired
	private ServicioTransporte servicioTransporte;

	@PostMapping("/transport/create")
	public ResponseEntity<Transporte> createTransport(@RequestBody TransporteDto newTransport) throws IOException {
		
		Transporte transporte = servicioTransporte.createTransport(newTransport);
		
		if (transporte == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(transporte.getId_transporte())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/transport/update")
	public Transporte updateTransport(@Valid @RequestBody TransporteDto transportToUpdate) throws Exception {		
		Transporte transport = servicioTransporte.updateTransport(transportToUpdate);
		return transport;
	}
	
	@GetMapping("/transport/list")
	@ResponseBody
	public List<Transporte> listTransport() {
		List<Transporte> transports = servicioTransporte.listTransport();
		return transports;
	}
	
	@GetMapping("/transport/get/{id}")
	public TransporteDto getTransportById(@PathVariable int id) {
		TransporteDto transport = servicioTransporte.getTransportById(id);
		return transport;
	}	
	
	@DeleteMapping("/transport/delete/{id}/{type}")
	public ResponseEntity<Void> deleteTransport(@PathVariable int id, @PathVariable String type) {
		servicioTransporte.deleteTransport(id, type);
		return ResponseEntity.noContent().build();
	}
	
}
