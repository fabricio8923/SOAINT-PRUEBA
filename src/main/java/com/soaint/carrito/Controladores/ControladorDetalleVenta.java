/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.Controladores;


import com.soaint.carrito.domain.DetalleVenta;
import com.soaint.carrito.servicios.DetalleVentaServicio;

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
public class ControladorDetalleVenta {

    // @Value("${index.saludo}")
    // private String saludo;
    @Autowired
    private DetalleVentaServicio detalleVentaServicio;

//    @GetMapping("/")
//    public String Inicio(Model modelo, @AuthenticationPrincipal User user) {
//        var saldoTotal = 0D;
//        var detalleVentas = detalleVentaServicio.listarDetalleVenta();
//        log.info("Ejecutando el controlador Spring MVC");
//        log.info("usuario que hizo login" + user);
//        modelo.addAttribute("lista", detalleVentas);
//        for(var p: detalleVentas){
//            saldoTotal +=p.getSaldo();
//        }
//        modelo.addAttribute("saldototal",saldoTotal);
//        modelo.addAttribute("totaldetalleVentas", detalleVentas.size());
//        return "index";
//    }

    @GetMapping("/agregar")
    public String Agregar(DetalleVenta detalleVenta) {
        return "modificar";

    }

    @GetMapping("/editar/{iddetalleVenta}")
    public String Editar(DetalleVenta detalleVenta, Model modelo) {
        detalleVenta = detalleVentaServicio.encontrarDetalleVenta(detalleVenta);
        modelo.addAttribute("detalleVenta", detalleVenta);
        return "modificar";

    }

    @GetMapping("/eliminar/{iddetalleVenta}")
    public String Eliminar(DetalleVenta detalleVenta, Model modelo) {
        detalleVentaServicio.eliminar(detalleVenta);
        return "redirect:/";

    }

    @GetMapping("/eliminar2")
    public String Eliminar2(DetalleVenta detalleVenta) {
        detalleVentaServicio.eliminar(detalleVenta);
        return "redirect:/";

    }

    @PostMapping("/guardar")
    public String Guardar(@Valid DetalleVenta detalleVenta, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        detalleVentaServicio.guardar(detalleVenta);
        return "redirect:/";
    }
}
