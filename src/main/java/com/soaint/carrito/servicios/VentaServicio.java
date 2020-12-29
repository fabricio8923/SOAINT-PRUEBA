package com.soaint.carrito.servicios;

import com.soaint.carrito.domain.Producto;
import com.soaint.carrito.domain.Venta;
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
public interface VentaServicio {

    public List<Venta> listarVenta();

    public void guardar(Venta venta);

    public void eliminar(Venta venta);

    public Venta encontrarVenta(Venta venta);

    public void eliminarById(Long id);

    public void encontrarById(Long id);

}
