package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.Entity.GeneroEntity;
import com.alkemy.disney.disney.Entity.PeliculaEntity;
import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.exception.ParamNotFound;
import com.alkemy.disney.disney.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.disney.disney.Entity.PersonajeEntity;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.mapper.PersonajeMapper;
import com.alkemy.disney.disney.repository.PersonajeRepository;
import com.alkemy.disney.disney.service.PersonajeService;

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
    public PersonajeDTO save(PersonajeDTO dto){
        //TODO: save Entity and return new GeneroDTO
        //use mapper to generate a new entity and save it with repo.
        PersonajeEntity personajeEntity = personajeMapper.personajeDTO2Entity(dto); //asign new entity
        PersonajeEntity entitySaved = personajeRepository.save(personajeEntity);

        //generate a new dto from previous entity via mapper
        PersonajeDTO newDTO = personajeMapper.personajeEntity2DTO(entitySaved);
        System.out.println("GUARDAR PERSONAJE");
        return newDTO ;
    }


    public List<PersonajeDTO> getAllPersonajes(){
        List<PersonajeEntity> personajesEntities = personajeRepository.findAll();
        List<PersonajeDTO> personajesDTO = personajeMapper.personajeEntity2DTOList(personajesEntities);
        return personajesDTO;


    }


    public PersonajeDTO getDetailsById(Long id){ //it needs some tests, i.e: get request with an invalid id


        Optional<PersonajeEntity> foundEntity = personajeRepository.findById(id);
        if (!foundEntity.isPresent()){
            throw new ParamNotFound("Id personaje no valida"); // rest exception handler should catch param not found
        }

        PersonajeDTO dto = personajeMapper.personajeEntity2DTO(foundEntity.get());
         
        return dto;

    }


    //ADD PELICULA
    public PersonajeDTO addPelicula(Long id, Long idPelicula){
        Optional<PersonajeEntity> foundPersonaje= personajeRepository.findById(id);
        Optional<PeliculaEntity> foundPelicula = peliculaRepository.findById(idPelicula);

        PersonajeEntity personaje = foundPersonaje.get();
        PeliculaEntity pelicula = foundPelicula.get();

        personaje.getPeliculas().add(pelicula);


        PersonajeDTO dto = personajeMapper.personajeEntity2DTO(personaje);
        this.save(dto);
        return dto;


    }
}
