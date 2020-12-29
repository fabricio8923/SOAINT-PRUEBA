/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.Controladores;

import com.soaint.carrito.dao.InterfaceDetalleVentaDao;
import com.soaint.carrito.domain.DetalleVenta;
import com.soaint.carrito.servicios.DetalleVentaServicio;
import com.soaint.carrito.servicios.DetalleVentaServicioImpl;
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
public class ControladorDetalleVentaRest {

    @Autowired
    private DetalleVentaServicio detventaServicio;

//    @PostMapping
//    public ResponseEntity<?> crear(@RequestBody DetalleVenta detventa) {
//        log.info("Ejecutando el controlador rest de spring");
//        log.debug("mas detalle del controlador");
//        return ResponseEntity.status(HttpStatus.CREATED).body(detventaServicio.guardar(detventa));
//    }
    @GetMapping("/detventa/lista")
    public List<DetalleVenta> listaDetalleVentas() {
        return (List<DetalleVenta>) detventaServicio.listarDetalleVenta();
    }

    @PostMapping("/detventa/agregar")
    public void nuevoDetalleVenta(@RequestBody DetalleVenta detventa) {
        detventaServicio.guardar(detventa);
    }

    @PutMapping("/detventa/{id}")
    public void modificarDetalleVenta(@RequestBody DetalleVenta detventa, @PathVariable Long id) {

        detventaServicio.encontrarById(id);
        detventaServicio.guardar(detventa);
    }

    @DeleteMapping("/detventa/eliminar")
    public void Eliminar(@PathVariable Long id) {
        detventaServicio.eliminarById(id);

    }
}
