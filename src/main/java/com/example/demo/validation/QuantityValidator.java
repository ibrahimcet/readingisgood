package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QuantityValidator implements ConstraintValidator<Quantity, Integer> {


    @Override
    public boolean isValid(Integer quantity, ConstraintValidatorContext context) {

        if (quantity > 0){
            return true;
        }
        return false;
    }
}
