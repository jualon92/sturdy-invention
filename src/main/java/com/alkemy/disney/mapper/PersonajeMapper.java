package com.alkemy.disney.mapper;

import com.alkemy.disney.entity.PeliculaEntity;
import com.alkemy.disney.dto.PeliculaDTO;
import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.dto.PersonajeDTOBasic;
import com.alkemy.disney.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.disney.entity.PersonajeEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PersonajeMapper {

    @Autowired
    private PeliculaMapper peliculaMapper;

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto, boolean loadPersonaje){
        PersonajeEntity personajeEntity = new PersonajeEntity();


        personajeEntity.setImagen(dto.getImagen()); //id  set by Entity
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        personajeEntity.setEdad(dto.getPeso());

        //converts List<PeliculaDTO> into List<PeliculaEntity>
        if(loadPersonaje){

            List<PeliculaEntity> peliculasEntities =  peliculaMapper.peliculaDTO2EntityList(dto.getPeliculas(), true);
            personajeEntity.setPeliculas(peliculasEntities);
        }

        return personajeEntity;
    }

    public PersonajeEntity personajeDTO2EntityBasic(PersonajeDTOBasic dto){
        PersonajeEntity personajeEntity = new PersonajeEntity();


        personajeEntity.setImagen(dto.getImagen()); //id  set by Entity
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        personajeEntity.setEdad(dto.getPeso());

        return personajeEntity;
    }



    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity, boolean loadPeliculas){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(entity.getId());
        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setNombre(entity.getNombre());
        personajeDTO.setEdad(entity.getEdad());
        personajeDTO.setPeso(entity.getPeso());
        personajeDTO.setHistoria(entity.getHistoria());

        if(loadPeliculas){
            List<PeliculaDTO> peliculasDTO =  peliculaMapper.peliculaEntity2DTOList(entity.getPeliculas(), false); //dont load icons

            personajeDTO.setPeliculas(peliculasDTO);
        }

        return personajeDTO;
    }


    public CharacterDTO personajeEntity2DTOIdentity(PersonajeEntity entity){
        CharacterDTO personajeDTO = new CharacterDTO();

        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setNombre(entity.getNombre());

        return personajeDTO;
    }


    public PersonajeDTOBasic personajeEntity2DTOBasic(PersonajeEntity entity){
        PersonajeDTOBasic personajeDTOBasic = new PersonajeDTOBasic();
        personajeDTOBasic.setId(entity.getId());
        personajeDTOBasic.setImagen(entity.getImagen());
        personajeDTOBasic.setNombre(entity.getNombre());
        personajeDTOBasic.setEdad(entity.getEdad());
        personajeDTOBasic.setPeso(entity.getPeso());
        personajeDTOBasic.setHistoria(entity.getHistoria());

        return personajeDTOBasic;
    }


    public List<PersonajeEntity> personajeDTO2EntityList(List <PersonajeDTO> personajes, boolean loadPeliculas){
        List<PersonajeEntity> entities = new ArrayList<>();



        for (PersonajeDTO personaje : personajes
        ) {
            PersonajeEntity newEntity =  personajeDTO2Entity(personaje,loadPeliculas);
            entities.add(newEntity);

        }

        return entities;
    }



    public void updateAtributes(PersonajeEntity personajeEntity, PersonajeDTO personajeFinal){
        personajeEntity.setEdad(personajeFinal.getEdad());
        personajeEntity.setHistoria(personajeFinal.getHistoria());
        personajeEntity.setImagen(personajeFinal.getImagen());
        personajeEntity.setNombre(personajeFinal.getNombre());

    }




    public List<CharacterDTO> personajeEntity2DTOListIdentity(Collection<PersonajeEntity> entitiesIniciales){

        List<CharacterDTO> dtosFinal = new ArrayList<>();


        for (PersonajeEntity personaje: entitiesIniciales
        ) {
            CharacterDTO newDTO = personajeEntity2DTOIdentity(personaje);
            dtosFinal.add(newDTO);

        }


        return dtosFinal;
    }





    public List<PersonajeDTO> personajeEntity2DTOList(List<PersonajeEntity> entitiesIniciales, boolean loadPeliculas){

        List<PersonajeDTO> dtosFinal = new ArrayList<>();


        for (PersonajeEntity personaje: entitiesIniciales
        ) {

            PersonajeDTO newDTO = personajeEntity2DTO(personaje,loadPeliculas);
            dtosFinal.add(newDTO);

        }

        return dtosFinal;
    }




}
