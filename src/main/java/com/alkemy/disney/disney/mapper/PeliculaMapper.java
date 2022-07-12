package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.Entity.GeneroEntity;
import com.alkemy.disney.disney.Entity.PeliculaEntity;
import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.dto.PeliculaDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PeliculaMapper {

    @Autowired
    private PersonajeMapper personajeMapper;

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto){
        PeliculaEntity peliculaEntity = new PeliculaEntity();

        //could be a function to avoid repeatedlogic
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaDeCreacion(dto.getFechaDeCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setGeneroId(dto.getGeneroId());
        return peliculaEntity;
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity, boolean loadPersonajes){
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(entity.getId());
        peliculaDTO.setImagen(entity.getImagen());
        peliculaDTO.setTitulo(entity.getTitulo());
        peliculaDTO.setFechaDeCreacion(entity.getFechaDeCreacion());
        peliculaDTO.setCalificacion(entity.getCalificacion());
        peliculaDTO.setGeneroId(entity.getGeneroId());

        if(loadPersonajes){
            List<PersonajeDTO> personajesDTO =  personajeMapper.personajeEntity2DTOList(entity.getPersonajes(),  false);
            peliculaDTO.setPersonajes(personajesDTO);
        }

        return peliculaDTO;
    }


    public List<PeliculaDTO> peliculaEntity2DTOList(Collection<PeliculaEntity> entitiesIniciales, boolean loadPersonajes){

        List<PeliculaDTO> dtosFinal = new ArrayList<>() {
        };



        for (PeliculaEntity pelicula: entitiesIniciales
        ) {
            PeliculaDTO newDTO = this.peliculaEntity2DTO(pelicula, loadPersonajes);
            dtosFinal.add(newDTO);

        }
        System.out.println("dto conversion");
        System.out.println(dtosFinal);
        return dtosFinal;
    }
}

