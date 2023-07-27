package com.user.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDTO implements Validator {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
//        Name
        if (userDTO.getName().equals("")) {
            errors.rejectValue("name", null, "Cannot be empty!");
        } else if (!userDTO.getName().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
            errors.rejectValue("name", null, "Invalid Name!");
        }
//        Email
        if (userDTO.getEmail().equals("")) {
            errors.rejectValue("email", null, "Cannot be empty!");
        } else if (!userDTO.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", null, "Invalid Email!");
        }
//        Phone Number
        if (userDTO.getPhoneNumber().equals("")) {
            errors.rejectValue("phoneNumber", null, "Cannot be empty!");
        } else if (!userDTO.getPhoneNumber().matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
            errors.rejectValue("phoneNumber", null, "Invalid Phone Number!");
        }
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
