/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.servicios;

import com.soaint.carrito.dao.InterfaceClienteDao;
import com.soaint.carrito.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fabricio
 */
@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private InterfaceClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarCliente() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void eliminar(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente encontrarCliente(Cliente cliente) {
       return  clienteDao.findById(cliente.getIdcliente()).orElse(null);
    }

    @Override
    public void eliminarById(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    public void encontrarById(Long id) {
        clienteDao.findById(id);
    }

}
