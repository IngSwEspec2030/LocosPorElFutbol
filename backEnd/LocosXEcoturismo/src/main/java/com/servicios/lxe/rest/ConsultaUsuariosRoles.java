package com.servicios.lxe.rest;


import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.lxe.dao.UsuarioDao;
import com.servicios.lxe.model.Usuario;

@CrossOrigin(origins="*")
@RestController
public class ConsultaUsuariosRoles {

	@Autowired
	private UsuarioDao usuario;
	
	@GetMapping("/getAutenticaion")
	public ResponseEntity<Usuario> consultarUsuario(@RequestParam String email, @RequestParam String passWord ){
		Usuario user = null;
		try{
			user =  usuario.consultarUsuarioXEmailPassWord(email, passWord);
		}catch(NoResultException ex) {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
