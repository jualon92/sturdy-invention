package com.alkemy.disney.service;

import com.alkemy.disney.dto.PersonajeDTO;

import java.util.List;
import java.util.Set;

public interface CharacterService {
     List<PersonajeDTO> getByFilters(String name, Long edad, Long peso, Set<Long> peliculas, String order);
}
