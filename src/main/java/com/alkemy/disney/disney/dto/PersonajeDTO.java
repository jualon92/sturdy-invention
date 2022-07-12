package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PersonajeDTO { //plain class
    private long id;

    private String imagen;
    private String nombre;
    private Long edad;
    private Long peso;
    private String historia;
    private List<PeliculaDTO> peliculas;

}
