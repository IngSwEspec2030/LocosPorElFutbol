package com.servicios.lxe.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.servicios.lxe.interfaces.IRoles;
import com.servicios.lxe.model.Usuario;

@Repository
@Transactional
public class UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private IRoles roles;

	public Usuario consultarUsuarioXEmailPassWord(String email, String passWord) {

		Usuario usuarioRes = new Usuario();
		try {

			Query q = entityManager
					.createNativeQuery("SELECT * FROM usuario where email_Usuario = :emailP and password = :pass");
			q.setParameter("emailP", email);
			q.setParameter("pass", passWord);

			Object[] user = (Object[]) q.getSingleResult();

			usuarioRes.setId_usuario(Integer.valueOf(user[0].toString()));
			usuarioRes.setApellidosUsuario(user[1].toString());
			usuarioRes.setEmailUsuario(email);
			usuarioRes.setIdentificacionUsuario(user[3].toString());
			usuarioRes.setNombreUsuario(user[4].toString());
			usuarioRes.setPassword(passWord);
			usuarioRes.setTelefonoUsuario(user[6].toString());
			usuarioRes.setRoles(roles.findById(Integer.valueOf(user[7].toString())).get());
		} catch (NoResultException ex) {
			throw ex;
		}

		return usuarioRes;
	}
}
