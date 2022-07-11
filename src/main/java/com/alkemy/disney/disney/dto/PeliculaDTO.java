package com.alkemy.disney.disney.dto;

import com.alkemy.disney.disney.Entity.GeneroEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PeliculaDTO {
    private long id;

    private String imagen;
    private String titulo;
    private LocalDate fechaDeCreacion;
    private Long calificacion;
    private Long generoId;


}
