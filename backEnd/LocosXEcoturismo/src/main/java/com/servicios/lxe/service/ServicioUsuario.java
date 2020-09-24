package com.servicios.lxe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.lxe.dao.ProveedoresDao;
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
	
	@Autowired
	private ProveedoresDao proveedoresDao;
	
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
	
	public List<UsuarioDto> obtenerUsuarios() {
		List<Usuario> usuarios = iUsuario.findAll();
		List<UsuarioDto> usuariosDto = new ArrayList<>();
		UsuarioDto usuarioDto = null;
		
		for(Usuario usuario: usuarios) {			
			List<Object[]> proveedor = proveedoresDao.buscarPorUserId(usuario.getId_usuario());
			
			usuarioDto = new UsuarioDto();
			usuarioDto.setIdUsuario(usuario.getId_usuario());
			usuarioDto.setApellidos(usuario.getApellidosUsuario());
			usuarioDto.setNombres(usuario.getNombreUsuario());
			usuarioDto.setIdentificacion(usuario.getIdentificacionUsuario());
			usuarioDto.setEmail(usuario.getEmailUsuario());
			usuarioDto.setTelefono(usuario.getTelefonoUsuario());
			usuarioDto.setRole(usuario.getRoles());
			usuarioDto.setIdRole(usuario.getRoles().getId_rol());
			
			//Proveedor
			if(proveedor.isEmpty() == false) {
				usuarioDto.setIdProveedor((int) proveedor.get(0)[0]);
				usuarioDto.setNombreProveedor((String) proveedor.get(0)[1]);
				usuarioDto.setNombreRepresentante((String) proveedor.get(0)[2]);
			}
			
			usuariosDto.add(usuarioDto);
		}
		
		return usuariosDto;
	}	

}
