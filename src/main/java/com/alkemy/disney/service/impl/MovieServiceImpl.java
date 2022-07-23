package com.alkemy.disney.service.impl;

import com.alkemy.disney.entity.PeliculaEntity;
import com.alkemy.disney.entity.PersonajeEntity;
import com.alkemy.disney.dto.*;
import com.alkemy.disney.exception.ErrorDispatcher;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.PeliculaMapper;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.repository.PeliculaRepository;
import com.alkemy.disney.repository.PersonajeRepository;
import com.alkemy.disney.repository.specifications.MovieSpecification;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService  {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;


    @Autowired
    private MovieSpecification movieSpecification;

    @Autowired
    private PeliculaMapper peliculaMapper;



    @Override
    public List<MovieDTO> getByFilters(String titulo,  Long idGenero, String order) {
        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(titulo, idGenero,order); //wrapper class

        List<PeliculaEntity> entities = movieRepository.findAll(movieSpecification.getByFilters(filtersDTO));

        if (entities.isEmpty()){  // error handling when returning empty list
            throw new ParamNotFound("No match! :("); // rest exception handler should catch param not found
        }

        //mapping pelicula entity collection to peliculadto collection , and then to moviesDTO
       /* List<PeliculaDTO> dtos = peliculaMapper.peliculaEntity2DTOList(entities,false);
        List<MovieDTO> movies = peliculaMapper.peliculasToMoviesList(dtos);*/

        //movieDTO is a subset of PeliculaDTO with limited information.  maps peliculaEntity to a collection of moviesDTO
        return peliculaMapper.peliculaEntity2DTOMovies(entities);

    }


    //ADD PELICULA
    public void addPersonaje(Long idPelicula, Long idPersonaje){

        PeliculaEntity peliculaEntity = peliculaRepository.findById(idPelicula).orElseThrow( () -> new ParamNotFound(ErrorDispatcher.PERSONAJENOTFOUND())); //dos entities buscadas
        PersonajeEntity  personajeEntity = personajeRepository.findById(idPersonaje).orElseThrow( () -> new ParamNotFound(ErrorDispatcher.PERSONAJENOTFOUND())); //dos entities buscadas

        //update and save
        peliculaEntity.addPersonaje(personajeEntity);


        this.peliculaRepository.save(peliculaEntity);

    }


    public void removePersonaje(Long idPelicula, Long idPersonaje){

        PeliculaEntity peliculaEntity = peliculaRepository.findById(idPelicula).orElseThrow( () -> new ParamNotFound(ErrorDispatcher.PELICULANOTFOUND())); //dos entities buscadas
        PersonajeEntity  personajeEntity = personajeRepository.findById(idPersonaje).orElseThrow( () -> new ParamNotFound(ErrorDispatcher.PELICULANOTFOUND())); //dos entities buscadas

        //update and save
        peliculaEntity.removePersonaje(personajeEntity);

        this.peliculaRepository.save(peliculaEntity);


    }
}



