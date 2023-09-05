package com.examination.dto;

import com.examination.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDto implements Validator {

    private String name;
    private int quantity;
    private int price;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (productDto.getName().equals("")) {
            errors.rejectValue("name", null,"Not Blank");
        } else if (!productDto.getName().matches("^[a-zA-Z]+$")) {
            errors.rejectValue("name", null, "Invalid Name");
        }

        if (productDto.getPrice() < 0) {
            errors.rejectValue("price", null, "Cannot < 0");
        } else if (productDto.getPrice() == 0) {
            errors.rejectValue("price", null, "Not Blank");
        }

        if (productDto.getQuantity() < 0) {
            errors.rejectValue("quantity",null, "Cannot < 0");
        } else if (productDto.getQuantity() == 0) {
            errors.rejectValue("quantity", null, "Not Blank");
        }
    }

    public ProductDto() {
    }

    public ProductDto(String name, int quantity, int price, Category category) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
