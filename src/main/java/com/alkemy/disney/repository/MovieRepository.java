package com.alkemy.disney.repository;

import com.alkemy.disney.entity.PeliculaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<PeliculaEntity, Long> ,JpaSpecificationExecutor<PeliculaEntity> {

    List<PeliculaEntity> findAll(Specification<PeliculaEntity> spec);


}
