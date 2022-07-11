package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.Entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository  extends JpaRepository<PeliculaEntity,Long> {

}
