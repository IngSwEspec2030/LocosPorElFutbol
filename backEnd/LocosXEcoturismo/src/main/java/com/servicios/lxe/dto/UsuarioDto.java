package com.servicios.lxe.dto;

import javax.validation.constraints.NotNull;

import com.servicios.lxe.model.Roles;

public class UsuarioDto {

	@NotNull() 
	private int idUsuario;
	
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
	
	public int idProveedor;
	
	// Datos proveedores	
	public String nombreProveedor;
	
	public String nombreRepresentante;
			

	public UsuarioDto(@NotNull int idUsuario, @NotNull String nombres,
			@NotNull String apellidos, @NotNull String identificacion, @NotNull String email, String password, 
			String telefono, int idRole, String nombreProveedor, String nombreRepresentante) {
		super();
		this.idUsuario = idUsuario;		
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.idRole = idRole;
		this.nombreProveedor = nombreProveedor;
		this.nombreRepresentante = nombreRepresentante;
	}

	public UsuarioDto() {
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	
	public String getNombreProveedor(){
		return this.nombreProveedor;
	}
	
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	
	public String getNombreRepresentante(){
		return this.nombreRepresentante;
	}
	
	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}
	
	public int getIdProveedor(){
		return this.idProveedor;
	}
	
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}		
	
}
