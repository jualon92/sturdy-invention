package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
