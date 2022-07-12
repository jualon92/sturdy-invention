package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.Entity.PersonajeEntity;
import com.alkemy.disney.disney.dto.PersonajeDTO;

import java.util.Date;
import java.util.List;


public interface PersonajeService{

    PersonajeDTO save(PersonajeDTO dto);
    PersonajeDTO getDetailsById(Long id);
    List<PersonajeDTO> getAllPersonajes();
    void addPelicula(Long id, Long idPelicula);
    void delete(Long id);

    PersonajeDTO update(Long id, PersonajeDTO personajeDTO);

   /* List<PersonajeDTO>  getByFilters(String name, Date date, String peliculas, String order);*/
}
