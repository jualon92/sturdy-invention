package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovieDTO {
    private long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaDeCreacion;



}
