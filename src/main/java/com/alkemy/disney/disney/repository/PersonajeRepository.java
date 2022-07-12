package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.Entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.disney.disney.Entity.PersonajeEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonajeRepository  extends JpaRepository<PersonajeEntity,Long> {

}
