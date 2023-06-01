package com.restapi.restapi.service.filter;

import com.restapi.restapi.model.dto.request.RequestDTO;
import com.restapi.restapi.model.dto.request.SearchRequestDTO;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterSpecification<T> {

    public Specification<T> getSearchSpecification(List<SearchRequestDTO> searchRequestDTOs, RequestDTO.GLobalOperator gLobalOperator){

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates= new ArrayList<>();
            for (SearchRequestDTO requestDTO :searchRequestDTOs) {
                Predicate equal = criteriaBuilder.equal(root.get(requestDTO.getColumn()),requestDTO.getValue());
                predicates.add(equal);
            }

            if (gLobalOperator.equals(RequestDTO.GLobalOperator.AND)){
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }else{
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }


        };
    }



}
