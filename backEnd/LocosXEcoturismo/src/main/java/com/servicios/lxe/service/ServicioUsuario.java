package com.servicios.lxe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.dto.ActividadDto;
import com.servicios.lxe.dto.UsuarioDto;
import com.servicios.lxe.interfaces.IProveedor;
import com.servicios.lxe.interfaces.IUsuario;
import com.servicios.lxe.model.Usuario;
import com.servicios.lxe.model.Proveedor;

@Service
public class ServicioUsuario {
	
	@Autowired
	private IUsuario iUsuario;
	
	@Autowired
	private IProveedor iproveedor;
	
	protected ServicioUsuario() {
		
	}
	
	public Usuario createUser(UsuarioDto newUser) {
		Usuario user = new Usuario(newUser);
		System.out.println(user);
		iUsuario.save(user);
		
		if(newUser.getIdRole() == 2) {
			createProvider(newUser, user);
		}
		
		return user;
	}
	
	public void createProvider(UsuarioDto newUser, Usuario user) {
		Proveedor proveedor = new Proveedor(newUser, user);
		System.out.println(proveedor);
		iproveedor.save(proveedor);
	}

}
