package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface MovieService {
    List<MovieDTO> getByFilters(String name,  Long idGenero, String order);
    void addPersonaje(Long idPelicula, Long idPersonaje);
    void removePersonaje(Long idPelicula, Long idPersonaje);
}
