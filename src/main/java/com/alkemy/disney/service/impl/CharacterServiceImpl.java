package com.alkemy.disney.service.impl;

import com.alkemy.disney.entity.PersonajeEntity;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.PersonajeFiltersDTO;
import com.alkemy.disney.exception.ParamNotFound;
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
    public List<CharacterDTO> getByFilters(String nombre, Long edad, Long peso, Set<Long> peliculas, String order) {
        PersonajeFiltersDTO filtersDTO = new PersonajeFiltersDTO(nombre,edad,peso,peliculas,order); //wrapper class

        List<PersonajeEntity> entities = charactersRepository.findAll(characterSpecification.getByFilters(filtersDTO));


        if (entities.isEmpty()){  // error handling when returning empty list
            throw new ParamNotFound("No match! :("); // rest exception handler should catch param not found
        }


        return  personajeMapper.personajeEntity2DTOListIdentity(entities);

    }
}
