package com.alkemy.disney.disney.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    // oneToMany bidirectional, table responsible to create column with field peliculas
    @OneToMany(mappedBy="genero", cascade = CascadeType.ALL)
    private Set <PeliculaEntity> peliculas = new HashSet<>();
    */


}
