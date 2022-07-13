package com.alkemy.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.disney.Entity.PersonajeEntity;

@Repository
public interface PersonajeRepository  extends JpaRepository<PersonajeEntity,Long> {

}
