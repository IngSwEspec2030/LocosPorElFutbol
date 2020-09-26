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
	
	public List<Object[]> searchByActivityId(int activityId) {
		Query q = entityManager.createNativeQuery("SELECT * FROM imagen where entidad_id = :activityId");
		q.setParameter("activityId", activityId); 
		
		List<Object[]> image = q.getResultList();
		return image;	
	}
	
	public void deleteByActivityId(int activityId) {
		Query q = entityManager.createNativeQuery("DELETE FROM imagen where entidad_id = :activityId");
		q.setParameter("activityId", activityId);		
		q.executeUpdate();			
	}	
}
