package com.alkemy.disney.disney.controller;


import com.alkemy.disney.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alkemy.disney.disney.dto.PersonajeDTO;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;
    //  sql query with dynamic params
    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getDetailsByFilters(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Long edad,
            @RequestParam(required = false) Long peso,
            @RequestParam(required = false) Set<Long> peliculas,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<PersonajeDTO> personajes = characterService.getByFilters(nombre,edad,peso,peliculas,order);
        return ResponseEntity.ok(personajes);

    }
}
