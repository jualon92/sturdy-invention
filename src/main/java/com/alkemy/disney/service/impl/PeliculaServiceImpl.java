package com.alkemy.disney.service.impl;

import com.alkemy.disney.Entity.PeliculaEntity;
import com.alkemy.disney.Entity.PersonajeEntity;
import com.alkemy.disney.dto.PeliculaDTO;
import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.mapper.PeliculaMapper;
import com.alkemy.disney.repository.PeliculaRepository;
import com.alkemy.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {


    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    PeliculaMapper peliculaMapper;


    public PeliculaDTO save(PeliculaDTO dto){

        PeliculaEntity peliculaEntity = peliculaMapper.peliculaDTO2Entity(dto); // in: peliculaDTO.  out: peliculaEntity
        PeliculaEntity entitySaved = peliculaRepository.save(peliculaEntity);

        PeliculaDTO newDTO = peliculaMapper.peliculaEntity2DTO(entitySaved,true);
        System.out.println("GUARDAR PELICULA");
        return newDTO ;
    }
/*
    public List<PersonajeDTO> getAllPeliculas(){
        List<PersonajeEntity> peliculasEntities = (List<PersonajeEntity>) peliculaeRepository.findAll();
        List<PersonajeDTO> peliculasDTO = peliculaMapper.personajeEntity2DTOList(peliculasEntities,true);
        return peliculasDTO;
    }*/

    public List <PeliculaDTO> getAllPeliculas(){
        List<PeliculaEntity> peliculasEntities =  peliculaRepository.findAll(); // entity personajes list

        List<PeliculaDTO> peliculasDTO = peliculaMapper.peliculaEntity2DTOList(peliculasEntities,true); //

        return peliculasDTO;
    }

}

