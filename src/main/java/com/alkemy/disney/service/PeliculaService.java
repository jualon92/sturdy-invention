package com.alkemy.disney.service;

import com.alkemy.disney.dto.PeliculaDTO;
import com.alkemy.disney.dto.PersonajeDTO;

import java.util.List;

public interface PeliculaService{
    PeliculaDTO update(Long id,PeliculaDTO dto);
    PeliculaDTO save(PeliculaDTO dto);
    List<PeliculaDTO> getAllPeliculas();
}
