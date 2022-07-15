package com.alkemy.disney.entity;



import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "Pelicula")
@Getter
@Setter

public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String imagen;
    private String titulo;


    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")   //format
    private LocalDate fechaDeCreacion; // date object

    @Min(value=1)
    @Max(value=5)
    private Long calificacion;


    //fetch type eager makes the continent data available to work with
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genero_id", updatable = false, insertable = false)
    private GeneroEntity genero;

    // mostly for insert/delete
    @Column(name = "genero_id", nullable = false)
    private Long generoId;

    /*
    @ManyToOne()
    private GeneroEntity genero;
    */

    @ManyToMany( // movies added with actors
            cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn( name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private List<PersonajeEntity> personajes = new ArrayList<>();


    public void addPersonaje(PersonajeEntity personaje) {

        personajes.add(personaje);

    }
    public void removePersonaje(PersonajeEntity personaje){  personajes.remove(personaje);}

}
