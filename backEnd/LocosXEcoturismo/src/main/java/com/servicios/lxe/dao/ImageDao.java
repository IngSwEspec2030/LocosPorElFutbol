package com.servicios.lxe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ImageDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Object[]> searchByEntityId(int entityId) {
		Query q = entityManager.createNativeQuery("SELECT * FROM imagen where entidad_id = :entityId");
		q.setParameter("entityId", entityId); 
		
		List<Object[]> image = q.getResultList();
		return image;	
	}
	
	public void deleteByEntityId(int entityId) {
		Query q = entityManager.createNativeQuery("DELETE FROM imagen where entidad_id = :entityId");
		q.setParameter("entityId", entityId);		
		q.executeUpdate();			
	}	
}
