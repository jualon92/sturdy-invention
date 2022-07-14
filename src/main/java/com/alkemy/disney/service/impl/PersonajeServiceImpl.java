package com.alkemy.disney.service.impl;

import com.alkemy.disney.Entity.PeliculaEntity;
import com.alkemy.disney.dto.PersonajeDTOBasic;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.repository.PeliculaRepository;
import com.alkemy.disney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.disney.Entity.PersonajeEntity;
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
        PersonajeDTOBasic newDTO = personajeMapper.personajeEntity2DTOBasic(entitySaved);

        return newDTO ;
    }


    public List<PersonajeDTO> getAllPersonajes(){
        List<PersonajeEntity> personajesEntities =  personajeRepository.findAll(); // entity personajes list


        List<PersonajeDTO> personajesDTO = personajeMapper.personajeEntity2DTOList(personajesEntities,true); //
        System.out.println(personajesDTO.toString());
        return personajesDTO;
    }


    public PersonajeDTO getDetailsById(Long id){ //it needs some tests, i.e: get request with an invalid id


        Optional<PersonajeEntity> foundEntity = personajeRepository.findById(id);
        if (!foundEntity.isPresent()){
            throw new ParamNotFound("Id personaje no valida"); // rest exception handler should catch param not found
        }


         PersonajeDTO dto = personajeMapper.personajeEntity2DTO(foundEntity.get(), true);

        return dto;

    }

    public PersonajeDTO update(Long id, PersonajeDTO personajeDTO){
        Optional<PersonajeEntity> foundEntity = personajeRepository.findById(id);
        if (!foundEntity.isPresent()){
            throw new ParamNotFound("Id personaje no valida"); // rest exception handler should catch param not found
        }

        PersonajeEntity personajeEntity = foundEntity.get();
        personajeMapper.updateAtributes(personajeEntity, personajeDTO);
        personajeRepository.save(personajeEntity);

        return personajeMapper.personajeEntity2DTO(personajeEntity, true);
    }

    public void delete(Long id){

        //checks if it exists in the first place
        Optional<PersonajeEntity> foundEntity = personajeRepository.findById(id);
        if (!foundEntity.isPresent()){
            throw new ParamNotFound("Id personaje no valida"); // rest exception handler should catch param not found
        }


        //soft delete
        personajeRepository.deleteById(id);

    }

    //ADD PELICULA
    public void addPelicula(Long id, Long idPelicula){

        Optional<PersonajeEntity> foundPersonaje= personajeRepository.findById(id);  //dos entities buscadas
        Optional<PeliculaEntity> foundPelicula = peliculaRepository.findById(idPelicula);
        System.out.println("pre");
        System.out.println(personajeRepository.findById(id).get().getPeliculas());
        if (!foundPersonaje.isPresent()){
            throw new ParamNotFound("Id personaje no valida"); // rest exception handler should catch param not found
        }
        if (!foundPelicula.isPresent()){
            throw new ParamNotFound("Id pelicula no valida"); // rest exception handler should catch param not found
        }

        foundPersonaje.get().getPeliculas().size();
        foundPelicula.get().getPersonajes().size();

        PersonajeEntity personajeEntity = foundPersonaje.get();
        PeliculaEntity peliculaEntity = foundPelicula.get();


        //update and save
          personajeEntity.addPelicula(peliculaEntity);


          this.personajeRepository.save(personajeEntity);


    }
}
