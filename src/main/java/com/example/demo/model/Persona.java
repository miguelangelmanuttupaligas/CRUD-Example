package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="personas")
@Getter
@Setter
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 8)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Date fecha_creacion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        return id != null && id.equals(((Persona) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
