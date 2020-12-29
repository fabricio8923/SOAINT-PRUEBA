package com.soaint.carrito.servicios;

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
public interface ProductoServicio {

    public List<Producto> listarProducto();

    public void guardar(Producto producto);

    public void eliminar(Producto producto);

    public Producto encontrarProducto(Producto producto);

    public void eliminarById(Long id);

    public void encontrarById(Long id);

}
