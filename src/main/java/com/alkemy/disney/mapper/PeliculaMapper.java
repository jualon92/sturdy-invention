package com.alkemy.disney.mapper;

import com.alkemy.disney.entity.PeliculaEntity;
import com.alkemy.disney.entity.PersonajeEntity;
import com.alkemy.disney.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class PeliculaMapper {

    @Autowired
    private PersonajeMapper personajeMapper;


    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto){
        PeliculaEntity peliculaEntity = new PeliculaEntity();

        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());

        peliculaEntity.setFechaDeCreacion(dto.getFechaDeCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setGeneroId(dto.getGeneroId());

        // tomo lista de personajesDTO.  devuelvo lista de personajeEntity
                  List<PersonajeEntity> personajeEntities = personajeMapper.personajeDTO2EntityList(dto.getPersonajes(),false);
                  peliculaEntity.setPersonajes(personajeEntities);



        return peliculaEntity;
    }


    public void updateAtributes(PeliculaEntity peliculaEntity, PeliculaDTO dto){
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());

        peliculaEntity.setFechaDeCreacion(dto.getFechaDeCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());

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

        List<PeliculaDTO> dtosFinal = new ArrayList<>();



        for (PeliculaEntity pelicula: entitiesIniciales
        ) {
            PeliculaDTO newDTO = this.peliculaEntity2DTO(pelicula, loadPersonajes);
            dtosFinal.add(newDTO);

        }
        System.out.println("dto conversion");
        System.out.println(dtosFinal);
        return dtosFinal;
    }





    public List<PeliculaEntity> peliculaDTO2EntityList(Collection<PeliculaDTO> dtoIniciales, boolean loadPersonajes){

        List<PeliculaEntity> entitiesArr = new ArrayList<>();



        for (PeliculaDTO pelicula: dtoIniciales
        ) {
            PeliculaEntity entity = this.peliculaDTO2Entity(pelicula);
            entitiesArr.add(entity);

        }

        return entitiesArr;
    }

    public List<MovieDTO> peliculaEntity2DTOMovies(Collection<PeliculaEntity> entitiesIniciales){

        List<MovieDTO> dtosFinal = new ArrayList<>();


        for (PeliculaEntity pelicula: entitiesIniciales
        ) {
            MovieDTO newDTO = peliculaEntity2DTOMovie(pelicula);
            dtosFinal.add(newDTO);

        }


        return dtosFinal;
    }


    public MovieDTO peliculaEntity2DTOMovie(PeliculaEntity entity){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setImagen(entity.getImagen());
        movieDTO.setTitulo(entity.getTitulo());
        movieDTO.setFechaDeCreacion(entity.getFechaDeCreacion());
        return movieDTO;
    }


}

