package com.alkemy.disney.disney.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Personaje")
@Getter
@Setter

public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String imagen;
    private String nombre;
    private Long edad;
    private Long peso;
    private String historia;


    @ManyToMany(mappedBy="personajes", cascade = CascadeType.ALL)
    private Set<PeliculaEntity> peliculas = new HashSet<>();

}
