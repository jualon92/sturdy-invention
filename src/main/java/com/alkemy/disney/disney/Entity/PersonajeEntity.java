package com.alkemy.disney.disney.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


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

}
