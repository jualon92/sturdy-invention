package com.alkemy.disney.controller;

import com.alkemy.disney.dto.PeliculaDTO;
import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> getAll(){
        List<PeliculaDTO> peliculas = peliculaService.getAllPeliculas();
        return ResponseEntity.ok().body(peliculas); // returns if ok and body
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> updatePelicula(@PathVariable Long id,@RequestBody PeliculaDTO pelicula ){
        PeliculaDTO peliculaGuardado = peliculaService.update(id,pelicula);

        //response 201  + data
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardado);  //response => header 201 (reason, value, etc) + json
    }




}
