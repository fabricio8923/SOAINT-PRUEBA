/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.Controladores;

import com.soaint.carrito.dao.InterfaceVentaDao;
import com.soaint.carrito.domain.Venta;
import com.soaint.carrito.servicios.VentaServicio;
import com.soaint.carrito.servicios.VentaServicioImpl;
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
public class ControladorVentaRest {

    @Autowired
    private VentaServicio ventaServicio;

//    @PostMapping
//    public ResponseEntity<?> crear(@RequestBody Venta venta) {
//        log.info("Ejecutando el controlador rest de spring");
//        log.debug("mas detalle del controlador");
//        return ResponseEntity.status(HttpStatus.CREATED).body(ventaServicio.guardar(venta));
//    }
    @GetMapping("/ventas/lista")
    public List<Venta> listaVentas() {
        return (List<Venta>) ventaServicio.listarVenta();
    }

    @PostMapping("/ventas/agregar")
    public void nuevoVenta(@RequestBody Venta venta) {
        ventaServicio.guardar(venta);
    }

    @PutMapping("/ventas/{id}")
    public void modificarVenta(@RequestBody Venta venta, @PathVariable Long id) {

        ventaServicio.encontrarById(id);
        ventaServicio.guardar(venta);
    }

    @DeleteMapping("/venta/eliminar")
    public void Eliminar(@PathVariable Long id) {
        ventaServicio.eliminarById(id);

    }
}
