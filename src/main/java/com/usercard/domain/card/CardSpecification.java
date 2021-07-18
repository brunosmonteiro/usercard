package com.usercard.domain.card;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CardSpecification {
    public static Specification<Card> get(CardFlag flag, String number, Long owner) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (flag != null) {
                predicates.add(criteriaBuilder.equal(root.get("flag"), flag));
            }
            if (number != null) {
                predicates.add(criteriaBuilder.equal(root.get("number"), number));
            }
            if (owner != null) {
                predicates.add(criteriaBuilder.equal(root.get("owner"), owner));
            }
            return criteriaBuilder.and((Predicate[]) predicates.toArray());
        };
    }
}
