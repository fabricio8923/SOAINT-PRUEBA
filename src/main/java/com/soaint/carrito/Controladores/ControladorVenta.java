/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.Controladores;


import com.soaint.carrito.domain.Venta;
import com.soaint.carrito.servicios.VentaServicio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class ControladorVenta {

    // @Value("${index.saludo}")
    // private String saludo;
    @Autowired
    private VentaServicio ventaServicio;

//    @GetMapping("/")
//    public String Inicio(Model modelo, @AuthenticationPrincipal User user) {
//        var saldoTotal = 0D;
//        var ventas = ventaServicio.listarVenta();
//        log.info("Ejecutando el controlador Spring MVC");
//        log.info("usuario que hizo login" + user);
//        modelo.addAttribute("lista", ventas);
//        for(var p: ventas){
//            saldoTotal +=p.getSaldo();
//        }
//        modelo.addAttribute("saldototal",saldoTotal);
//        modelo.addAttribute("totalventas", ventas.size());
//        return "index";
//    }

    @GetMapping("/agregar")
    public String Agregar(Venta venta) {
        return "modificar";

    }

    @GetMapping("/editar/{idventa}")
    public String Editar(Venta venta, Model modelo) {
        venta = ventaServicio.encontrarVenta(venta);
        modelo.addAttribute("venta", venta);
        return "modificar";

    }

    @GetMapping("/eliminar/{idventa}")
    public String Eliminar(Venta venta, Model modelo) {
        ventaServicio.eliminar(venta);
        return "redirect:/";

    }

    @GetMapping("/eliminar2")
    public String Eliminar2(Venta venta) {
        ventaServicio.eliminar(venta);
        return "redirect:/";

    }

    @PostMapping("/guardar")
    public String Guardar(@Valid Venta venta, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        ventaServicio.guardar(venta);
        return "redirect:/";
    }
}
