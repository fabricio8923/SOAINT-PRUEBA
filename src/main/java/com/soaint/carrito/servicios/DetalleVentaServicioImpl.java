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
import com.soaint.carrito.dao.InterfaceDetalleVentaDao;
import com.soaint.carrito.domain.DetalleVenta;
import com.soaint.carrito.domain.Producto;

/**
 *
 * @author fabricio
 */
@Service
public class DetalleVentaServicioImpl implements DetalleVentaServicio {

    @Autowired
    private InterfaceDetalleVentaDao detalleVentaDao;

    @Override
    @Transactional(readOnly = true)
    public List<DetalleVenta> listarDetalleVenta() {
        return (List<DetalleVenta>) detalleVentaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(DetalleVenta detalleVenta) {
        detalleVentaDao.save(detalleVenta);
    }

    @Override
    @Transactional
    public void eliminar(DetalleVenta detalleVenta) {
        detalleVentaDao.delete(detalleVenta);
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleVenta encontrarDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaDao.findById(detalleVenta.getIdDetalleVenta()).orElse(null);
    }

    @Override
    public void eliminarById(Long id) {
        detalleVentaDao.deleteById(id);
    }

    @Override
    public void encontrarById(Long id) {
        detalleVentaDao.findById(id);
    }

}
