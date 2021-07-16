package com.usercard.domain.user;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<UserEntity> getSpecification(String name, String phoneNumber) {
        return null;
    }
}
