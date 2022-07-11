package com.alkemy.disney.disney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.service.PersonajeService;

@RestController
@RequestMapping("personajes")
public class PersonajeController {
    
    @Autowired
    PersonajeService personajeService;

    //CREATE
    @GetMapping
    public ResponseEntity<PersonajeDTO> get(RequestParam {id}){
        
        PersonajeDTO personaje = personajeService.getPersonaje(id);
        return ResponseEntity.ok().body(personaje); // returns if ok and body
    }
}
