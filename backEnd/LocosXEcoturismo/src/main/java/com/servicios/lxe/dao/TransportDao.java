package com.servicios.lxe.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TransportDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void deleteActivitiesProvider(String type, int transportId) {
		Query q = entityManager.createNativeQuery("DELETE FROM proveedores_actividad where tipo = :type "
				+ "and id_proveedor_transporte_hospedaje = :transportId");
		q.setParameter("type", type);
		q.setParameter("transportId", transportId);
		q.executeUpdate();			
	}
	
	public List<Integer> getActivitiesProvider(String type, int transportId) {
		Query q = entityManager.createNativeQuery("SELECT * FROM proveedores_actividad where tipo = :type "
				+ "and id_proveedor_transporte_hospedaje = :transportId");
		q.setParameter("type", type);
		q.setParameter("transportId", transportId);
		
		List<Integer> activityIds = new ArrayList<>();
				
		List<Object[]> actividades = q.getResultList();	
		
		for (Object[] activity : actividades) {
			activityIds.add((int) activity[3]);
		}	
		return activityIds;	
	}	
}
