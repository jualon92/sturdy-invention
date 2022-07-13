package com.alkemy.disney.service.impl;

import com.alkemy.disney.Entity.PersonajeEntity;
import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.dto.PersonajeFiltersDTO;
import com.alkemy.disney.mapper.PersonajeMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.repository.specifications.CharacterSpecification;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository charactersRepository;

    @Autowired
    private CharacterSpecification characterSpecification;

    @Autowired
    private PersonajeMapper personajeMapper;

    @Override
    public List<PersonajeDTO> getByFilters(String nombre, Long edad, Long peso, Set<Long> peliculas, String order) {
        PersonajeFiltersDTO filtersDTO = new PersonajeFiltersDTO(nombre,edad,peso,peliculas,order); //wrapper class

        List<PersonajeEntity> entities = charactersRepository.findAll(characterSpecification.getByFilters(filtersDTO));


        List<PersonajeDTO> dtos = personajeMapper.personajeEntity2DTOList(entities,true);
        return dtos;

    }
}
