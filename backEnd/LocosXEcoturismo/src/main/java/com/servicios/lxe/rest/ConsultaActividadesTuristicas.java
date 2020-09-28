package com.servicios.lxe.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.lxe.dao.ActividadesDAO;
import com.servicios.lxe.dao.ImageDao;
import com.servicios.lxe.dto.ActividadTuristicaDto;
import com.servicios.lxe.interfaces.IActividadTuristica;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.Imagen;


@CrossOrigin(origins="*")
@RestController
public class ConsultaActividadesTuristicas {

	@Autowired
	private IActividadTuristica actividadTuristica ;
	
	@Autowired
	private ActividadesDAO actividadesDAO;
	
	@Autowired
	private ImageDao imageDao;	
	
	@GetMapping("/getActivities")
	private List<ActividadTuristicaDto> consultaPaquetes(){
		List<ActividadTuristica> listaActividadTuristicas =  actividadTuristica.findAll();
		List<ActividadTuristicaDto> listaActividadesDto = new ArrayList<>();
		ActividadTuristicaDto actividad= null;
		for(ActividadTuristica ac: listaActividadTuristicas) {
			actividad = new ActividadTuristicaDto();
			actividad.setNombreSitioTuristico(ac.getSitioTuristico().getNombreSitio());
			actividad.setNombreMunicipio(ac.getSitioTuristico().getIdMunicipio().getNombreMuni());
			actividad.setNombreDepartamento(ac.getSitioTuristico().getIdMunicipio().getIdDepartamento().getNombreDepartamento());
			actividad.setIdActividad(ac.getId_actividad());
			actividad.setNombreActividad(ac.getNombreActividad());
			actividad.setEstado(ac.getEstado());
			actividad.setUbicacion(ac.getSitioTuristico().getIdLatitud() + "," + ac.getSitioTuristico().getIdLongitud());
			actividad.setImagenesActividad(obtenerImagenes(ac.getId_actividad()));
			actividad.setCategoria(ac.getCategoria());
			actividad.setPrecioBase(ac.getPrecioBase());
			actividad.setReview(ac.getReview());
			listaActividadesDto.add(actividad);
		}		
		return listaActividadesDto;		
	}
	
	@GetMapping("/getCategories")
	private List<String> consultaCategorias(){
		return actividadesDAO.buscarCategorias();	
	}
	
	private List<String> obtenerImagenes(int idActividad) {		
		List<Object[]> imagesObj = imageDao.searchByEntityId(idActividad);
		
		List<String> images = new ArrayList<>();
		for(Object[] imageObj: imagesObj) {
			images.add((String) imageObj[1]);
		}
		return images;
	}
	
	@GetMapping("/getActivities/{keyword}")
	public List<Object[]> buscarActividades(@PathVariable String keyword) {
		return actividadesDAO.buscarPorParametros(keyword);
	}	
}
