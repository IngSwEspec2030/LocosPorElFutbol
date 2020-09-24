package com.servicios.lxe.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;

import com.servicios.lxe.model.Proveedor;


public interface IProveedor extends JpaRepository<Proveedor, Integer>{

}
