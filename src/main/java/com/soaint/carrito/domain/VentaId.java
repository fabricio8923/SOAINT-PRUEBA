/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.domain;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

/**
 *
 * @author fabricio
 */
@Data
public class VentaId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idventa;
    private Long idCliente;

    public VentaId(Long idventa, Long idCliente) {
        this.idventa = idventa;
        this.idCliente = idCliente;
    }

   
    
    
}
