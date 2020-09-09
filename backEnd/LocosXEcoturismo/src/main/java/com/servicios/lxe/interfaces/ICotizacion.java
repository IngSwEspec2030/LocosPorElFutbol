package com.servicios.lxe.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servicios.lxe.model.CotizacionEntity;

public interface ICotizacion extends JpaRepository<CotizacionEntity, Integer> {

}
