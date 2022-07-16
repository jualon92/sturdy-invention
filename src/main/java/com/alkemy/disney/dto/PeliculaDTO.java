package com.alkemy.disney.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PeliculaDTO {
    private long id;

    private String imagen;
    private String titulo;

    private LocalDate fechaDeCreacion;
    private Long calificacion;
    private Long generoId;
    private List<PersonajeDTO> personajes;


}
