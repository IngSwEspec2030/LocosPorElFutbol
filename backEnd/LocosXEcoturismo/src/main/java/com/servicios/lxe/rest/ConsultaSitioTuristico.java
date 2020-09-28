package com.servicios.lxe.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.lxe.interfaces.IDepartamento;
import com.servicios.lxe.model.Departamento;
import com.servicios.lxe.model.SitioTuristico;
import com.servicios.lxe.service.ServicioSitioTuristico;

@CrossOrigin(origins="*")
@RestController
public class ConsultaSitioTuristico {
	
	@Autowired
	private ServicioSitioTuristico servicioSitioTuristico;
	
	@GetMapping("/sitio/list")
	public List<SitioTuristico> obtenerSitios() {
		List<SitioTuristico> sitios = servicioSitioTuristico.obtenerSitios();
		return sitios;
	}
	
	
	@GetMapping("/sitio/listDepartments")
	public List<Departamento> obtenerDepartamentos() {
		return servicioSitioTuristico.obtenerDepartamentos();
	}
}
