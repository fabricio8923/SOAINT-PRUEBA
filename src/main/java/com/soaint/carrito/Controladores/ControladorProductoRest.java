/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.Controladores;

import com.soaint.carrito.dao.InterfaceProductoDao;
import com.soaint.carrito.domain.Producto;
import com.soaint.carrito.servicios.ProductoServicio;
import com.soaint.carrito.servicios.ProductoServicioImpl;
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
public class ControladorProductoRest {

    @Autowired
    private ProductoServicio productoServicio;

//    @PostMapping
//    public ResponseEntity<?> crear(@RequestBody Producto producto) {
//        log.info("Ejecutando el controlador rest de spring");
//        log.debug("mas detalle del controlador");
//        return ResponseEntity.status(HttpStatus.CREATED).body(productoServicio.guardar(producto));
//    }
    @GetMapping("/productos/lista")
    public List<Producto> listaProductos() {
        return (List<Producto>) productoServicio.listarProducto();
    }

    @PostMapping("/productos/agregar")
    public void nuevoProducto(@RequestBody Producto producto) {
        productoServicio.guardar(producto);
    }

    @PutMapping("/productos/{id}")
    public void modificarProducto(@RequestBody Producto producto, @PathVariable Long id) {

        productoServicio.encontrarById(id);
        productoServicio.guardar(producto);
    }

    @DeleteMapping("/producto/eliminar")
    public void Eliminar(@PathVariable Long id) {
        productoServicio.eliminarById(id);

    }
}
