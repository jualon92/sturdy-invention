package com.alkemy.disney.disney.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    // oneToMany bidirectional
    @OneToMany(mapped by="pelicula")
    private Set<PeliculaEntity> peliculas = new HashSet<PeliculaEntity>();
    */


}
