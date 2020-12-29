/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.soaint.carrito.dao.InterfaceProductoDao;
import com.soaint.carrito.domain.Producto;

/**
 *
 * @author fabricio
 */
@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private InterfaceProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProducto() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void eliminar(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto encontrarProducto(Producto producto) {
        return productoDao.findById(producto.getIdproducto()).orElse(null);
    }

    @Override
    public void eliminarById(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    public void encontrarById(Long id) {
        productoDao.findById(id);
    }
}
