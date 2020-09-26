package com.servicios.lxe.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.dao.ActividadesDAO;
import com.servicios.lxe.dao.ImageDao;
import com.servicios.lxe.dto.ActividadDto;
import com.servicios.lxe.interfaces.IActividadTuristica;
import com.servicios.lxe.interfaces.IImage;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.Imagen;

@Service
public class ServicioActividad {
	
	@Autowired
	private IActividadTuristica iActividadTuristica;
	
	@Autowired
	private ActividadesDAO actividadesDAO;	
	
	@Autowired
	private IImage iImage;
	
	@Autowired
	private ImageDao imageDao;
	
	protected ServicioActividad(){
		
	} 
	
	public ActividadTuristica createActivity(ActividadDto newActivity) {
		ActividadTuristica activity = new ActividadTuristica(newActivity);
		System.out.println(activity);
		iActividadTuristica.save(activity);
		
		List<String> images = newActivity.getImages();
		for (String imagePath : images) {
			Imagen imagen = new Imagen();
			imagen.setRutaImagen(imagePath);
			imagen.setTipoImagen("actividad");
			imagen.setIdEntidad(activity.getId_actividad());
			iImage.save(imagen);
		}		
		
		return activity;
	}
	
	public ActividadTuristica updateActivity(ActividadDto activityToUpdate) {
		int activityId = activityToUpdate.getIdActividad();
		ActividadTuristica activity = iActividadTuristica.getOne(activityId);
		activity.setAll(activityToUpdate);
		iActividadTuristica.save(activity);
		
		imageDao.deleteByActivityId(activityId);
		
		List<String> images = activityToUpdate.getImages();
		for (String imagePath : images) {
			Imagen imagen = new Imagen();
			imagen.setRutaImagen(imagePath);
			imagen.setTipoImagen("actividad");
			imagen.setIdEntidad(activity.getId_actividad());
			iImage.save(imagen);
		}			
		
		return activity;		
	}	
	
	public List<Map<String,String>> obtenerActividades() {
		return actividadesDAO.listarTodos();		
	}	
	
	public ActividadDto obtenerActividadPorId(int id) {
		ActividadTuristica activity = iActividadTuristica.getOne(id);
		List<Object[]> images = imageDao.searchByActivityId(id);
		
		ActividadDto actividad = new ActividadDto();
		actividad.setCategoria(activity.getCategoria());
		actividad.setDescripcion(activity.getDescripcion());
		actividad.setEstado(activity.getEstado());
		actividad.setIdActividad(activity.getId_actividad());
		actividad.setNombreActividad(activity.getNombreActividad());
		actividad.setPrecioBase(activity.getPrecioBase());
		actividad.setImagesObj(images);
		actividad.setSitioTuristico(activity.getSitioTuristico());
		return actividad;
	}
	
	public Void eliminarActividad(int id) {
		imageDao.deleteByActivityId(id);
		iActividadTuristica.deleteById(id);
		return null;
	}	

}
