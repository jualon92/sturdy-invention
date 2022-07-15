package com.alkemy.disney.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Personaje")
@Getter
@Setter
@SQLDelete(sql = "UPDATE personaje SET deleted = true where id=?")
@Where(clause = "deleted=false")

public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String imagen;
    private String nombre;
    private Long edad;
    private Long peso;
    private String historia;

    private boolean deleted = Boolean.FALSE;



    @ManyToMany(mappedBy="personajes")
    private List<PeliculaEntity> peliculas = new ArrayList<>();


}
