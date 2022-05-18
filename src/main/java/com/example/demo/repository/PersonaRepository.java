package com.example.demo.repository;

import com.example.demo.model.Persona;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PersonasRepository")
public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Persona findByDni(String dni);

    void deleteByDni(String dni);
}
