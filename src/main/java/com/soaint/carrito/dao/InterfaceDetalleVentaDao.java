/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.dao;

import com.soaint.carrito.domain.DetalleVenta;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabricio
 */
public interface InterfaceDetalleVentaDao extends CrudRepository<DetalleVenta, Long> {
    
}
