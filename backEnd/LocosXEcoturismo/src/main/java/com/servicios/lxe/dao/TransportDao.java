package com.servicios.lxe.dao;

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
	
	public void deleteByTypeAndProvider(String type, int transportId) {
		Query q = entityManager.createNativeQuery("DELETE FROM proveedores_actividad where tipo = :type "
				+ "and id_proveedor_transporte_hospedaje = :transportId");
		q.setParameter("type", type);
		q.setParameter("transportId", transportId);
		q.executeUpdate();			
	}	
}
