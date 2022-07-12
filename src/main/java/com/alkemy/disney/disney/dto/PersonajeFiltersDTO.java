package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonajeFiltersDTO {

    private String nombre;
    private Long edad;
    private Long peso;
    private Set<Long> peliculas;
    private String order;

    public PersonajeFiltersDTO(String nombre, Long edad, Long peso, Set<Long> peliculas, String order) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.peliculas = peliculas;
        this.order = order;
    }


    public boolean isASC() { return order.compareToIgnoreCase("ASC") == 0;}
    public boolean isDESC() { return order.compareToIgnoreCase("DESC") == 0;}
}
