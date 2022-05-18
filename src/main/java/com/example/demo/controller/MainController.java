package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import jdk.tools.jmod.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Qualifier("PersonaService")
    private final PersonaService personaService;
    @Autowired
    public MainController(PersonaService personaService){
        this.personaService = personaService;
    }

    @PostMapping(value="persona/create")
    public void create(@RequestBody Persona persona){
        personaService.create(persona);
    }
    @GetMapping(value="persona/find/{dni}")
    public Persona find(@PathVariable String dni){
        return personaService.find(dni);
    }
    @DeleteMapping(value="persona/delete")
    public void delete(@RequestBody String dni){
        personaService.delete(dni);
    }
    @PutMapping(value="persona/update")
    public void update(@RequestBody Persona persona){
        personaService.update(persona);
    }
}
