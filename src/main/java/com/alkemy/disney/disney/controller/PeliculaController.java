package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.PeliculaDTO;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("peliculas")
public class PeliculaController {


    @Autowired
    PeliculaService peliculaService;

    //CREATE
    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO pelicula){ // return ResponseEntity del tipo GeneroDTO
        PeliculaDTO peliculaGuardada = peliculaService.save(pelicula);

        //response 201  + data
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);  //response => header 201 (reason, value, etc) + json
    }



}
