package com.servicios.lxe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.dto.ActividadDto;
import com.servicios.lxe.dto.UsuarioDto;
import com.servicios.lxe.interfaces.IUsuario;
import com.servicios.lxe.model.Usuario;

@Service
public class ServicioUsuario {
	
	@Autowired
	private IUsuario iUsuario;
	
	protected ServicioUsuario() {
		
	}
	
	public Usuario createUser(UsuarioDto newUser) {
		Usuario user = new Usuario(newUser);
		System.out.println(user);
		iUsuario.save(user);
		return user;
	}	

}
