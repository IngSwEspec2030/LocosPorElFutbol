package com.servicios.lxe.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.servicios.lxe.model.Proveedor;
import com.servicios.lxe.model.Usuario;


public interface IProveedor extends JpaRepository<Proveedor, Integer>{

}
