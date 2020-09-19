package com.servicios.lxe.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicios.lxe.model.Usuario;

public interface IUsuario  extends JpaRepository<Usuario, Integer>{

}
