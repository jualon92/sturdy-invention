package com.alkemy.disney.mapper;


import com.alkemy.disney.entity.GeneroEntity;
import com.alkemy.disney.dto.GeneroDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2Entity(GeneroDTO dto){
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(dto.getImagen()); //id is set by Entity schema
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;

    }

    public GeneroDTO generoEntity2DTO(GeneroEntity entity){
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setId(entity.getId());
        generoDTO.setImagen(entity.getImagen());
        generoDTO.setNombre(entity.getNombre());
        return generoDTO;

    }

    public List<GeneroDTO> generoEntity2DTOList(List<GeneroEntity> entitiesIniciales){

        List<GeneroDTO> dtosFinal = new ArrayList<>();

        /*
        for (int i = 0; i < entitiesIniciales.size(); i++){
            //converts entity to dto
            GeneroDTO nuevoDTO = generoEntity2DTO(entities.get(i));
            dtosFinal.add(nuevoDTO);
        }*/

        for (GeneroEntity genero: entitiesIniciales
             ) {
            GeneroDTO newDTO = generoEntity2DTO(genero);
            dtosFinal.add(newDTO);
            
        }
        
        
        return dtosFinal;
    }
}
