package com.servicios.lxe.rest;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.servicios.lxe.dto.CotizacionDto;
import com.servicios.lxe.interfaces.ICotizacion;
import com.servicios.lxe.model.CotizacionEntity;


@CrossOrigin(origins="*")
@RestController
public class Cotizacion {
	
	@Autowired
	private ICotizacion iCotizacion;

	@PostMapping("/crear/cotizacion")
	public ResponseEntity<CotizacionEntity> crearCotizacion(@RequestBody CotizacionDto nuevaCotizacion) throws IOException {
		CotizacionEntity cotizacion = new CotizacionEntity(nuevaCotizacion);
		iCotizacion.save(cotizacion);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cotizacion.getId_contizacion())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
}
