package com.alkemy.disney.repository.specifications;

import com.alkemy.disney.entity.PeliculaEntity;
import com.alkemy.disney.entity.PersonajeEntity;
import com.alkemy.disney.dto.PersonajeFiltersDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Join;

@Component
public class CharacterSpecification {

    public Specification<PersonajeEntity> getByFilters(PersonajeFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            System.out.println(filtersDTO.getNombre());
            //filter by name
            if(StringUtils.hasLength(filtersDTO.getNombre())){ //if name exists
                System.out.println(filtersDTO.getNombre());
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%" + filtersDTO.getNombre().toLowerCase() + "%"
                        )
                );
            }

            //filter by edad
            if(filtersDTO.getEdad() != null){// Long wrapper defaults to 0
                Long edad = filtersDTO.getEdad();
                predicates.add(
                        criteriaBuilder.equal(root.<Long>get("edad"),edad
                        )
                );
            }


            //filter by peso
            if(filtersDTO.getPeso() != null){// Long wrapper defaults to 0
                Long edad = filtersDTO.getPeso();
                predicates.add(
                        criteriaBuilder.equal(root.<Long>get("peso"),edad
                        )
                );
            }


            //movies that he/she was in
            if (!CollectionUtils.isEmpty(filtersDTO.getPeliculas())){
                Join<PeliculaEntity,PersonajeEntity> join = root.join("peliculas", JoinType.INNER);
                Expression<String> peliculasId = join.get("id");
                predicates.add(peliculasId.in(filtersDTO.getPeliculas()));


            }

            query.distinct(true); //remove repeated

            String orderByField = "nombre";

            /*
            query.orderBy(   // if filter isAsc, order asc by nombre,  else order desc
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) : criteriaBuilder.desc(root.get(orderByField))
            );*/

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));



        };

    }
}
