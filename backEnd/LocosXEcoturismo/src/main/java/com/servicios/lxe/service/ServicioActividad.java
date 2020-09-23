package com.servicios.lxe.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.dao.ActividadesDAO;
import com.servicios.lxe.dto.ActividadDto;
import com.servicios.lxe.interfaces.IActividadTuristica;
import com.servicios.lxe.model.ActividadTuristica;

@Service
public class ServicioActividad {
	
	@Autowired
	private IActividadTuristica iActividadTuristica;
	
	@Autowired
	private ActividadesDAO actividadesDAO;	
	
	protected ServicioActividad(){
		
	} 
	
	public ActividadTuristica createActivity(ActividadDto newActivity) {
		ActividadTuristica activity = new ActividadTuristica(newActivity);
		System.out.println(activity);
		iActividadTuristica.save(activity);
		return activity;
	}
	
	public ActividadTuristica updateActivity(ActividadDto activityToUpdate) {
		int activityId = activityToUpdate.getIdActividad();
		ActividadTuristica activity = iActividadTuristica.getOne(activityId);
		activity.setAll(activityToUpdate);
		iActividadTuristica.save(activity);
		return activity;		
	}	
	
	public List<Map<String,String>> obtenerActividades() {
		return actividadesDAO.listarTodos();		
	}	
	
	public Optional<ActividadTuristica> obtenerActividadPorId(int id) {
		Optional<ActividadTuristica> activity = iActividadTuristica.findById(id);
		return activity;
	}
	
	public Void eliminarActividad(int id) {
		iActividadTuristica.deleteById(id);
		return null;
	}	

}
