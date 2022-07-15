package com.alkemy.disney.controller;


import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.service.CharacterService;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    //  sql query with dynamic params
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getDetailsByFilters(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Long idGenero, //query param name
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<MovieDTO> movies = movieService.getByFilters(titulo,idGenero,order);
        return ResponseEntity.ok(movies);

    }
}


