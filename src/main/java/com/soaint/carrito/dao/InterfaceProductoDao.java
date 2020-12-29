/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.dao;

import com.soaint.carrito.domain.Cliente;
import com.soaint.carrito.domain.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabricio
 */
public interface InterfaceProductoDao extends CrudRepository<Producto, Long> {
    
}
