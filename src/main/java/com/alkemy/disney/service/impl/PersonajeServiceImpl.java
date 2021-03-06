package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.PersonajeDTOBasic;
import com.alkemy.disney.exception.ErrorDispatcher;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.repository.PeliculaRepository;
import com.alkemy.disney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.disney.entity.PersonajeEntity;
import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.mapper.PersonajeMapper;
import com.alkemy.disney.service.PersonajeService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements PersonajeService{
    
    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;


    @Autowired
    private PersonajeMapper personajeMapper;

    //CREATE
    public PersonajeDTOBasic save(PersonajeDTOBasic dto){ //when saving return basic information, no need for movies
        //TODO: save Entity and return new GeneroDTO

        //use mapper to generate a new entity and save it with repo.
        PersonajeEntity personajeEntity = personajeMapper.personajeDTO2EntityBasic(dto); //asign new entity

        PersonajeEntity entitySaved = personajeRepository.save(personajeEntity);

        //generate a new dto from previous entity via mapper
        return personajeMapper.personajeEntity2DTOBasic(entitySaved);

    }


    public List<PersonajeDTO> getAllPersonajes(){
        List<PersonajeEntity> personajesEntities =  personajeRepository.findAll(); // entity personajes list


        List<PersonajeDTO> personajesDTO = personajeMapper.personajeEntity2DTOList(personajesEntities,true); //
        System.out.println(personajesDTO.toString());
        return personajesDTO;
    }


    public PersonajeDTO getDetailsById(Long id){ //it needs some tests, i.e: get request with an invalid id


        PersonajeEntity  foundEntity = personajeRepository.findById(id).orElseThrow( () -> new ParamNotFound(ErrorDispatcher.PERSONAJENOTFOUND()));


         return personajeMapper.personajeEntity2DTO(foundEntity, true);



    }

    public PersonajeDTO update(Long id, PersonajeDTO personajeDTO){
        PersonajeEntity personajeEntity = personajeRepository.findById(id).orElseThrow( () -> new ParamNotFound(ErrorDispatcher.PERSONAJENOTFOUND()));


        personajeMapper.updateAtributes(personajeEntity, personajeDTO);
        personajeRepository.save(personajeEntity);

        return personajeMapper.personajeEntity2DTO(personajeEntity, true);
    }

    public void delete(Long id){

        //checks if it exists in the first place
         PersonajeEntity personajeEntity  = personajeRepository.findById(id).orElseThrow( () -> new ParamNotFound(ErrorDispatcher.PERSONAJENOTFOUND()));



        //soft delete
        personajeRepository.deleteById(id);

    }

}
