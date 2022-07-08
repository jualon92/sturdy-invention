package com.alkemy.disney.disney.Entity;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
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

    //buscar informarcion, va a traer obj genero entero por fetch type eager
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id", updatable = false, insertable = false)
    private GeneroEntity genero;

    //
    @Column(name = "genero_id", nullable = false)
    private Long generoId;



    @ManyToMany(
            cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn( name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<PersonajeEntity> personajes = new HashSet<>();


}
