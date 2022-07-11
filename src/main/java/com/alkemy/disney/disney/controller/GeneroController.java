package com.alkemy.disney.disney.controller;


import com.alkemy.disney.disney.Entity.GeneroEntity;
import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")  //rest => mapping in plural
public class GeneroController {

    //init service(instead of static class or other)
    @Autowired
    private GeneroService generoService;
    // endpoint

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List<GeneroDTO> generos = generoService.getAllGeneros();
        return ResponseEntity.ok().body(generos); // returns if ok and body
    }
    @PostMapping
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO genero){ // return ResponseEntity del tipo GeneroDTO

        GeneroDTO generoGuardado = generoService.save(genero);

        //response 201  + data
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);  //response => header 201 (reason, value, etc) + json
    }
}
