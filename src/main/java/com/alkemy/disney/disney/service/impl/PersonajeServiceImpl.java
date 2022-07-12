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
        PersonajeDTO newDTO = personajeMapper.personajeEntity2DTO(entitySaved, false);
        System.out.println("GUARDAR PERSONAJE");
        return newDTO ;
    }


    public List<PersonajeDTO> getAllPersonajes(){
        List<PersonajeEntity> personajesEntities = (List<PersonajeEntity>) personajeRepository.findAll();
        List<PersonajeDTO> personajesDTO = personajeMapper.personajeEntity2DTOList(personajesEntities,true);
        return personajesDTO;
    }


    public PersonajeDTO getDetailsById(Long id){ //it needs some tests, i.e: get request with an invalid id


        Optional<PersonajeEntity> foundEntity = personajeRepository.findById(id);
        System.out.println(foundEntity.get().getPeliculas());

        if (!foundEntity.isPresent()){
            throw new ParamNotFound("Id personaje no valida"); // rest exception handler should catch param not found
        }
      //  System.out.println("ya");
      //  System.out.println(foundEntity.get().getId());

         PersonajeDTO dto = personajeMapper.personajeEntity2DTO(foundEntity.get(), true);
      //  System.out.println(personajeRepository.findByPelicula_id(foundEntity));
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



        System.out.println("final");
        System.out.println(personajeRepository.findById(id).get().getPeliculas());
    }
}
