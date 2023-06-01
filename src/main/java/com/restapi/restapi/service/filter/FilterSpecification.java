package com.restapi.restapi.service.filter;

import com.restapi.restapi.model.dto.request.RequestDTO;
import com.restapi.restapi.model.dto.request.SearchRequestDTO;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FilterSpecification<T> {

    public Specification<T> getSearchSpecification(List<SearchRequestDTO> searchRequestDTOs, RequestDTO.GLobalOperator gLobalOperator){

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates= new ArrayList<>();
            for (SearchRequestDTO requestDTO :searchRequestDTOs) {

                switch (requestDTO.getOperation()){

                    case EQUAL:
                        Predicate equal=criteriaBuilder.equal(root.get(requestDTO.getColumn()),requestDTO.getValue());
                        predicates.add(equal);
                        break;
                    case LIKE:
                        Predicate like = criteriaBuilder.like(root.get(requestDTO.getColumn()), "%"+requestDTO.getValue()+"%");
                        predicates.add(like);
                        break;

                    case IN:
                        String[] split = requestDTO.getValue().split("\\s*,\\s*"); //for split and trim
                        Predicate in = root.get(requestDTO.getColumn()).in(Arrays.asList(split));
                        predicates.add(in);
                        break;

                    case GREATER_THAN:
                        Predicate greaterThan = criteriaBuilder.greaterThan(root.get(requestDTO.getColumn()), requestDTO.getValue());
                        predicates.add(greaterThan);
                        break;

                    case LESS_THAN:
                        Predicate lessThan = criteriaBuilder.lessThan(root.get(requestDTO.getColumn()), requestDTO.getValue());
                        predicates.add(lessThan);
                        break;

                    case BETWEEN:
                        String[] split1 = requestDTO.getValue().split(",");
                        Predicate between = criteriaBuilder.between(root.get(requestDTO.getColumn()), Long.parseLong(split1[0]),Long.parseLong( split1[1]));
                        predicates.add(between);
                        break;
                }
            }
            if (gLobalOperator.equals(RequestDTO.GLobalOperator.AND)){
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }else{
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }


        };
    }



}
