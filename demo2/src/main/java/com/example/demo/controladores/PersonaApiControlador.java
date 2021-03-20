/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controladores;

import com.example.demo.modelos.Persona;
import com.example.demo.servicios.PersonaServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guzma
 * 
 */
@RestController
@RequestMapping(value="/ws/persona")
public class PersonaApiControlador {
    
    @Autowired
    private PersonaServicio servicio;
    
    @GetMapping(value="/")
    public List<Persona> getTodos(){
         return servicio.getTodos();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Persona> getValor(@PathVariable Long id){
        return servicio.getValor(id);
    }
    
    @PostMapping(value="/guardar")
    public Persona guardar(@RequestBody Persona persona ){
        return servicio.guardar(persona);
    }
    
    @GetMapping(value="/eliminar/{id}")
    public Optional<Persona> eliminar(@PathVariable Long id){
        Optional<Persona> personaEliminada = servicio.getValor(id);
        servicio.eliminar(id);
        return personaEliminada;
    }
}

    

