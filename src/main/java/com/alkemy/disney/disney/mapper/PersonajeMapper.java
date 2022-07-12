package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.Entity.GeneroEntity;
import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.dto.PeliculaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.disney.disney.Entity.PersonajeEntity;
import com.alkemy.disney.disney.dto.PersonajeDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class PersonajeMapper {

    @Autowired
    private PeliculaMapper peliculaMapper;

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

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity, boolean loadPeliculas){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(entity.getId());
        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setNombre(entity.getNombre());
        personajeDTO.setEdad(entity.getEdad());
        personajeDTO.setPeso(entity.getPeso());
        personajeDTO.setHistoria(entity.getHistoria());

        if(loadPeliculas){ //
            System.out.println(entity.getPeliculas());
            List<PeliculaDTO> peliculasDTO =  peliculaMapper.peliculaEntity2DTOList(entity.getPeliculas(), false); //dont load icons
            System.out.println("Inner");
            System.out.println(peliculasDTO);
            personajeDTO.setPeliculas(peliculasDTO);
        }

        return personajeDTO;
    }
    public void updateAtributes(PersonajeEntity personajeEntity, PersonajeDTO personajeFinal){
        personajeEntity.setEdad(personajeFinal.getEdad());
        personajeEntity.setHistoria(personajeFinal.getHistoria());
        personajeEntity.setImagen(personajeFinal.getImagen());
        personajeEntity.setNombre(personajeFinal.getNombre());

    }
    public List<PersonajeDTO> personajeEntity2DTOList(Collection<PersonajeEntity> entitiesIniciales){

        List<PersonajeDTO> dtosFinal = new ArrayList<PersonajeDTO>();

        /*
        for (int i = 0; i < entitiesIniciales.size(); i++){
            //converts entity to dto
            GeneroDTO nuevoDTO = generoEntity2DTO(entities.get(i));
            dtosFinal.add(nuevoDTO);
        }*/

        for (PersonajeEntity personaje: entitiesIniciales
        ) {
            PersonajeDTO newDTO = personajeEntity2DTO(personaje,false);
            dtosFinal.add(newDTO);

        }


        return dtosFinal;
    }


    public List<PersonajeDTO> personajeEntity2DTOList(Collection<PersonajeEntity> entitiesIniciales, boolean loadPeliculas){

        List<PersonajeDTO> dtosFinal = new ArrayList<PersonajeDTO>();

        /*
        for (int i = 0; i < entitiesIniciales.size(); i++){
            //converts entity to dto
            GeneroDTO nuevoDTO = generoEntity2DTO(entities.get(i));
            dtosFinal.add(nuevoDTO);
        }*/

        for (PersonajeEntity personaje: entitiesIniciales
        ) {
            PersonajeDTO newDTO = personajeEntity2DTO(personaje,loadPeliculas);
            dtosFinal.add(newDTO);

        }


        return dtosFinal;
    }

}
