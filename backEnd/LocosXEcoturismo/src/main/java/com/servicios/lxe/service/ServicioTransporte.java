package com.servicios.lxe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.dao.TransportDao;
import com.servicios.lxe.dto.ActividadDto;
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
	
	@Autowired
	private TransportDao iTransportDao;
	
	public Transporte createTransport(TransporteDto newTransport) {
		Transporte transporte = new Transporte(newTransport);
		System.out.println(transporte);
		iTransporte.save(transporte);
		
		updateProvidersActivities(newTransport, transporte);			

		return transporte;
	}
		
	public Transporte updateTransport(TransporteDto transportToUpdate) {
		int transportId = transportToUpdate.getIdTransporte();
		Transporte transporte = iTransporte.getOne(transportId);
		transporte.setAll(transportToUpdate);
		iTransporte.save(transporte);
		
		iTransportDao.deleteActivitiesProvider(transportToUpdate.getTipo(), transportId);
		
		updateProvidersActivities(transportToUpdate, transporte);
							
		return transporte;		
	}
	
	private void updateProvidersActivities(TransporteDto transportToUpdate, Transporte transporte) {
		List<Integer> actividades = transportToUpdate.getIdActividades();
		for (Integer idActividad : actividades) {
			
			ActividadTuristica actividadTuristica = iActividadTuristica.getOne(idActividad);
			
			ProveedoresActividad proveedoresActividad = new ProveedoresActividad();
			proveedoresActividad.setActividadTuristica(actividadTuristica);

			proveedoresActividad.setId_proveedor_transporte_hospedaje(transporte.getId_transporte());
			proveedoresActividad.setTipo(transporte.getTipo());
			
			iProveedorActividad.save(proveedoresActividad);
		}			
	}
	
	public List<Transporte> listTransport() {
		List<Transporte> transportes = iTransporte.findAll();
		return transportes;
	}
	
	public TransporteDto getTransportById(int id) {
		Transporte transporte = iTransporte.getOne(id);
		
		TransporteDto transporteDto = new TransporteDto();
		
		transporteDto.setCostoPersona(transporte.getCostoPersona());
		transporteDto.setIdTransporte(transporte.getId_transporte());
		transporteDto.setNombreRepresentante(transporte.getNombreRepresentante());
		transporteDto.setTelefono(transporte.getTelefono());
		transporteDto.setTipo(transporte.getTipo());
		transporteDto.setTransportadora(transporte.getTransportadora());
		transporteDto.setUserId(transporte.getIdUsuario());
		
		List<Integer> activityIds = iTransportDao.getActivitiesProvider(transporte.getTipo(), id);
		transporteDto.setIdActividades(activityIds);
		
		/*
		List<Object[]> images = imageDao.searchByActivityId(id);
		
		
		actividad.setCategoria(activity.getCategoria());
		actividad.setDescripcion(activity.getDescripcion());
		actividad.setEstado(activity.getEstado());
		actividad.setIdActividad(activity.getId_actividad());
		actividad.setNombreActividad(activity.getNombreActividad());
		actividad.setPrecioBase(activity.getPrecioBase());
		actividad.setImagesObj(images);
		actividad.setSitioTuristico(activity.getSitioTuristico());
		*/
		return transporteDto;
	}	
	
	public Void deleteTransport(int id, String type) {		
		iTransportDao.deleteActivitiesProvider(type, id);
		iTransporte.deleteById(id);
		return null;
	}
	
}
