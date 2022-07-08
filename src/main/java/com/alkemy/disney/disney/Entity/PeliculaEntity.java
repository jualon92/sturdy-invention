package com.alkemy.disney.disney.Entity;



import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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

    //personajes asociados
    //@ManyToOne

}
