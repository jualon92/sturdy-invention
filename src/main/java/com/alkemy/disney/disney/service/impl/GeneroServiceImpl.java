package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.Entity.GeneroEntity;
import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.mapper.GeneroMapper;
import com.alkemy.disney.disney.repository.GeneroRepository;
import com.alkemy.disney.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;

    @Autowired
    private GeneroRepository generoRepository;


    public List<GeneroDTO> getAllGeneros(){
         List<GeneroEntity> generosEntities = generoRepository.findAll();
         List<GeneroDTO> generosDTO = generoMapper.generoEntity2DTOList(generosEntities);
         return generosDTO;


    }
    public GeneroDTO save(GeneroDTO dto){ //create
        //TODO: save Entity and return new GeneroDTO
        //use mapper to generate a new entity and save it with repo.
        GeneroEntity generoEntity = generoMapper.generoDTO2Entity(dto); //asign new entity
        GeneroEntity entitySaved = generoRepository.save(generoEntity);

        //generate a new dto from previous entity via mapper
        GeneroDTO newDTO = generoMapper.generoEntity2DTO(entitySaved);
        System.out.println("GUARDAR GENERO");
        return newDTO ;
    }
}
