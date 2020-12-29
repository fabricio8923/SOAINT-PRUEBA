package com.soaint.carrito.servicios;

import com.soaint.carrito.domain.Cliente;
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
public interface ClienteServicio {

    public List<Cliente> listarCliente();

    public void guardar(Cliente cliente);

    public void eliminar(Cliente cliente);
    
    public void eliminarById(Long id);
    
    public void encontrarById(Long id);

    public Cliente encontrarCliente(Cliente cliente);

}
