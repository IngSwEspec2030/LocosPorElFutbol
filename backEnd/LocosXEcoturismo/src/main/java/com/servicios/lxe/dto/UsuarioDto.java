package com.servicios.lxe.dto;

import javax.validation.constraints.NotNull;

import com.servicios.lxe.model.Roles;

public class UsuarioDto {

	@NotNull() 
	private int idUsuario;
	
	@NotNull()
	private int tipoUsuario;
	
	@NotNull()
	private String nombres;
	
	@NotNull()
	private String apellidos;
	
	@NotNull()
	private String identificacion;
	
	@NotNull()
	private String email;
	
	private String password;
	
	private String telefono;
	
	public Roles roles;
	
	public int idRole;
			

	public UsuarioDto(@NotNull int idUsuario, @NotNull int tipoUsuario, @NotNull String nombres,
			@NotNull String apellidos, @NotNull String identificacion, @NotNull String email, String password, 
			String telefono, int idRole) {
		super();
		this.idUsuario = idUsuario;
		this.tipoUsuario = tipoUsuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.idRole = idRole;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTelefono() {
		return password;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}	
	
	public Roles getRole(){
		return this.roles;
	}
	
	public void setRole(Roles roles) {
		this.roles = roles;
	}
	
}
