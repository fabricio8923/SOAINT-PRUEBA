/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
/**
 *
 * @author fabricio
 */
@Data
@Entity
@IdClass(VentaId.class)
@Table(name = "Venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long idventa;
    @Id
    private Long idCliente;
    @NotEmpty
    private Date fecha;
  
    @ManyToOne
    @JoinColumn(name = "Cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "DetalleVenta")
    private DetalleVenta detalleVenta;

}
