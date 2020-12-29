/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.Controladores;

import com.soaint.carrito.dao.InterfaceClienteDao;
import com.soaint.carrito.domain.Cliente;
import com.soaint.carrito.servicios.ClienteServicio;
import com.soaint.carrito.servicios.ClienteServicioImpl;
import java.util.List;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fabricio
 */
@RestController
@Slf4j
public class ControladorClienteRest {

    @Autowired
    private ClienteServicio clienteServicio;

//    @PostMapping
//    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
//        log.info("Ejecutando el controlador rest de spring");
//        log.debug("mas detalle del controlador");
//        return ResponseEntity.status(HttpStatus.CREATED).body(clienteServicio.guardar(cliente));
//    }
    @GetMapping("/clientes/lista")
    public List<Cliente> listaClientes() {
        return (List<Cliente>) clienteServicio.listarCliente();
    }

    @PostMapping("/clientes/agregar")
    public void nuevoCliente(@RequestBody Cliente cliente) {
        clienteServicio.guardar(cliente);
    }

    @PutMapping("/clientes/{id}")
    public void modificarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {

        clienteServicio.encontrarById(id);
    }

    @DeleteMapping("/cliente/eliminar")
    public void Eliminar(@PathVariable Long id) {
        clienteServicio.eliminarById(id);

    }
}
