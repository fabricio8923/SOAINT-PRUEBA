/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.Controladores;


import com.soaint.carrito.domain.Producto;
import com.soaint.carrito.servicios.ProductoServicio;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author fabricio
 */
@Controller
@Slf4j
public class ControladorProducto {

    // @Value("${index.saludo}")
    // private String saludo;
    @Autowired
    private ProductoServicio productoServicio;

//    @GetMapping("/")
//    public String Inicio(Model modelo, @AuthenticationPrincipal User user) {
//        var saldoTotal = 0D;
//        var productos = productoServicio.listarProducto();
//        log.info("Ejecutando el controlador Spring MVC");
//        log.info("usuario que hizo login" + user);
//        modelo.addAttribute("lista", productos);
//        for(var p: productos){
//            saldoTotal +=p.getSaldo();
//        }
//        modelo.addAttribute("saldototal",saldoTotal);
//        modelo.addAttribute("totalproductos", productos.size());
//        return "index";
//    }

    @GetMapping("/agregar")
    public String Agregar(Producto producto) {
        return "modificar";

    }

    @GetMapping("/editar/{idproducto}")
    public String Editar(Producto producto, Model modelo) {
        producto = productoServicio.encontrarProducto(producto);
        modelo.addAttribute("producto", producto);
        return "modificar";

    }

    @GetMapping("/eliminar/{idproducto}")
    public String Eliminar(Producto producto, Model modelo) {
        productoServicio.eliminar(producto);
        return "redirect:/";

    }

    @GetMapping("/eliminar2")
    public String Eliminar2(Producto producto) {
        productoServicio.eliminar(producto);
        return "redirect:/";

    }

    @PostMapping("/guardar")
    public String Guardar(@Valid Producto producto, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        productoServicio.guardar(producto);
        return "redirect:/";
    }
}
