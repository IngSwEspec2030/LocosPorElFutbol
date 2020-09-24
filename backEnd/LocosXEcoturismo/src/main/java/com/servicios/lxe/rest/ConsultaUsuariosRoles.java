package com.servicios.lxe.rest;


import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.servicios.lxe.dao.UsuarioDao;
import com.servicios.lxe.dto.ActividadDto;
import com.servicios.lxe.dto.UsuarioDto;
import com.servicios.lxe.interfaces.IRoles;
import com.servicios.lxe.model.ActividadTuristica;
import com.servicios.lxe.model.Roles;
import com.servicios.lxe.model.SitioTuristico;
import com.servicios.lxe.model.Usuario;
import com.servicios.lxe.service.ServicioUsuario;


@CrossOrigin(origins="*")
@RestController
public class ConsultaUsuariosRoles {

	@Autowired
	private UsuarioDao usuario;
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	@Autowired
	private IRoles IRoles;
	
	@GetMapping("/getAutenticacion")
	public ResponseEntity<Usuario> consultarUsuario(@RequestParam String email, @RequestParam String passWord ){
		Usuario user = null;
		try{
			user =  usuario.consultarUsuarioXEmailPassWord(email, passWord);
		}catch(NoResultException ex) {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user/create")
	public ResponseEntity<Usuario> createUser(@RequestBody UsuarioDto newUser) throws IOException {		
				
		// No estoy seguro porque el getOne no trae el role
		List<Roles> roles = IRoles.findAll();
		Roles role = roles.get((newUser.idRole-1));		
		newUser.setRole(role);
		
		Usuario user = servicioUsuario.createUser(newUser);
		
		if (user == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId_usuario())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/user/update")
	public Usuario updateUser(@Valid @RequestBody UsuarioDto userToUpdate) throws Exception {
		Usuario usuario = servicioUsuario.updateUser(userToUpdate);
		return usuario;
	}		
	
	@GetMapping("/user/list")
	public List<UsuarioDto> getUsers() {
		List<UsuarioDto> usuarios = servicioUsuario.obtenerUsuarios();
		return usuarios;
	}	
}
