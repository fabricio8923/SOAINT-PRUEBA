package com.soaint.carrito.servicios;

import com.soaint.carrito.domain.DetalleVenta;
import com.soaint.carrito.domain.Producto;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fabricio
 */
public interface DetalleVentaServicio {

    public List<DetalleVenta> listarDetalleVenta();

    public void guardar(DetalleVenta detalleVenta);

    public void eliminar(DetalleVenta detalleVenta);

    public DetalleVenta encontrarDetalleVenta(DetalleVenta detalleVenta);

    public void eliminarById(Long id);

    public void encontrarById(Long id);

}
