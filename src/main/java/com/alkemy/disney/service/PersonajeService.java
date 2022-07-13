package com.alkemy.disney.service;

import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.dto.PersonajeDTOBasic;

import java.util.List;


public interface PersonajeService{

    PersonajeDTOBasic save(PersonajeDTOBasic dto);
    PersonajeDTO getDetailsById(Long id);
    List<PersonajeDTO> getAllPersonajes();
    void addPelicula(Long id, Long idPelicula);
    void delete(Long id);

    PersonajeDTO update(Long id, PersonajeDTO personajeDTO);

   /* List<PersonajeDTO>  getByFilters(String name, Date date, String peliculas, String order);*/
}
