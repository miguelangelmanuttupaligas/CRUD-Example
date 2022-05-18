package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("PersonaService")
public class PersonaServiceImpl implements PersonaService{
    @Qualifier("PersonaRepository")
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }


    @Override
    public void update(Persona persona) {
        Persona p = personaRepository.findByDni(persona.getDni());
        p.setNombre(persona.getNombre());
        personaRepository.save(p);
    }

    @Override
    public void create(Persona persona) {
        if(personaRepository.findByDni(persona.getDni())==null){
            personaRepository.save(persona);
        }
    }
    //Arreglar
    @Override
    public void delete(String dni) {
        Persona p = personaRepository.findByDni(dni);
        personaRepository.deleteById(p.getId());
    }

    @Override
    public Persona find(String dni) {
        Persona p = personaRepository.findByDni(dni);
        System.out.println(p.getDni());
        System.out.println(p.getNombre());
        return personaRepository.findByDni(dni);
    }
}
