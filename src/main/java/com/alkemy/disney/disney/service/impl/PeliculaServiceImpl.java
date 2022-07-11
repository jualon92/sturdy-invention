package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.Entity.PeliculaEntity;
import com.alkemy.disney.disney.Entity.PersonajeEntity;
import com.alkemy.disney.disney.dto.PeliculaDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.mapper.PeliculaMapper;
import com.alkemy.disney.disney.repository.PeliculaRepository;
import com.alkemy.disney.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl implements PeliculaService {


    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    PeliculaMapper peliculaMapper;


    public PeliculaDTO save(PeliculaDTO dto){

        PeliculaEntity peliculaEntity = peliculaMapper.peliculaDTO2Entity(dto);
        PeliculaEntity entitySaved = peliculaRepository.save(peliculaEntity);

        PeliculaDTO newDTO = peliculaMapper.peliculaEntity2DTO(entitySaved);
        System.out.println("GUARDAR PELICULA");
        return newDTO ;
    }

}

