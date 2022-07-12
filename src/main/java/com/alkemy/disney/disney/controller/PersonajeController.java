package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.Entity.PersonajeEntity;
import com.alkemy.disney.disney.dto.GeneroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.service.PersonajeService;

import java.util.List;
import java.util.Set;

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


    //GET ALL
    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getAll(){
        List<PersonajeDTO> personajes = personajeService.getAllPersonajes();
        return ResponseEntity.ok().body(personajes); // returns if ok and body
    }

    /*
    //adds movie to specific character
    @PostMapping("/{id}/pelicula/{idPelicula}")
    public ResponseEntity<Void> addPelicula(@PathVariable Long id, @PathVariable Long idPelicula){
        personajeService.addPelicula(id, idPelicula);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
*/


    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> updatePersonaje(@PathVariable Long id,@RequestBody PersonajeDTO personaje ){
        PersonajeDTO personajeGuardado = personajeService.update(id,personaje);

        //response 201  + data
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);  //response => header 201 (reason, value, etc) + json
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updatePersonaje(@PathVariable Long id){
        personajeService.delete(id);

        //response 201  + data
        return ResponseEntity.status(HttpStatus.CREATED).build();//response => header 201 (reason, value, etc) + json
    }



}
