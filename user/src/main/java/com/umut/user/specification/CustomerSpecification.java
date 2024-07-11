package com.umut.user.specification;

import com.umut.user.entity.Customer;
import com.umut.user.model.Status;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CustomerSpecification {
    public static final Locale locale =  new Locale("tr", "TR");

    public static Specification<Customer> findByStatus(Status status) {
        return ((root, query, criteriaBuilder) -> {
            if (status == null)
                return criteriaBuilder.equal(root.get("status"), Status.ACTIVE.toString());
            return criteriaBuilder.equal(root.get("status"), status.toString());
        });
    }

    public static Specification<Customer> findByName(String name) {
        return ((root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty())
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            return criteriaBuilder.equal(criteriaBuilder.lower(root.get("name")), name.toLowerCase(locale));
        });
    }

    public static Specification<Customer> search(Status status, String name) {
        return Specification.where(
                CustomerSpecification.findByStatus(status)
                        .and(CustomerSpecification.findByName(name))
        );
    }
}
