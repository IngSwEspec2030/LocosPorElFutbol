package com.servicios.lxe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.dto.TransporteDto;
import com.servicios.lxe.interfaces.IActividadTuristica;
import com.servicios.lxe.interfaces.IProveedorActividad;
import com.servicios.lxe.interfaces.ITransporte;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.Imagen;
import com.servicios.lxe.model.ProveedoresActividad;
import com.servicios.lxe.model.Transporte;

@Service
public class ServicioTransporte {

	@Autowired
	private ITransporte iTransporte;
	
	@Autowired
	private IActividadTuristica iActividadTuristica;
	
	@Autowired
	private IProveedorActividad iProveedorActividad;
	
	public Transporte createTransport(TransporteDto newTransport) {
		Transporte transporte = new Transporte(newTransport);
		System.out.println(transporte);
		iTransporte.save(transporte);
		
		List<Integer> actividades = newTransport.getIdActividades();
		for (Integer idActividad : actividades) {
			
			ActividadTuristica actividadTuristica = iActividadTuristica.getOne(idActividad);
			
			ProveedoresActividad proveedoresActividad = new ProveedoresActividad();
			proveedoresActividad.setActividadTuristica(actividadTuristica);

			proveedoresActividad.setId_proveedor_transporte_hospedaje(transporte.getId_transporte());
			proveedoresActividad.setTipo(transporte.getTipo());
			
			iProveedorActividad.save(proveedoresActividad);
		}			

		return transporte;
	}	
	
}
