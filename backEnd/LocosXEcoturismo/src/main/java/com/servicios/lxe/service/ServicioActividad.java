package com.servicios.lxe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.dto.ActividadDto;
import com.servicios.lxe.interfaces.IActividadTuristica;
import com.servicios.lxe.model.ActividadTuristica;

@Service
public class ServicioActividad {
	
	@Autowired
	private IActividadTuristica iActividadTuristica;
	
	protected ServicioActividad(){
		
	} 
	
	public ActividadTuristica createActivity(ActividadDto newActivity) {
		ActividadTuristica activity = new ActividadTuristica(newActivity);
		System.out.println(activity);
		iActividadTuristica.save(activity);
		return activity;
	}	

}
