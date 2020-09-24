package com.servicios.lxe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProveedoresDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Object[]> buscarPorUserId(int userId) {
		Query q = entityManager.createNativeQuery("SELECT * FROM proveedor where id_usuario_id_usuario = :userId");
		q.setParameter("userId", userId); 
		
		List<Object[]> user = q.getResultList();
		return user;	
	}	
}
