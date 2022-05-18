package com.example.demo.service;

import com.example.demo.model.Persona;

public interface PersonaService {
    void update(Persona persona);
    void create(Persona persona);
    void delete(String dni);
    Persona find(String dni);

}
