package com.alkemy.disney.disney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.disney.disney.Entity.PersonajeEntity;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.mapper.PersonajeMapper;
import com.alkemy.disney.disney.repository.PersonajeRepository;
import com.alkemy.disney.disney.service.PersonajeService;

@Service
public class PersonajeServiceImpl implements PersonajeService{
    
    @Autowired
    private PersonajeRepository personajeRepository;
    
    @Autowired
    private PersonajeMapper personajeMapper; 


    public PersonajeDTO getPersonaje(Long id){
        //rever
        PersonajeEntity foundEntity = personajeRepository.findById(id).orElseThrow(); 

        PersonajeDTO dto = personajeMapper.personajeEntity2DTO(foundEntity);
         
        return dto;

    }
}
