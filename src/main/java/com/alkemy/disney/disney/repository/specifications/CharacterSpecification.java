package com.alkemy.disney.disney.repository.specifications;

import com.alkemy.disney.disney.Entity.PersonajeEntity;
import com.alkemy.disney.disney.dto.PersonajeFiltersDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


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


            query.distinct(true); //remove repeated

            String orderByField = "nombre";
            query.orderBy(   // if filter isAsc, order asc by nombre,  else order desc
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) : criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));



        };

    }
}
