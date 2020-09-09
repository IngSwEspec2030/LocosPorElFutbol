package com.servicios.lxe.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public List<Object[]> buscarPorParametros(Optional<String> keyword, Optional<String> place) {
		// TODO Auto-generated method stub
		return null;
	}	
}
