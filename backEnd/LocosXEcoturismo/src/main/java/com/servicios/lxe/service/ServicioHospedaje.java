package com.servicios.lxe.service;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.dao.HospedajeDAO;
import com.servicios.lxe.dao.ImageDao;
import com.servicios.lxe.dao.TransportDao;
import com.servicios.lxe.dto.HospedajeDTO;
import com.servicios.lxe.dto.TransporteDto;
import com.servicios.lxe.interfaces.IActividadTuristica;
import com.servicios.lxe.interfaces.IHospedaje;
import com.servicios.lxe.interfaces.IImage;
import com.servicios.lxe.interfaces.IProveedorActividad;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.Hospedaje;
import com.servicios.lxe.model.Imagen;
import com.servicios.lxe.model.ProveedoresActividad;
import com.servicios.lxe.model.Transporte;
@Service
public class ServicioHospedaje {
	
	@Autowired
	private IHospedaje iHospedaje;
	
	@Autowired
	private IActividadTuristica iActividadTuristica;
	
	@Autowired
	private IProveedorActividad iProveedorActividad;
	
	@Autowired
	private HospedajeDAO iHospedajeDao;
	
	@Autowired
	private TransportDao iTransportDao;
	
	@Autowired
	private IImage iImage;	
	
	@Autowired
	private ImageDao imageDao;	
	

	public Hospedaje createHospedaje(HospedajeDTO newHospedaje) {
		Hospedaje hospedaje = new Hospedaje(newHospedaje);
		iHospedaje.save(hospedaje);
		
		List<String> images = newHospedaje.getImages();
		for (String imagePath : images) {
			Imagen imagen = new Imagen();
			imagen.setRutaImagen(imagePath);
			imagen.setTipoImagen("hospedaje");
			imagen.setIdEntidad(hospedaje.getId_hospedaje());
			iImage.save(imagen);
		}		
				
		updateProvidersActivities(newHospedaje, hospedaje);
		return hospedaje;
	}

	public Hospedaje updateHospedaje(HospedajeDTO hospedajeToUpdate) {
		int hospedajeId = hospedajeToUpdate.getIdHospedaje();
		Hospedaje hospedaje = iHospedaje.getOne(hospedajeId);
		hospedaje.setAll(hospedajeToUpdate);
		iHospedaje.save(hospedaje);
		
		iHospedajeDao.deleteByTypeAndProvider(hospedajeToUpdate.getTipo(), hospedajeId);
		
		updateProvidersActivities(hospedajeToUpdate, hospedaje);
		
		return hospedaje;
	}

	
	private void updateProvidersActivities(@Valid HospedajeDTO newHospedaje, Hospedaje hospedaje) {
		List<Integer> actividades = newHospedaje.getIdActividades();
		for (Integer idActividad : actividades) {
			
			ActividadTuristica actividadTuristica = iActividadTuristica.getOne(idActividad);
			
			ProveedoresActividad proveedoresActividad = new ProveedoresActividad();
			proveedoresActividad.setActividadTuristica(actividadTuristica);

			proveedoresActividad.setId_proveedor_transporte_hospedaje(hospedaje.getId_hospedaje());
			proveedoresActividad.setTipo(hospedaje.getTipo());
			
			iProveedorActividad.save(proveedoresActividad);
		}			
	}

	public List<Hospedaje> listLodging() {
		List<Hospedaje> hospedajes = iHospedaje.findAll();
		return hospedajes;
	}

	public HospedajeDTO getLodgingById(int id) {
		Hospedaje hospedaje = iHospedaje.getOne(id);
		
		HospedajeDTO hospedajeDTO = new HospedajeDTO();
		
		hospedajeDTO.setCostoPersona(hospedaje.getCosto_persona());
		hospedajeDTO.setIdHospedaje(hospedaje.getId_hospedaje());
		hospedajeDTO.setNombre(hospedaje.getNombre());
		hospedajeDTO.setTelefono(hospedaje.getTelefono());
		hospedajeDTO.setTipo(hospedaje.getTipo());
		hospedajeDTO.setDireccion(hospedaje.getDireccion());
		hospedajeDTO.setEstado(hospedaje.getEstado());
		List<Integer> activityIds = iTransportDao.getActivitiesProvider(hospedaje.getTipo(), id);
		hospedajeDTO.setIdActividades(activityIds);
		
		List<Object[]> images = imageDao.searchByEntityId(id);
		hospedajeDTO.setImagesObj(images);

		
		return hospedajeDTO;
	}
	
	public Void deleteLodging(int id, String type) {		
		iTransportDao.deleteActivitiesProvider(type, id);
		iHospedaje.deleteById(id);
		imageDao.deleteByEntityId(id);
		return null;
	}


}
