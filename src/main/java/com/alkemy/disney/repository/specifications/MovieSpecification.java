package com.alkemy.disney.repository.specifications;

import com.alkemy.disney.entity.PeliculaEntity;
import com.alkemy.disney.dto.MovieFiltersDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieSpecification {

    public Specification<PeliculaEntity> getByFilters(MovieFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            System.out.println(filtersDTO.getTitulo());
            //filter by Title
            if(StringUtils.hasLength(filtersDTO.getTitulo())){ //if name exists
                System.out.println(filtersDTO.getTitulo());
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")),
                                "%" + filtersDTO.getTitulo().toLowerCase() + "%"
                        )
                );
            }
            /*
            //filter by idGenero
            if(filtersDTO.getEdad() != null){// Long wrapper defaults to 0
                Long edad = filtersDTO.getEdad();
                predicates.add(
                        criteriaBuilder.equal(root.<Long>get("edad"),edad
                        )
                );
            }
            */

            //filter by genero id
            if(filtersDTO.getIdGenero() != null){// Long wrapper defaults to 0
                Long generoId = filtersDTO.getIdGenero();
                predicates.add(
                        criteriaBuilder.equal(root.<Long>get("generoId"),generoId
                        )
                );
            }

            /*
            //movies that he/she was in
            if (!CollectionUtils.isEmpty(filtersDTO.getPeliculas())){
                Join<PeliculaEntity,PersonajeEntity> join = root.join("peliculas", JoinType.INNER);
                Expression<String> peliculasId = join.get("id");
                predicates.add(peliculasId.in(filtersDTO.getPeliculas()));


            }   */

            query.distinct(true); //remove repeated

            String orderByField = "fechaDeCreacion";


            query.orderBy(   // if filter isAsc, order asc by nombre,  else order desc
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) : criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));



        };

    }
}
