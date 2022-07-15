package com.alkemy.disney.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class MovieFiltersDTO {

    private String titulo;


    private Long idGenero;

    private String order;

    public MovieFiltersDTO(String titulo,  Long idGenero, String order) {

        this.titulo = titulo;
        this.idGenero = idGenero;
        this.order = order;
    }



    public boolean isASC() { return order.compareToIgnoreCase("ASC") == 0;}
    public boolean isDESC() { return order.compareToIgnoreCase("DESC") == 0;}
}
