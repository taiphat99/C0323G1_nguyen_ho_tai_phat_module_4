package com.user.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RoleDTO implements Validator {
    private Integer id;
    private String name;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
