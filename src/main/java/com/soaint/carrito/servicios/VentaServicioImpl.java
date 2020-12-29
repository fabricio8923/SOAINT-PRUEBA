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
import com.soaint.carrito.dao.InterfaceVentaDao;
import com.soaint.carrito.domain.Venta;

/**
 *
 * @author fabricio
 */
@Service
public class VentaServicioImpl implements VentaServicio {

    @Autowired
    private InterfaceVentaDao ventaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Venta> listarVenta() {
        return (List<Venta>) ventaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Venta venta) {
        ventaDao.save(venta);
    }

    @Override
    @Transactional
    public void eliminar(Venta venta) {
        ventaDao.delete(venta);
    }

    @Override
    @Transactional(readOnly = true)
    public Venta encontrarVenta(Venta venta) {
        return ventaDao.findById(venta.getIdventa()).orElse(null);
    }

    @Override
    public void eliminarById(Long id) {
        ventaDao.deleteById(id);
    }

    @Override
    public void encontrarById(Long id) {
        ventaDao.findById(id);
    }

}
