/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soaint.carrito.Controladores;


import com.soaint.carrito.domain.Cliente;
import com.soaint.carrito.servicios.ClienteServicio;

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
public class ControladorCliente {

    // @Value("${index.saludo}")
    // private String saludo;
    @Autowired
    private ClienteServicio clienteServicio;

//    @GetMapping("/")
//    public String Inicio(Model modelo, @AuthenticationPrincipal User user) {
//        var saldoTotal = 0D;
//        var clientes = clienteServicio.listarCliente();
//        log.info("Ejecutando el controlador Spring MVC");
//        log.info("usuario que hizo login" + user);
//        modelo.addAttribute("lista", clientes);
//        for(var p: clientes){
//            saldoTotal +=p.getSaldo();
//        }
//        modelo.addAttribute("saldototal",saldoTotal);
//        modelo.addAttribute("totalclientes", clientes.size());
//        return "index";
//    }

    @GetMapping("/agregar")
    public String Agregar(Cliente cliente) {
        return "modificar";

    }

    @GetMapping("/editar/{idcliente}")
    public String Editar(Cliente cliente, Model modelo) {
        cliente = clienteServicio.encontrarCliente(cliente);
        modelo.addAttribute("cliente", cliente);
        return "modificar";

    }

    @GetMapping("/eliminar/{idcliente}")
    public String Eliminar(Cliente cliente, Model modelo) {
        clienteServicio.eliminar(cliente);
        return "redirect:/";

    }

    @GetMapping("/eliminar2")
    public String Eliminar2(Cliente cliente) {
        clienteServicio.eliminar(cliente);
        return "redirect:/";

    }

    @PostMapping("/guardar")
    public String Guardar(@Valid Cliente cliente, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        clienteServicio.guardar(cliente);
        return "redirect:/";
    }
}
