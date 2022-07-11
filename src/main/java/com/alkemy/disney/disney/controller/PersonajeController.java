package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.GeneroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.service.PersonajeService;

import java.util.List;

@RestController
@RequestMapping("personajes")
public class PersonajeController {
    
    @Autowired
    PersonajeService personajeService;


    //CREATE
    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje){ // return ResponseEntity del tipo GeneroDTO

        PersonajeDTO personajeGuardado = personajeService.save(personaje);

        //response 201  + data
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);  //response => header 201 (reason, value, etc) + json
    }


    //GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> get(@PathVariable Long id){
        
        PersonajeDTO personaje = personajeService.getDetailsById(id);
        return ResponseEntity.ok().body(personaje); // returns if ok and body
    }


    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getAll(){
        List<PersonajeDTO> personajes = personajeService.getAllPersonajes();
        return ResponseEntity.ok().body(personajes); // returns if ok and body
    }

    //adds movie

    @PostMapping("{id}/pelicula/{idPelicula}")
    public ResponseEntity<Void> addPelicula(@PathVariable Long id, @PathVariable Long idPelicula){
        personajeService.addPelicula(id, idPelicula);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
