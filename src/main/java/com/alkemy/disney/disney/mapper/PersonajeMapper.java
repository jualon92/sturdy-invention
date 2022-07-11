package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.Entity.GeneroEntity;
import com.alkemy.disney.disney.dto.GeneroDTO;
import org.springframework.stereotype.Component;

import com.alkemy.disney.disney.Entity.PersonajeEntity;
import com.alkemy.disney.disney.dto.PersonajeDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {
    
    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
        PersonajeEntity personajeEntity = new PersonajeEntity();

        //could be a function to avoid repeatedlogic
        personajeEntity.setImagen(dto.getImagen()); //id is set by Entity schema
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(entity.getId());
        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setNombre(entity.getNombre());
        personajeDTO.setEdad(entity.getEdad());
        personajeDTO.setPeso(entity.getPeso());
        personajeDTO.setHistoria(entity.getHistoria());
        return personajeDTO;
    }

    public List<PersonajeDTO> personajeEntity2DTOList(List<PersonajeEntity> entitiesIniciales){

        List<PersonajeDTO> dtosFinal = new ArrayList<PersonajeDTO>();

        /*
        for (int i = 0; i < entitiesIniciales.size(); i++){
            //converts entity to dto
            GeneroDTO nuevoDTO = generoEntity2DTO(entities.get(i));
            dtosFinal.add(nuevoDTO);
        }*/

        for (PersonajeEntity personaje: entitiesIniciales
        ) {
            PersonajeDTO newDTO = personajeEntity2DTO(personaje);
            dtosFinal.add(newDTO);

        }


        return dtosFinal;
    }

}
