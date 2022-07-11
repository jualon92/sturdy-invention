package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.PersonajeDTO;

import java.util.List;


public interface PersonajeService{

    PersonajeDTO save(PersonajeDTO dto);
    PersonajeDTO getDetailsById(Long id);
    List<PersonajeDTO> getAllPersonajes();
    PersonajeDTO addPelicula(Long id, Long idPelicula);
}
