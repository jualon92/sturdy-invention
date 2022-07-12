package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.Entity.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<PersonajeEntity, Long> ,JpaSpecificationExecutor<PersonajeEntity> {

    List<PersonajeEntity> findAll(Specification<PersonajeEntity> spec);


}
