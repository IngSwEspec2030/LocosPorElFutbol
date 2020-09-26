package com.servicios.lxe.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicios.lxe.model.Imagen;

public interface IImage  extends JpaRepository<Imagen, Integer>{

}
