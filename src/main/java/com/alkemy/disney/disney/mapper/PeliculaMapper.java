package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.Entity.GeneroEntity;
import com.alkemy.disney.disney.Entity.PeliculaEntity;
import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.dto.PeliculaDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PeliculaMapper {
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

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity){
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(entity.getId());
        peliculaDTO.setImagen(entity.getImagen());
        peliculaDTO.setTitulo(entity.getTitulo());
        peliculaDTO.setFechaDeCreacion(entity.getFechaDeCreacion());
        peliculaDTO.setCalificacion(entity.getCalificacion());
        peliculaDTO.setGeneroId(entity.getGeneroId());


        return peliculaDTO;
    }

    public Set<PeliculaDTO> peliculaEntity2DTOList(Set<PeliculaEntity> entitiesIniciales){

        Set<PeliculaDTO> dtosFinal = new HashSet<PeliculaDTO>() {
        };

        /*
        for (int i = 0; i < entitiesIniciales.size(); i++){
            //converts entity to dto
            GeneroDTO nuevoDTO = generoEntity2DTO(entities.get(i));
            dtosFinal.add(nuevoDTO);
        }*/

        for (PeliculaEntity genero: entitiesIniciales
        ) {
            PeliculaDTO newDTO = peliculaEntity2DTO(genero);
            dtosFinal.add(newDTO);

        }


        return dtosFinal;
    }
}

