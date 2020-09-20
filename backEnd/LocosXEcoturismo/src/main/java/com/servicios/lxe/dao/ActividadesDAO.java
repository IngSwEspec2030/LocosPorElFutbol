package com.servicios.lxe.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.servicios.lxe.dto.ActividadTuristicaDto;
import com.servicios.lxe.model.CotizacionEntity;

@Repository
@Transactional
public class ActividadesDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Object[]> buscarPorParametros(String keyword) {
		Query q = entityManager.createNativeQuery("SELECT * FROM actividad_turistica where nombre_actividad ilike :keyword or descripcion ilike :keyword");
		q.setParameter("keyword", "%"+keyword+"%"); 
		
		List<Object[]> actividades = q.getResultList();
		return actividades;	
	}
	
	
	public List<Map<String,String>> listarTodos() {
		Query q = entityManager.createNativeQuery("SELECT * FROM actividad_turistica");
				
		List<Object[]> actividades = q.getResultList();
		List<Map<String,String>> result = actividades.stream()
                .map(arr->{
                    Map<String,String> map = new HashMap<>();  
                    map.put("id", String.valueOf(arr[0]));
                    map.put("categoria", (String) arr[1]);
                    map.put("descripcion", (String) arr[2]);
                    map.put("estado", String.valueOf(arr[3]));
                    map.put("nombreActividad", (String) arr[4]);
                    map.put("precioBase", String.valueOf(arr[5]));
                    return map; 
                  })
               .collect(Collectors.toList());		
		return result;	
	}	
	

	public List<Object[]> buscarPorParametros(Optional<String> keyword, Optional<String> place) {
		// TODO Auto-generated method stub
		return null;
	}	
}
