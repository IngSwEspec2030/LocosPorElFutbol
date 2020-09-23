package com.servicios.lxe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.interfaces.ISitioTuristico;
import com.servicios.lxe.model.SitioTuristico;


@Service
public class ServicioSitioTuristico {
	
	@Autowired
	private ISitioTuristico iSitioTuristico;
	
	protected ServicioSitioTuristico() {
		
	}
	
	public List<SitioTuristico> obtenerSitios() {
		List<SitioTuristico> sitios = iSitioTuristico.findAll();
		return sitios;
	}

}
