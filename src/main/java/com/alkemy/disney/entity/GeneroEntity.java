package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Genero")
@Getter
@Setter

public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String imagen;


    /*
    // oneToMany bidirectional, PeliculaEntity as owner-side in the relationship
    @OneToMany(mappedBy="genero", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private Set <PeliculaEntity> peliculas = new HashSet<>();
    */


}
