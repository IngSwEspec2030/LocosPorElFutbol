package com.servicios.lxe.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class HospedajeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void deleteByTypeAndProvider(String type, int hospedajeId) {
		Query q = entityManager.createNativeQuery("DELETE FROM proveedores_actividad where tipo = :type "
				+ "and id_proveedor_transporte_hospedaje = :hospedajeId");
		q.setParameter("type", type);
		q.setParameter("hospedajeId", hospedajeId);
		q.executeUpdate();			
	}	

}
