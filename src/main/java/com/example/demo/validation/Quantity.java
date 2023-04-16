package com.example.demo.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = QuantityValidator.class)
public @interface Quantity {

    public String message() default "Your order quantity can not be less than 1!";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
